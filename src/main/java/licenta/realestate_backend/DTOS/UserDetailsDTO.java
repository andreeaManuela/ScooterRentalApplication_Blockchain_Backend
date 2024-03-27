package licenta.realestate_backend.DTOS;

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

    public UserDetailsDTO(){

    }

    public UserDetailsDTO(String name, String email, String password, String address, String phone, String walletAddress) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.phone=phone;
        this.walletAddress=walletAddress;

    }

    public UserDetailsDTO(Long id, String name, String email, String password, String address, String phone, String walletAddress) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.phone=phone;
        this.walletAddress=walletAddress;

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
}
