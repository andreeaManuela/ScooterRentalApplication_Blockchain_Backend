package licenta.realestate_backend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class TransactionRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_rent_id", nullable = false)
    private Long transactionRentId;

    @Column(name = "id_property", nullable = false)
    private Long id_property;

    @Column(name = "clientAddress")
    private String clientAddress;

    @Column(name = "id_client", nullable = false)
    private Long id_client;

    @Column(name = "transaction_date")
    private Date transaction_date;

    @Column(name = "price_rent", nullable = false)
    private Float price_rent ;

    @Column(name = "rent_period", nullable = false)
    private int rent_period;

    public TransactionRent(Long id_property, String clientAddress, Long id_client, Date transaction_date, Float price_rent, int rent_period) {
        this.id_property = id_property;
        this.clientAddress = clientAddress;
        this.id_client = id_client;
        this.transaction_date = transaction_date;
        this.price_rent = price_rent;
        this.rent_period = rent_period;
    }
}
