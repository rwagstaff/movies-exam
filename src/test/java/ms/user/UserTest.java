package ms.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import ms.billing.Card;
import ms.movie.Genre;
import ms.movie.Movie;

import org.junit.Test;

public class UserTest {

    @Test
    public void shouldConstruct() {
        User user = createUser(false);
        assertNotNull(user);
    }

    public static User createUser(Boolean subscribed) {
        return new User("name", "email", subscribed, new Profile(new Card("sortCode", "cardNumber", new Date())));
    }

    @Test
    public void shouldPurchaseMovie() {
        User user = createUser(false);
        user.purchase(new Movie("name", Genre.ACTION, new Date()));
        assertFalse(user.getProfile().getPurchasedMovies().isEmpty());
        assertNotNull("Movie should have expiry date", user.getProfile().getPurchasedMovies().get(0).getExpired());
    }

    @Test
    public void registeredUserMovie_DoesNotExpire() {
        User user = createUser(true);
        user.purchase(new Movie("name", Genre.ACTION, new Date()));
        assertNull("Movie should NOT have expiry date", user.getProfile().getPurchasedMovies().get(0).getExpired());
    }
}
