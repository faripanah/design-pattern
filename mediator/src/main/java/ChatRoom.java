//concrete mediator
import java.util.HashMap;
import java.util.Map;
public class ChatRoom implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String message, String fromUser, String toUser) {
        ChatClient recipient = clients.get(toUser);
        if (recipient != null) {
            recipient.recieveMessage(fromUser+ ":" + message);
        }else{
            ChatClient sender = clients.get(fromUser);
            if (sender != null) {
                sender.recieveMessage("didt send message"+ toUser);
            }
        }
    }
    @Override
    public void registerClient(ChatClient client){
        clients.put(client.getUsername(), client);
    }
}
