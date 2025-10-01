//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int GROUP_SIZE = 3;

        // Create a recommendation using the builder pattern
        Director director = new Director();
        RecommendationBuilder builder = new RecommendationBuilder();
        director.constructSciFiRecommendation(builder);
        Recommendation sciFiRec = builder.getResult();

        System.out.println("Original Recommendation:");
        System.out.println(sciFiRec);

        // Create a group of recommendations by cloning the original
        System.out.println("\nCloned Recommendations:");
        for (int i = 0; i < GROUP_SIZE; i++) {
            Recommendation clonedRec = sciFiRec.clone();
            clonedRec.setTargetAudience("Sci-Fi Group " + (i + 1));
            System.out.println(clonedRec);
        }

        }
    }
