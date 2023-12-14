package project;
import java.util.Scanner;

public class Profile {
    private String firstName;
    private String lastName;
    private String nickName;
    private Character sex;

    public Profile(String firstName, String nickName, char sex) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.sex = sex;
    }

    public Profile(String firstName, String lastName, String nickName, char sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.sex = sex;
    }



    public static Profile inputProfile() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your nickname: ");
        String nickName = scanner.nextLine();

        System.out.print("Enter your sex (M/F): ");
        char sex = scanner.nextLine().toUpperCase().charAt(0);


        if (lastName.isEmpty()) {
            return new Profile(firstName, nickName, sex);
        } else {
            return new Profile(firstName, lastName, nickName, sex);
        }
    }

    public String getNickname() {
        return nickName;
    }

    public void printData() {
        StringBuilder result = new StringBuilder();
        result.append("Your first name is: ").append(firstName);

        if (lastName != null) {
            result.append(", your last name is: ").append(lastName);
        }

        result.append(", your nickname is: ").append(nickName)
                .append(", your sex is: ").append(sex);
        System.out.println(result.toString());
    }
}
