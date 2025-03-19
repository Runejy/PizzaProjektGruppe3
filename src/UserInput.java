import java.util.Scanner;

public class UserInput {

    private static String userInput;

    private static final Scanner sc = new Scanner(System.in);

    //Method for getting userInput when user should not pick from a list
    public static String getUserString() {

        try {
            userInput = sc.nextLine();
        } catch (Exception e) {
            System.out.println("An error occured: " + e);
        }

        return userInput;
    }

    public static String getUserInt(int numOptions) {

        int userInt;

        while(true) {

            //get user input as integer, making sure they enter a number
            try {
                userInt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Indtast venligst et gyldigt nummer");
                sc.nextLine();
                continue;
            }

            //check if the users number is within the available options
            if (userInt > numOptions || userInt <= 0) {
                System.out.println("Indtast venligst et nummer mellem 1 og " + numOptions);
                continue;
            }

            //convert userInt to String and return it
            return String.valueOf(userInt);
        }

    }
}
