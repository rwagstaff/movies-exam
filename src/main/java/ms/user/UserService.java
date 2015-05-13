package ms.user;

import ms.billing.BillingException;
import ms.billing.BillingProvider;
import ms.billing.Confirmation;
import ms.movie.Movie;
import ms.movie.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;
    private BillingProvider billingProvider;
    private MovieService movieService;

    @Autowired
    public UserService(UserRepository repository, BillingProvider billingProvider, MovieService movieService) {
        super();
        this.repository = repository;
        this.billingProvider = billingProvider;
        this.movieService = movieService;
    }

    public Confirmation purchase(String userId, String movieId) {
        Movie movie = movieService.findMovie(movieId);
        User user = repository.findById(userId);

        // Would probably happen on a separate thread
        Confirmation confirmation;
        try {
            confirmation = billingProvider.purchase(movie, user, user);
            user.purchase(movie);
        } catch (BillingException e) {
            // Do some error handling
            confirmation = new Confirmation(null, "Could not complete purchase!");
        }
        return confirmation;
    }

    public User findById(String id) {
        return repository.findById(id);
    }
}
