package project;
import java.util.Scanner;


public class SuwitClassic extends Suwit {
    private static final Scanner scanner = new Scanner(System.in);
    public SuwitClassic(String nickname) {
        initializeGame();
        this.playerChoice = nickname;
    }

    @Override
    public void initializeGame() {
        this.choices = new String[]{"batu", "gunting", "kertas"};
    }

    @Override
    void playGame() {
        System.out.print("Pilih batu, kertas, atau gunting: ");
        this.playerChoice = scanner.next().toLowerCase();

        generateComputerChoice();

        if (playerChoice.equals(computerChoice)) {
            displayResult("Seri!");
        } else if ((playerChoice.equals("batu") && computerChoice.equals("gunting")) ||
                (playerChoice.equals("gunting") && computerChoice.equals("kertas")) ||
                (playerChoice.equals("kertas") && computerChoice.equals("batu"))) {
            displayResult("Player wins");
        } else {
            displayResult("Computer wins");
        }
    }
}
