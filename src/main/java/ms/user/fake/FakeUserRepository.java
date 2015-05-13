package ms.user.fake;

import java.util.Date;

import ms.billing.Card;
import ms.user.Profile;
import ms.user.User;
import ms.user.UserRepository;

import org.springframework.stereotype.Repository;

@Repository
public class FakeUserRepository implements UserRepository {

    @Override
    public User findById(String id) {
        return new User("Richard Wagstaff", "richard@email.com", false, new Profile(new Card("59-10-12", "59839322", new Date())));
    }

}
