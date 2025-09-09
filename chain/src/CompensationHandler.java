public class CompensationHandler  extends FeedbackHandler{
    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("CompensationHandler: Reviewing compensation claim from " + message.getSenderEmail());
            // logic: approve/reject claim
            System.out.println("CompensationHandler: Claim processed. Response sent.\n");
        } else {
            System.out.println("CompensationHandler: Passing to next handler...");
            super.process(message);
        }
    }
}
