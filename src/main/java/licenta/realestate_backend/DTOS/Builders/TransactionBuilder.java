package licenta.realestate_backend.DTOS.Builders;

import licenta.realestate_backend.DTOS.TransactionDTO;
import licenta.realestate_backend.Entities.Transaction;

public class TransactionBuilder {

    private TransactionBuilder(){

    }

    public static TransactionDTO toTransactionDTO(Transaction transaction){
        return new TransactionDTO(
                transaction.getTransactionID(),
                transaction.getHash_transaction(),
                transaction.getTransaction_date(),
                transaction.getPriceETH(),
                transaction.getId_property(),
                transaction.getToAddress(),
                transaction.getFromAddress(),
                transaction.getTransaction_time()
        );
    }

    public static Transaction toEntity(TransactionDTO transactionDTO){
        return new Transaction(
                transactionDTO.getTransactionID(),
                transactionDTO.getHash_transaction(),
                transactionDTO.getTransaction_date(),
                transactionDTO.getPriceETH(),
                transactionDTO.getId_property(),
                transactionDTO.getToAddress(),
                transactionDTO.getFromAddress(),
                transactionDTO.getTransaction_time()
        );
    }

}
