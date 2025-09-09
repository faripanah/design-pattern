public class GeneralFeedbackHandler extends FeedbackHandler{
    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.GENERAL) {
            System.out.println("GeneralFeedbackHandler: Analyzing feedback from " + message.getSenderEmail());
            System.out.println("GeneralFeedbackHandler: Thank you message sent.\n");
        } else {
            System.out.println("GeneralFeedbackHandler: Passing to next handler...");
            super.process(message);
        }
    }
}
