package licenta.realestate_backend.Services;

import jakarta.persistence.EntityNotFoundException;
import licenta.realestate_backend.DTOS.Builders.TransactionBuilder;
import licenta.realestate_backend.DTOS.TransactionDTO;
import licenta.realestate_backend.Entities.Transaction;
import licenta.realestate_backend.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;
    }

    //GET ALL TRANSACTIONS
    public List<TransactionDTO> getAllTransactions(){
        List<Transaction> transactionList= transactionRepository.findAll();
        return transactionList.stream()
                .map(TransactionBuilder::toTransactionDTO)
                .collect(Collectors.toList());
    }

    //INSERT TRANSACTION
    public Long insertTransaction(TransactionDTO transactionDTO){
        transactionDTO.setToAddress("0xb05cC29daAa38c35b66C135FF514A4b1f671ef64");
        Transaction transaction= TransactionBuilder.toEntity(transactionDTO);
        transaction=transactionRepository.save(transaction);
        System.out.println("Transaction with id " + transaction.getTransactionID() + " was inserted in db " );
        return transaction.getTransactionID();
    }

    //DELETE TRANSACTION
    public void delete(Long id){
        Optional<Transaction> optionalTransaction= transactionRepository.findById(id);
        if(!optionalTransaction.isPresent()){
            throw new EntityNotFoundException("Transaction with ID:" + id + " not found!");
        }
        transactionRepository.deleteById(id);
    }

}
