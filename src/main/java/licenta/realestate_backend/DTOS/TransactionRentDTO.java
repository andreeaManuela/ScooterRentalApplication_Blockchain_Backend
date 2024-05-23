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
public class TransactionRentDTO {
    private Long transactionRentId;

    private Long id_property;

    private String clientAddress;

    private Long id_client;

    private Date transaction_date;

    private Float price_rent ;

    private int rent_period;

    private String type_transaction;;

}
