package licenta.realestate_backend.Entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessage {

    private Long id_client;
    private String message;

    public ChatMessage(){

    }

    public ChatMessage(Long id_client, String message){
        this.id_client=id_client;
        this.message=message;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id_client=" + id_client +
                ", message='" + message + '\'' +
                '}';
    }
}
