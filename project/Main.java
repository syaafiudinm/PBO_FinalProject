package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isFirstRun = true;
        Profile userProfile = null;

        outerLoop:
        while (true) {
            if (isFirstRun || userProfile == null) {
                userProfile = Profile.inputProfile();
                isFirstRun = false;
            }

            System.out.println("\nInformasi Profil:");
            userProfile.printData();

            int playerWins = 0;
            int computerWins = 0;

            Suwit permainan;

            while (true) {
                System.out.println("\nPilih antara 1, 2, atau 3:");
                System.out.println("1. Suwit Classic");
                System.out.println("2. Suwit Jawa");
                System.out.println("3. Exit");
                System.out.print("Masukkan jenis permainan (1, 2, atau 3): ");
                int lastGameChoice = scanner.nextInt();

                switch (lastGameChoice) {
                    case 1:
                        permainan = new SuwitClassic(userProfile.getNickname());
                        break;
                    case 2:
                        permainan = new SuwitJawa(userProfile.getNickname());
                        break;
                    case 3:
                        System.out.println("Keluar dari permainan. Terima kasih!");
                        break outerLoop;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan masukkan lagi.");
                        continue;
                }

                while (playerWins < 2 && computerWins < 2) {
                    System.out.print("Putaran ke-" + (playerWins + computerWins + 1) + ": ");
                    permainan.playGame();

                    if (permainan.getResult().equals("Player wins")) {
                        playerWins++;
                    } else if (permainan.getResult().equals("Computer wins")) {
                        computerWins++;
                    }

                    System.out.println("Skor saat ini: " + userProfile.getNickname() + " " + playerWins + " - " + computerWins + " Computer");
                }

                System.out.println("Game over. Pemenangnya adalah: " + (playerWins == 2 ? userProfile.getNickname() : "Computer"));

                System.out.print("\nApakah Anda ingin bermain lagi? (y/n): ");
                char playAgain = scanner.next().charAt(0);

                if (playAgain != 'y' && playAgain != 'Y') {
                    break;
                } else {
                    playerWins = 0;
                    computerWins = 0;
                }
            }
        }

        scanner.close();
    }
}
