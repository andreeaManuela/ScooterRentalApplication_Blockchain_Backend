package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.UserDTO;
import licenta.realestate_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping()
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO){
        System.out.println("Asta am primit de la frontend:");
        System.out.println(userDTO.getEmail()+ userDTO.getPassword());
        UserDTO user= userService.findByUsernameAndPassword(userDTO);
        return new ResponseEntity(user, HttpStatus.OK);
    }




}
