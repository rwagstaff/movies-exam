package ms.movie;

import java.util.Date;

import ms.AbstractEntity;
import ms.Buyable;
import ms.Money;

public class Movie extends AbstractEntity implements Buyable {

    private String name;
    private Genre genre;
    private Date releaseDate;
    private Money price;

    public Movie(String name, Genre genre, Date releaseDate) {
        super();
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public Money getPrice() {
        return price;
    }

}
