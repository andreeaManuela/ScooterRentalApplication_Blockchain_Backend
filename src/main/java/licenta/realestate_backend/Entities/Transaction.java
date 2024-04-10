package licenta.realestate_backend.Entities;

import java.util.Date;

public class Transaction {

    private Long id_contract;
    private Long id_property;
    private Long id_seller;
    private Long id_buyer;
    private String hash_transaction;
    private Date transaction_date;
    private Float price ;
}
