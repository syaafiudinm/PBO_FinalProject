package project;
import java.util.Scanner;

public class SuwitJawa extends Suwit {
    private static final Scanner scanner = new Scanner(System.in);

    public SuwitJawa(String nickname) {
        initializeGame();
        this.playerChoice = nickname;
    }

    @Override
    public void initializeGame() {
        this.choices = new String[]{"gajah", "semut", "manusia"};
    }

    @Override
    void playGame() {
        System.out.print("Pilih gajah, semut, atau manusia: ");
        this.playerChoice = scanner.next().toLowerCase();

        generateComputerChoice();

        if (playerChoice.equals(computerChoice)) {
            displayResult("Seri!");
        } else if ((playerChoice.equals("manusia") && computerChoice.equals("semut")) ||
                (playerChoice.equals("semut") && computerChoice.equals("gajah")) ||
                (playerChoice.equals("gajah") && computerChoice.equals("manusia"))) {
            displayResult("Player wins");
        } else {
            displayResult("Computer wins");
        }
    }
}
