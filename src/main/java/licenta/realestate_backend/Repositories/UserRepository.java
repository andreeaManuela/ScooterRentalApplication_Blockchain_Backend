package licenta.realestate_backend.Repositories;

import licenta.realestate_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT p " +
            "FROM User p " +
            "WHERE p.email = :email " +
            "AND p.password = :password  ")
    Optional<User> functionLogin(@Param("email") String username, @Param("password") String password);


}



