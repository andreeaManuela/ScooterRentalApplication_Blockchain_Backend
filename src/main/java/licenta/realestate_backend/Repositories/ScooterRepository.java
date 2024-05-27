package licenta.realestate_backend.Repositories;

import licenta.realestate_backend.Entities.Property;
import licenta.realestate_backend.Entities.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {
    @Query(value = "SELECT p " +
            "FROM Scooter p " +
            "WHERE p.zone = 'MARASTI' ")
    List<Scooter> getScootersMarasti();

    @Query(value = "SELECT p " +
            "FROM Scooter p " +
            "WHERE p.zone = 'MANASTUR' ")
    List<Scooter> getScootersManastur();


    @Query(value = "SELECT p " +
            "FROM Scooter p " +
            "WHERE p.zone = 'ZORILOR' ")
    List<Scooter> getScootersZorilor();


    @Query(value = "SELECT p " +
            "FROM Scooter p " +
            "WHERE p.zone = 'GHEORGHENI' ")
    List<Scooter> getScootersGheorgheni();


    @Query(value = "SELECT p " +
            "FROM Scooter p " +
            "WHERE p.zone = 'CENTRU' ")
    List<Scooter> getScootersCentru();

    @Query(value = "SELECT p " +
            "FROM Scooter p " +
            "WHERE p.name = :name ")
    Optional<Scooter> updateScooter(@Param("name") String name);

}
