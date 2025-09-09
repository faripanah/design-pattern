import java.util.Random;

public class DiceGame extends Game{
    private int[] playerScores;     // keeps track of scores
    private int winningScore = 20;  // target score
    private int winner = -1;        // store winner index
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        playerScores = new int[numberOfPlayers];
        System.out.println("Dice Game started with " + numberOfPlayers + " players!");
        System.out.println("First to reach " + winningScore + " points wins.\n");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;  // game ends when a winner is found
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;  // roll dice (1–6)
        playerScores[player] += roll;
        System.out.println("Player " + (player + 1) + " rolled " + roll +
                " (total: " + playerScores[player] + ")");

        if (playerScores[player] >= winningScore) {
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\nPlayer " + (winner + 1) + " wins with "
                + playerScores[winner] + " points!");
    }
}
