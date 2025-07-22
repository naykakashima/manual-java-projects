package Presentation.Helpers;

import java.util.Scanner;

public class InputValidators
{
    public static double ValidateInputInt(String promptMessage){
        Scanner sc = new Scanner(System.in);
        double result;

        while(true){
            System.out.println(promptMessage);
            String userInput = sc.nextLine();

            if (isInt(userInput)){
                result = Integer.parseInt(userInput);

                if (result < 0){
                    System.out.println("Please enter a positive integer.");
                    continue;
                }

                return result;
            }

            System.out.println("Invalid Input! Please try again.");
        }
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
