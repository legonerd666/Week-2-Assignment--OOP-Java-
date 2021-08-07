import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Creates a List to store all teachers, students, and classes
        List<Student> students = new ArrayList<>();
        List<TakeableClass> allClasses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();


        //Adds Teachers to the List of Teachers (Try making one yourself!)
        teachers.add(new Teacher("Alan Dickinson", teachers.size()+1));
        teachers.add(new Teacher("Rick Sanchez", teachers.size()+1));


        //Adds Classes to the List of Classes (Try making one yourself!)
        allClasses.add(new TakeableClass(teachers.get(0), "Math", null));
        allClasses.add(new TakeableClass(teachers.get(1), "Burping", null));


        //Adds Students to the List of Students (Try making one yourself!)
        
        int[] DOB1 = {2, 11, 1996};
        int[] LDA = {0, 0, 0};
        List<TakenClass> classes1 = new ArrayList<>();
        classes1.add(new TakenClass(allClasses.get(1), LDA));
        students.add(new Student("Bobbi", students.size()+1, DOB1, 1, classes1));
        allClasses.get(1).getStudents().add(students.get(0));

        int[] DOB2 = {16, 2, 1996};
        List<TakenClass> classes2 = new ArrayList<>();
        classes2.add(new TakenClass(allClasses.get(0), LDA));
        students.add(new Student("Jason Smith", students.size()+1, DOB2, 1, classes2));
        allClasses.get(0).getStudents().add(students.get(1));

        int[] DOB3 = {27, 8, 1996};
        students.add(new Student("Lenny", students.size()+1, DOB3, 1, classes1));
        allClasses.get(1).getStudents().add(students.get(2));



        //Begins the main program now that the students, classes, and teachers have been made
        mainScreen(students, allClasses, teachers);

    }

    public static void mainScreen(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){
        int userType = getInput("Hello! \nPlease enter your User Type:\n1. Student\n2. Teacher\n3. Admin", 3);
        switch (userType) {
            case 1:
                student(students, allClasses, teachers);
                break;
            
            case 2:
                teacher(students, allClasses, teachers);
                break;
            case 3:
                admin(students, allClasses, teachers);
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
    
    public static void student(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){

        int studentID = getInput("Please enter your student ID:", students.size());

        for (Student student : students) {
            if (student.getID() == studentID){
                System.out.println(student.toString());
            }
        }

        mainScreen(students, allClasses, teachers);;

    }

    public static void teacher(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){

        int input = getInput("What would you like to do:\n1. Look at Student Data\n2. Change Students Grades\n3. Change Students Latest Date of Attendance\n4. List Students by Teacher", 4);

        switch (input) {
            case 1:
                List<Student> sortedStudents = new ArrayList<>();
                for (Student student : students) {
                    sortedStudents.add(student);
                }
                sortedStudents = getSortedListOfStudents(sortedStudents, allClasses);
                int pickedStudentID = pickStudentByName(sortedStudents);
                System.out.println(sortedStudents.get(pickedStudentID-1));
                break;
            case 2:
                pickedStudentID = pickStudentByName(students);
                System.out.println("Please enter which teacher you are:");
                int signedInTeacher = pickTeacherByName(teachers);
                String classList = students.get(pickedStudentID-1).getClassesAsString();
                int classNum = getInput("Please enter which class you'd like to set the grades of:\n" + classList, students.get(pickedStudentID-1).getClasses().size());
                if (students.get(pickedStudentID-1).getClasses().get(classNum-1).getTeacher().getID() != signedInTeacher) {
                    System.out.println("I'm sorry, you don't teach that student.");
                } else {
                    int newGrade = getInputAllow0("Please enter what their grade should be (0-100):", 100);
                    students.get(pickedStudentID-1).getClasses().get(classNum-1).setGrade(newGrade);
                }
                break;
            case 3:
                pickedStudentID = pickStudentByName(students);
                System.out.println("Please enter which teacher you are:");
                signedInTeacher = pickTeacherByName(teachers);
                classList = students.get(pickedStudentID-1).getClassesAsString();
                classNum = getInput("Please enter which class you'd like to set attendance for:\n" + classList, students.get(pickedStudentID-1).getClasses().size());
                if (students.get(pickedStudentID-1).getClasses().get(classNum-1).getTeacher().getID() != signedInTeacher) {
                    System.out.println("I'm sorry, you don't teach that student.");
                } else {
                    int newLdaDay = getInput("Please enter the day they attended:", 31);
                    int newLdaMonth = getInput("Please enter the month they attended:", 12);
                    int newLdaYear = getInput("Please enter the year they attended:", 3000);
                    int[] newLatestAttendance = {newLdaDay, newLdaMonth, newLdaYear};
                    students.get(pickedStudentID-1).getClasses().get(classNum-1).setLastDayOfAttendance(newLatestAttendance);
                }
                break;
            case 4:
                int pickedTeacherID = pickTeacherByName(teachers);
                for (Student student : students) {
                    for (TakenClass takenClass : student.getClasses()) {
                        if (takenClass.getTeacher().getID() == pickedTeacherID){
                            System.out.println(student.toString());
                        }
                    }
                }
                break;
            
        }

        mainScreen(students, allClasses, teachers);;

    }

    public static void admin(List<Student> students, List<TakeableClass> allClasses, List<Teacher> teachers){

        System.out.println("You are an admin");

    }

    public static int pickStudentByName(List<Student> students){

        //Creates a String of all the students
        StringBuilder studentNames = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            if (i-1 < students.size()){
                studentNames.append((i+1) + ". " + students.get(i).getName() + "\n");
            } else{
                studentNames.append((i+1) + ". " + students.get(i).getName());
            }
            
        }

        //Gets user input and lists the students
        int input = getInput("Which student?\n" + studentNames, students.size());
        return input;

    }
    
    public static int pickTeacherByName(List<Teacher> teachers){


        //Creates a String of all the teachers
        StringBuilder teacherNames = new StringBuilder();
        for (int i = 0; i < teachers.size(); i++) {
            if (i-1 < teachers.size()){
                teacherNames.append((teachers.get(i).getID()) + ". " + teachers.get(i).getName() + "\n");
            } else{
                teacherNames.append((teachers.get(i).getID()) + ". " + teachers.get(i).getName());
            }
            
        }

        //Gets user input and prints the information of all the teachers
        int input = getInput("Which Teacher?\n" + teacherNames, teachers.size());
        return input;
    }

    public static List<Student> getSortedListOfStudents(List<Student> students, List<TakeableClass> allClasses){

        System.out.println("1. ID\n2. Name\n3. Class\n4. Grade");

        int input = getInput("Pick Sorting Method:", 4);

        switch (input) {
            case 2:
                Collections.sort(students, new Comparator<Student>(){
                    public int compare(Student s1, Student s2){
                        return s1.getName().compareTo(s2.getName());
                    }
                });
                break;
            case 3:
                List<Student> unsortedStudents = new ArrayList<>();
                for (TakenClass takeableClass : allClasses){
                    for (Student student : students) {
                        for (TakenClass takenClass : student.getClasses()) {
                            if (takenClass.getSubject() == takeableClass.getSubject()) {
                                unsortedStudents.add(student);
                                students.remove(student);
                            }
                        }
                    }
                }
                students = unsortedStudents;
                break;
            case 4:
                        
                break;
            
        }


        return students;

    }
}