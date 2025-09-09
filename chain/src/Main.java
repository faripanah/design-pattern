//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Build chain
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler contactHandler = new ContactHandler();
        FeedbackHandler suggestionHandler = new SuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        FeedbackHandler primaryHandler = compensationHandler;

        // Test with different messages
        Message m1 = new Message(MessageType.COMPENSATION, "I want a refund for my last order.", "alice@example.com");
        Message m2 = new Message(MessageType.CONTACT, "Please call me about my account.", "bob@example.com");
        Message m3 = new Message(MessageType.SUGGESTION, "Add dark mode to the app.", "carol@example.com");
        Message m4 = new Message(MessageType.GENERAL, "Great service, keep it up!", "dave@example.com");

        primaryHandler.process(m1);
        primaryHandler.process(m2);
        primaryHandler.process(m3);
        primaryHandler.process(m4);

        }
    }
