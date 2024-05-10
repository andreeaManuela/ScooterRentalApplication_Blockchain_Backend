package licenta.realestate_backend.Controllers;

import licenta.realestate_backend.Entities.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatRentController {
    private final SimpMessagingTemplate messagingTemplate;

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
    @MessageMapping("/adminStatus")
    public void handleAdminToggleStatus(@Payload String status) {
        System.out.println("Status admin : " + status);
        messagingTemplate.convertAndSend("/topic/adminStatus", status); // Transmiterea statusului către toți abonații
    }



}
