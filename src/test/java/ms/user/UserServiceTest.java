package ms.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import ms.billing.BillingException;
import ms.billing.BillingProvider;
import ms.billing.Confirmation;
import ms.movie.Genre;
import ms.movie.Movie;
import ms.movie.MovieService;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    private String userId = "id";
    private String movieId = "movieId";
    private Movie movie = new Movie("name", Genre.ACTION, new Date());
    private User user = UserTest.createUser(false);
    private UserRepository repository;
    private MovieService movieService;
    private BillingProvider provider;
    private UserService service;

    @Before
    public void createService() {
        repository = mock(UserRepository.class);
        provider = mock(BillingProvider.class);
        movieService = mock(MovieService.class);
        service = new UserService(repository, provider, movieService);
    }

    @Test
    public void shouldPurchaseMovie_AndReturnConfirmation() throws BillingException {
        when(repository.findById(userId)).thenReturn(user);
        when(movieService.findMovie(movieId)).thenReturn(movie);
        Confirmation expected = new Confirmation("invoiceId", "OK");
        when(provider.purchase(movie, user, user)).thenReturn(expected);
        Confirmation actual = service.purchase(userId, movieId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPurchaseMovie_AndFail() throws BillingException {
        when(repository.findById(userId)).thenReturn(user);
        when(movieService.findMovie(movieId)).thenReturn(movie);
        Confirmation expected = new Confirmation(null, "Could not complete purchase!");
        when(provider.purchase(movie, user, user)).thenThrow(new BillingException());
        Confirmation actual = service.purchase(userId, movieId);
        assertEquals(expected, actual);
    }

}
