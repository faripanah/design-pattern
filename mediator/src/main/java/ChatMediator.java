 //mediator
 public interface ChatMediator {
    void sendMessage(String message, String fromUser, String toUser);
    void registerClient(ChatClient client);
}
