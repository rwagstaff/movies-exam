package ms.user;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.billing.Card;
import ms.movie.Movie;

public class Profile {

    private List<PurchasedMovies> moviesPurchased;
    private Card cardDetails;

    public Profile(Card cardDetails) {
        super();
        this.cardDetails = cardDetails;
    }

    public void purchase(Movie movie, Subscribed subscribed) {
        getPurchasedMovies().add(new PurchasedMovies(movie, determineExpiryDate(subscribed)));
    }

    public Card getCardDetails() {
        return cardDetails;
    }

    public List<PurchasedMovies> getPurchasedMovies() {
        if (moviesPurchased == null) {
            moviesPurchased = new ArrayList<PurchasedMovies>();
        }
        return moviesPurchased;
    }

    private Date determineExpiryDate(Subscribed subscribed) {
        if (!subscribed.isSubscribed()) {
            // Expires in 30 days
            return toDate(LocalDateTime.now().plusMonths(1));
        } else {
            // Never expires
            return null;
        }
    }

    private static Date toDate(LocalDateTime ldt) {
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

}
