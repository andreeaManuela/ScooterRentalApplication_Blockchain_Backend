package licenta.realestate_backend.Services;

import org.springframework.stereotype.Service;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Service
public class EthereumAccountService {

    private final Web3j web3j;

    public EthereumAccountService() {
        this.web3j = Web3j.build(new HttpService("http://localhost:8545"));
    }

    public String createNewAccount() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        ECKeyPair keyPair = Keys.createEcKeyPair();
        Credentials credentials = Credentials.create(keyPair);
        return credentials.getAddress();
    }
}
