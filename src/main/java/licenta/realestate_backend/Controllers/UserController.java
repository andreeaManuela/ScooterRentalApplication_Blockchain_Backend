package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.UserDetailsDTO;
import licenta.realestate_backend.Services.EthereumAccountService;
import licenta.realestate_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

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

    @PostMapping()
    public ResponseEntity<Long> insertUser(@RequestBody UserDetailsDTO userDetailsDTO) {
        System.out.println(userDetailsDTO.toString());

        try {
            // Verifică dacă adresa Ethereum a fost furnizată
            String ethereumAddress = userDetailsDTO.getWalletAddress();
            if (ethereumAddress == null || ethereumAddress.isEmpty()) {
                // Dacă nu există o adresă de Ethereum, crează un cont nou
                ethereumAddress = ethereumAccountService.createNewAccount();
                userDetailsDTO.setWalletAddress(ethereumAddress);
            }
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        System.out.println("AFTER: " + userDetailsDTO.toString());
        Long userId= userService.insert(userDetailsDTO);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
        //return new ResponseEntity<>(HttpStatus.OK);


    }

}