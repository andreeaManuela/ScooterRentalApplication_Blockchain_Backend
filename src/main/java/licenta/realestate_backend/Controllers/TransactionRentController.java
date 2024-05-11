package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.PropertyDTO;
import licenta.realestate_backend.DTOS.TransactionDTO;
import licenta.realestate_backend.DTOS.TransactionRentDTO;
import licenta.realestate_backend.Services.TransactionRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/transactions_rent")
public class TransactionRentController {

    private final TransactionRentService transactionRentService;

    @Autowired
    public TransactionRentController(TransactionRentService transactionRentService){
        this.transactionRentService=transactionRentService;
    }

    //Get all transactions
    @GetMapping()
    public ResponseEntity<List<TransactionRentDTO>> getTransactionsRent(){
        List<TransactionRentDTO> list=transactionRentService.getAllTransactionsRent();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //Insert Transaction
    @PostMapping()
    public ResponseEntity<Long> insertTransactionRent(@RequestBody TransactionRentDTO transactionDTO){
        Long transactionID = transactionRentService.insert(transactionDTO);
        return new ResponseEntity<>(transactionID, HttpStatus.CREATED);
    }


}
