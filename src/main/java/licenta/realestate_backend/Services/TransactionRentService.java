package licenta.realestate_backend.Services;

import licenta.realestate_backend.DTOS.Builders.TransactionRentBuilder;
import licenta.realestate_backend.DTOS.TransactionRentDTO;
import licenta.realestate_backend.Entities.TransactionRent;
import licenta.realestate_backend.Repositories.TransactionRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionRentService {
    private final TransactionRentRepository transactionRentRepository;

    @Autowired
    public TransactionRentService(TransactionRentRepository transactionRentRepository){
        this.transactionRentRepository=transactionRentRepository;
    }

    //GetAll Transactions
    public List<TransactionRentDTO> getAllTransactionsRent(){
        List<TransactionRent> transactionList= transactionRentRepository.findAll();
        return transactionList.stream()
                .map(TransactionRentBuilder::toTransactionRentDTO)
                .collect(Collectors.toList());
    }

    //INSERT
    public Long insert(TransactionRentDTO transactionRentDTO){
        TransactionRent transactionRent= TransactionRentBuilder.toEntity(transactionRentDTO);
        transactionRent= transactionRentRepository.save(transactionRent);
        System.out.println("TransactionRent with id " + transactionRent.getTransactionRentId() + " was inserted in db " );
        return transactionRent.getTransactionRentId();

    }

}
