package project;
import java.util.Random;

abstract class Suwit {
    protected String[] choices;
    protected String playerChoice;
    protected String computerChoice;
    protected String result;

    public abstract void initializeGame();

    abstract void playGame();

    public String getResult() {
        return result;
    }

    protected void generateComputerChoice() {
        Random random = new Random();
        computerChoice = choices[random.nextInt(choices.length)];
        System.out.println("Komputer memilih: " + computerChoice);
    }

    protected void displayResult(String result) {
        this.result = result;
        System.out.println("Hasil: " + result);
    }
}
