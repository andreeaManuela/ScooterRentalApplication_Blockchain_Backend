package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.UserDTO;
import licenta.realestate_backend.Services.EthereumAccountService;
import licenta.realestate_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final EthereumAccountService ethereumAccountService;

    @Autowired
    public UserController(UserService userService, EthereumAccountService ethereumAccountService) {
        this.userService = userService;
        this.ethereumAccountService = ethereumAccountService;
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity<List<String>> getAccounts(){
        List<String> accounts= userService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(value = "/metamaskAddress/{id}")
    public ResponseEntity<String> getMetaMaskAddress(@PathVariable("id") Long id){
        String accounts= userService.getAddressMetamask(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertUser(@RequestBody UserDTO userDetailsDTO) {
        System.out.println(userDetailsDTO.toString());

//        try {
//            // Verifică dacă adresa Ethereum a fost furnizată
//            String ethereumAddress = userDetailsDTO.getWalletAddress();
//            if (ethereumAddress == null || ethereumAddress.isEmpty()) {
//                // Dacă nu există o adresă de Ethereum, crează un cont nou
//                ethereumAddress = ethereumAccountService.createNewAccount();
//                userDetailsDTO.setWalletAddress(ethereumAddress);
//            }
//        } catch (InvalidAlgorithmParameterException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchProviderException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("AFTER: " + userDetailsDTO.toString());
        Long userId= userService.insert(userDetailsDTO);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
        //return new ResponseEntity<>(HttpStatus.OK);


    }

}