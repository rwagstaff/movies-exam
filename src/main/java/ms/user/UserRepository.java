package ms.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findById(String id);

}
