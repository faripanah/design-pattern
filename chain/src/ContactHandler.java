public class ContactHandler extends FeedbackHandler{
    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.CONTACT) {
            System.out.println("ContactHandler: Forwarding contact request from " + message.getSenderEmail() + " to support team.");
            System.out.println("ContactHandler: Request processed. Confirmation sent.\n");
        } else {
            System.out.println("ContactHandler: Passing to next handler...");
            super.process(message);
        }
    }
}
