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

    private String transaction_hash;

    private Date transaction_date;

    private Float priceETH ;

    private Long id_scooter;

    private String toAddress;

    private String fromAddress;

    private float transaction_time;

    private int rent_period;;

    private String type_transaction;;


    public TransactionDTO(String transaction_hash, Date transaction_date, Float priceETH, Long id_scooter, String toAddress, String fromAddress, float transaction_time, int rent_period, String type_transaction) {
        this.transaction_hash = transaction_hash;
        this.transaction_date = transaction_date;
        this.priceETH = priceETH;
        this.id_scooter = id_scooter;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.transaction_time = transaction_time;
        this.rent_period=rent_period;
        this.type_transaction=type_transaction;
    }
}
