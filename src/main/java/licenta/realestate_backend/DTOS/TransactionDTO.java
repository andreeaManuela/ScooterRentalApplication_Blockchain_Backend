package licenta.realestate_backend.DTOS;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long transactionID;

    private String hash_transaction;

    private Date transaction_date;

    private Float priceETH ;

    private Long id_property;

    private String toAddress;

    private String fromAddress;

    public TransactionDTO(String hash_transaction, Date transaction_date, Float priceETH, Long id_property, String toAddress, String fromAddress) {
        this.hash_transaction = hash_transaction;
        this.transaction_date = transaction_date;
        this.priceETH = priceETH;
        this.id_property = id_property;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }
}
