package licenta.realestate_backend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionID", nullable = false)
    private Long transactionID;

    @Column(name="transaction_hash", nullable = false)
    private String hash_transaction;

    @Column(name="transaction_date", nullable = false)
    private Date transaction_date;

    @Column(name = "priceETH", nullable = false)
    private Float priceETH ;

    @Column(name = "id_scooter", nullable = false)
    private Long id_scooter;

    @Column(name = "toAddress")
    private String toAddress;

    @Column(name = "fromAddress")
    private String fromAddress;

    @Column(name = "transaction_time")
    private float transaction_time;

    @Column(name = "rent_period", nullable = false)
    private int rent_period;

    @Column(name = "type_transaction")
    private String type_transaction;

    public Transaction(String hash_transaction, Date transaction_date, Float priceETH, Long id_scooter, String toAddress, String fromAddress, float transaction_time, int rent_period, String type_transaction) {
        this.hash_transaction = hash_transaction;
        this.transaction_date = transaction_date;
        this.priceETH = priceETH;
        this.id_scooter = id_scooter;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.transaction_time=transaction_time;
        this.rent_period= rent_period;
        this.type_transaction=type_transaction;
    }
}
