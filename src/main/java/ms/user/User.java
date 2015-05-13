package ms.user;

import ms.AbstractEntity;
import ms.billing.Card;
import ms.billing.Payer;
import ms.movie.Movie;

public class User extends AbstractEntity implements Subscribed, Payer {

    private String name;
    private String email;
    private Boolean subscribed;
    private Profile profile;

    public User(String name, String email, Boolean subscribed, Profile profile) {
        super();
        this.name = name;
        this.email = email;
        this.subscribed = subscribed;
        this.profile = profile;
    }

    @Override
    public boolean isSubscribed() {
        return subscribed;
    }

    public void purchase(Movie movie) {
        profile.purchase(movie, this);
    }

    public Profile getProfile() {
        return profile;
    }

    @Override
    public Card paymentDetails() {
        return profile.getCardDetails();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
