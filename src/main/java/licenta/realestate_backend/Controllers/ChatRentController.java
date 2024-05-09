package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.Entities.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Controller
public class ChatRentController {
    private final SimpMessagingTemplate messagingTemplate;
    private static boolean adminConnected = false;

    @Autowired
    public ChatRentController(SimpMessagingTemplate simpMessagingTemplate){
        this.messagingTemplate=simpMessagingTemplate;
    }

    //client -> admin
    @MessageMapping("/rentChat.clientRentAdmin")
    public void handleClientAskingRent(ChatMessage message){
        System.out.println("Clientul a trimis mesajul: " + message.toString());
        messagingTemplate.convertAndSend("/topic/clientAskingForRent", message);
    }

    //admin -> client
    @MessageMapping("/rentChat.adminResponse")
    public void handleAdminResponseToClient(ChatMessage message){
        System.out.println("Admin a raspuns: " + message);
        messagingTemplate.convertAndSend("/topic/adminResponding", message);
    }

    //Admin Connected
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        adminConnected = true;
        System.out.println("ADMIN CONECTAT!");
        messagingTemplate.convertAndSend("/topic/adminStatus", "connected");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        adminConnected = false;
        System.out.println("ADMIN DECONECTAT!");
        messagingTemplate.convertAndSend("/topic/adminStatus", "disconnected");
    }

}
