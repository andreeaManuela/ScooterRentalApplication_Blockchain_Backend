package licenta.realestate_backend.DTOS.Builders;

import licenta.realestate_backend.DTOS.TransactionRentDTO;
import licenta.realestate_backend.Entities.TransactionRent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TransactionRentBuilder {

    public static TransactionRentDTO toTransactionRentDTO(TransactionRent transactionRent){
        return new TransactionRentDTO(
                transactionRent.getTransactionRentId(),
                transactionRent.getId_property(),
                transactionRent.getClientAddress(),
                transactionRent.getId_client(),
                transactionRent.getTransaction_date(),
                transactionRent.getPrice_rent(),
                transactionRent.getRent_period()
        );
    }

    public static TransactionRent toEntity(TransactionRentDTO transactionRentDTO){
        return new TransactionRent(
                transactionRentDTO.getTransactionRentId(),
                transactionRentDTO.getId_property(),
                transactionRentDTO.getClientAddress(),
                transactionRentDTO.getId_client(),
                transactionRentDTO.getTransaction_date(),
                transactionRentDTO.getPrice_rent(),
                transactionRentDTO.getRent_period()
        );
    }

}
