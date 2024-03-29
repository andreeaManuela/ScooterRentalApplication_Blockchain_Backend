package licenta.realestate_backend.Services;

import licenta.realestate_backend.DTOS.Builders.UserBuilder;
import licenta.realestate_backend.DTOS.UserDTO;
import licenta.realestate_backend.DTOS.UserDetailsDTO;
import licenta.realestate_backend.Entities.User;
import licenta.realestate_backend.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    //LOGIN
    public UserDTO findByUsernameAndPassword(UserDTO userDTO){
        Optional<User> userOptional= userRepository.functionLogin(userDTO.getEmail(), userDTO.getPassword());

        if(!userOptional.isPresent()){
            LOGGER.error("User with this name was not found!");
        }
        return UserBuilder.toUserDTO(userOptional.get());

    }


    public Long insert(UserDetailsDTO userDetailsDTO){
        User user= UserBuilder.toEntity(userDetailsDTO);
        user=userRepository.save(user);
        LOGGER.debug("User with id {} was inserted in db", user.getId());
        return user.getId();

    }

}
