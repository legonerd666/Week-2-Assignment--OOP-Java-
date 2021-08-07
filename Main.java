import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Class> classes = new ArrayList<>();
        int[] LDA = {0, 0, 0};
        classes.add(new Class("Alan Dickinson", "Math", LDA));
        int[] DOB = {16, 2, 1996};
        students.add(new Student("Jason Smith", students.size()+1, DOB, 1, classes));

        mainScreen(students, classes);

    }

    public static void mainScreen(List<Student> students, List<Class> classes){
        int userType = getInput("Hello! \nPlease enter your User Type:\n1. Student\n2. Teacher\n3. Admin", 3);
        switch (userType) {
            case 1:
                student(students, classes);
                break;
            
            case 2:
                teacher(students, classes);
                break;
            case 3:
                admin(students);
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

        //Returns the input as an integer
        return Integer.parseInt(input);

    }

    public static int getInputAllow0(String text, int numInputs){

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
        if (Integer.parseInt(input) > numInputs || Integer.parseInt(input) < 0){
            System.out.println("That is not a valid input.\nPlease enter a valid input.");
            input = String.valueOf(getInput(text, numInputs));
        }

        //Returns the input as an integer
        return Integer.parseInt(input);

    }
    
    public static void student(List<Student> students, List<Class> classes){

        int studentID = getInput("Please enter your student ID:", students.size());

        for (Student student : students) {
            if (student.getID() == studentID){
                System.out.println(student.toString());
            }
        }

        mainScreen(students, classes);;

    }

    public static void teacher(List<Student> students, List<Class> classes){

        int input = getInput("What would you like to do:\n1. Look at Student Data\n2. Change Students Grades\n3. Change Students Latest Date of Attendance", 4);

        switch (input) {
            case 1:
                int pickedStudentID = pickStudentByName(students);
                System.out.println(students.get(pickedStudentID-1));
                break;
            case 2:
                pickedStudentID = pickStudentByName(students);
                String classList = students.get(pickedStudentID-1).getClassesAsString();
                int classNum = getInput("Please enter which class you'd like to set the grades of:\n" + classList, classes.size());
                int newGrade = getInputAllow0("Please enter what their grade should be (0-100):", 100);
                students.get(pickedStudentID-1).getClasses().get(classNum-1).setGrade(newGrade);
                break;
            case 3:
                pickedStudentID = pickStudentByName(students);
                classList = students.get(pickedStudentID-1).getClassesAsString();
                classNum = getInput("Please enter which class you'd like to set attendance for:\n" + classList, classes.size());
                int newLdaDay = getInput("Please enter the day they attended:", 31);
                int newLdaMonth = getInput("Please enter the month they attended:", 12);
                int newLdaYear = getInput("Please enter the year they attended:", 3000);
                int[] newLatestAttendance = {newLdaDay, newLdaMonth, newLdaYear};
                students.get(pickedStudentID-1).getClasses().get(classNum-1).setLastDayOfAttendance(newLatestAttendance);
                break;
            case 4:
                
                break;
        }

        mainScreen(students, classes);;

    }

    public static void admin(List<Student> students){

        System.out.println("You are an admin");

    }

    public static int pickStudentByName(List<Student> students){

        StringBuilder studentNames = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            if (i-1 < students.size()){
                studentNames.append((i+1) + ". " + students.get(i).getName() + "\n");
            } else{
                studentNames.append((i+1) + ". " + students.get(i).getName());
            }
            
        }

        int input = getInput("Which student?\n" + studentNames, students.size());
        return input;

    }
    
}