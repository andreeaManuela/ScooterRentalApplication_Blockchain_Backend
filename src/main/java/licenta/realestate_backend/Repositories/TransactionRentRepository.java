package licenta.realestate_backend.Repositories;

import licenta.realestate_backend.Entities.TransactionRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRentRepository extends JpaRepository<TransactionRent, Long> {
}
