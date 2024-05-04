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

    @Column(name = "id_property", nullable = false)
    private Long id_property;

    @Column(name = "toAddress")
    private String toAddress;

    @Column(name = "fromAddress")
    private String fromAddress;

    @Column(name = "transaction_time")
    private float transaction_time;

    public Transaction(String hash_transaction, Date transaction_date, Float priceETH, Long id_property, String toAddress, String fromAddress, float transaction_time) {
        this.hash_transaction = hash_transaction;
        this.transaction_date = transaction_date;
        this.priceETH = priceETH;
        this.id_property = id_property;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.transaction_time=transaction_time;
    }
}
