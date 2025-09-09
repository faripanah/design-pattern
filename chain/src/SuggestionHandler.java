public class SuggestionHandler extends FeedbackHandler{
    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.SUGGESTION) {
            System.out.println("SuggestionHandler: Logging suggestion from " + message.getSenderEmail());
            System.out.println("SuggestionHandler: Suggestion stored for review.\n");
        } else {
            System.out.println("SuggestionHandler: Passing to next handler...");
            super.process(message);
        }
    }
}
