package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.TransactionDTO;
import licenta.realestate_backend.Services.PropertyService;
import licenta.realestate_backend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService=transactionService;
    }

    @GetMapping()
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(){
        List<TransactionDTO> list= transactionService.getAllTransactions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertTransaction(@RequestBody TransactionDTO transactionDTO){
        Long transactionID = transactionService.insertTransaction(transactionDTO);
        return new ResponseEntity<>(transactionID, HttpStatus.CREATED);
    }


    @DeleteMapping("/{transactionID}")
    public ResponseEntity<TransactionDTO> deleteTransaction(@PathVariable("transactionID") Long transactionID){
        try {
            transactionService.delete(transactionID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
