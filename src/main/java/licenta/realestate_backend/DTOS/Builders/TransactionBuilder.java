package licenta.realestate_backend.DTOS.Builders;

import licenta.realestate_backend.DTOS.TransactionDTO;
import licenta.realestate_backend.Entities.Transaction;

public class TransactionBuilder {

    private TransactionBuilder(){

    }

    public static TransactionDTO toTransactionDTO(Transaction transaction){
        return new TransactionDTO(
                transaction.getTransactionID(),
                transaction.getTransaction_hash(),
                transaction.getTransaction_date(),
                transaction.getPriceETH(),
                transaction.getId_scooter(),
                transaction.getToAddress(),
                transaction.getFromAddress(),
                transaction.getTransaction_time(),
                transaction.getRent_period(),
                transaction.getType_transaction()
        );
    }

    public static Transaction toEntity(TransactionDTO transactionDTO){
        return new Transaction(
                transactionDTO.getTransactionID(),
                transactionDTO.getTransaction_hash(),
                transactionDTO.getTransaction_date(),
                transactionDTO.getPriceETH(),
                transactionDTO.getId_scooter(),
                transactionDTO.getToAddress(),
                transactionDTO.getFromAddress(),
                transactionDTO.getTransaction_time(),
                transactionDTO.getRent_period(),
                transactionDTO.getType_transaction()
        );
    }

}
