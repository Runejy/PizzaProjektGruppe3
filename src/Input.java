import java.util.Scanner;

public class Input {

    private static String userInput;

    private static final Scanner sc = new Scanner(System.in);

    private static int userInt;

    //Method for getting userInput when user should not pick from a list
    public static String getUserString() {

        try {
            userInput = sc.next();
            userInput += sc.nextLine();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }

        return userInput;
    }

    //method for getting userInput when user should pick from a list
    public static String getUserNumber(int numOptions) {

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

    //method for getting any number from user when not picking from a list
    public static String getUserNumber() {

        while(true) {

            //get user input as integer, making sure they enter a number
            try {
                userInt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Indtast venligst et gyldigt nummer");
                sc.nextLine();
                continue;
            }

            //convert userInt to String and return it
            return String.valueOf(userInt);
        }
    }

    //method for getting time as String of format "hh:mm"
    public static String getTime() {

      while(true) {

          userInput = getUserString();

          try {
              String[] time = userInput.split(":");

              int hours = Integer.parseInt(time[0]);
              int minutes = Integer.parseInt(time[1]);

              if ((hours > 23 || hours < 0) || (minutes > 59 || minutes < 0)) {
                  throw new Exception();
              }
          } catch (Exception e) {
              System.out.println("Indtast venligst et gyldigt tidspunkt!");
              continue;
          }
          break;
      }
        return userInput;
    }
}
