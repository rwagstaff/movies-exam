package ms.user;

import java.util.Date;

import ms.AbstractEntity;
import ms.movie.Movie;

public class PurchasedMovies extends AbstractEntity {

    private Movie movie;
    private Date expired;

    public PurchasedMovies(Movie movie, Date expired) {
        super();
        this.movie = movie;
        this.expired = expired;
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getExpired() {
        return expired;
    }

    public boolean isExpired() {
        return expired != null && expired.before(new Date());
    }

}
