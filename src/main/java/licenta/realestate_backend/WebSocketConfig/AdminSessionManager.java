package licenta.realestate_backend.WebSocketConfig;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class AdminSessionManager {
    private static boolean adminConnected = false;

    public boolean isAdminConnected() {
        return adminConnected;
    }

    public void setAdminConnected(boolean connected) {
        adminConnected = connected;
    }
}
