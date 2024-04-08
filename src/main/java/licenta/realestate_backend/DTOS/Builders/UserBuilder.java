package licenta.realestate_backend.DTOS.Builders;

import licenta.realestate_backend.DTOS.UserDTO;
import licenta.realestate_backend.DTOS.UserDetailsDTO;
import licenta.realestate_backend.Entities.User;

public class UserBuilder {

    private UserBuilder(){

    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getWalletAddress(), user.getRole());
    }

    public static UserDetailsDTO toUserDetailsDTO(User user) {
        return new UserDetailsDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getWalletAddress(), user.getRole());
    }

    public static User toEntity(UserDetailsDTO userDetailsDTO) {
        return new User( userDetailsDTO.getId(),
                userDetailsDTO.getName(),
                userDetailsDTO.getEmail(),
                userDetailsDTO.getPassword(),
                userDetailsDTO.getAddress(),
                userDetailsDTO.getPhone(),
                userDetailsDTO.getWalletAddress(),
                userDetailsDTO.getRole());
    }

}
