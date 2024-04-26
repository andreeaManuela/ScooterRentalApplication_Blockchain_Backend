package licenta.realestate_backend.Repositories;

import licenta.realestate_backend.Entities.Property;
import licenta.realestate_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query(value = "SELECT p " +
            "FROM Property p " +
            "WHERE p.type = 'RENT' ")
    List<Property> getRentProperties();

    @Query(value = "SELECT p " +
            "FROM Property p " +
            "WHERE p.type = 'SALE' ")
    List<Property> getPropertiesBySale();

    @Query(value = "SELECT p " +
            "FROM Property p " +
            "WHERE p.name = :name ")
    Optional<Property> updateProperty(@Param("name") String name);

}
