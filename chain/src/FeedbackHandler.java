public class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void process(Message message) {
        if (nextHandler != null) {
            nextHandler.process(message);
        } else {
            System.out.println("No handler found for message type: " + message.getType());
        }
    }
}
