import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int userType = getInput("Hello! \nPlease enter your User Type: ", 3);
        switch (userType) {
            case 1:
                student();
                break;
            
            case 2:
                teacher();
                break;
            case 3:
                admin();
                break;
        }

    }

    public static int getInput(String text, int numInputs){

        //Allows us to get input from the user
        Scanner scan = new Scanner(System.in);

        System.out.println(text);
        String input = scan.nextLine();


        //Makes sure there are no errors converting input to an integer
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }

        //Makes sure the input is within the number of inputs allowed
        if (Integer.parseInt(input) > numInputs || Integer.parseInt(input) < 1){
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }
        scan.close();

        //Returns the input as an integer
        return Integer.parseInt(input);

    }
    
    public static void student(){

        System.out.println("You are a student");

    }

    public static void teacher(){

        System.out.println("You are a teacher");

    }

    public static void admin(){

        System.out.println("You are an admin");

    }
    
}