package licenta.realestate_backend.Repositories;

import licenta.realestate_backend.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
