import java.util.Scanner;
public class Character {
    //attributes:
    private String name;
    private int level;
    private int exp;
    private int health;

    //interface to State:
    private State state;
    private Scanner scanner = new Scanner(System.in);

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.health = 100;
        this.state = new NoviceState(this);
    }
    //implement operations:
    public void setState(State state) {
        this.state = state;
    }

    public void addExp(int amount) {
        exp += amount;
        System.out.println("Exp + " + amount + " → " + exp);
    }

    public void addHealth(int amount) {
        health += amount;
        if (health > 100) health = 100;
        System.out.println("Health + " + amount + " → " + health);
    }

    public void reduceHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
        System.out.println("Health - " + amount + " → " + health);
}

public void levelUp() {
    level++;
    System.out.println("*** Level UP → " + level + " ***");
}

public void showStatus() {
    System.out.println("\n==== STATUS ====");
    System.out.println("Name: " + name);
    System.out.println("Level: " + level);
    System.out.println("Exp: " + exp);
    System.out.println("Health: " + health);
    System.out.println("===============");
}
    public int readChoice(String[] options) {
        System.out.println("\nChoose an option:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        return scanner.nextInt();
    }

    public void play() {
        while (!(state instanceof MasterState)) {
            showStatus();
            state.action();
        }
        System.out.println("🎉 " + name + " Finished the game and is now master!!!");
    }



    //getters
    public int getLevel() { return level; }
    public int getExp() { return exp; }
    public int getHealth() { return health; }



}
