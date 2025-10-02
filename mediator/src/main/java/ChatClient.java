//client
public interface ChatClient {
    void sendMessage(String message, String fromUser, String toUser);
    void recieveMessage(String message);
    String getUsername();
}
