package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.DTOS.UserDetailsDTO;
import licenta.realestate_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping()
    public ResponseEntity<Long> insertUser(@RequestBody UserDetailsDTO userDetailsDTO){
        System.out.println(userDetailsDTO);
        //Long userId= userService.insert(userDetailsDTO);
        //return new ResponseEntity<>(userId, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
