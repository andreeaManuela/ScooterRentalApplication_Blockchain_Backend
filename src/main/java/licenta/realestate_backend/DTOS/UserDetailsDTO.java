package licenta.realestate_backend.DTOS;

import licenta.realestate_backend.Enums.Role;
import org.antlr.v4.runtime.misc.NotNull;

public class UserDetailsDTO{
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @NotNull
    private String walletAddress;

    @NotNull
    private Role role;

    public UserDetailsDTO(){

    }

    public UserDetailsDTO(String name, String email, String password, String address, String phone, String walletAddress, Role role) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.phone=phone;
        this.walletAddress=walletAddress;
        this.role=role;
    }

    public UserDetailsDTO(Long id, String name, String email, String password, String address, String phone, String walletAddress, Role role) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.phone=phone;
        this.walletAddress=walletAddress;
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDetailsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", walletAddress='" + walletAddress + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
