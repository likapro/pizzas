package pizzas.data;

import org.springframework.data.repository.CrudRepository;
import pizzas.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
