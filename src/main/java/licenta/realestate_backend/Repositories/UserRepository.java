package licenta.realestate_backend.Repositories;

import licenta.realestate_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
