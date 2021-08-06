import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int ID;
    private int[] dateOfBirth = new int[3];
    private int gradeLevel;
    private int lastDayOfAttendance;
    private List<Class> classes = new ArrayList<>();
    private float overallGrade;

    Student(String name, int ID, int[] dateOfBirth, int gradeLevel, int lastDayOfAttendance, List<Class> classes){

        this.name = name;
        this.ID = ID;
        this.dateOfBirth = dateOfBirth;
        this.gradeLevel = gradeLevel;
        this.lastDayOfAttendance = lastDayOfAttendance;
        this.classes = classes;
        this.overallGrade = getOverallGrade();

    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public int getID(){
        return this.ID;
    }
    public void setID(int newID){
        this.ID = newID;
    }

    public int[] getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(int[] dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public int getGradeLevel(){
        return this.gradeLevel;
    }
    public void setGradeLevel(int newGradeLevel){
        this.gradeLevel = newGradeLevel;
    }

    public int getLastDayOfAttendance(){
        return this.lastDayOfAttendance;
    }
    public void setLastDayOfAttendance(int newLastDayOfAttendance){
        this.lastDayOfAttendance = newLastDayOfAttendance;
    }

    public List<Class> getClasses(){
        return this.classes;
    }
    public void setClasses(List<Class> newClasses){
        this.classes = newClasses;     
    }

    public float getOverallGrade(){
        setOverallGrade();
        return this.overallGrade;
    }
    public void setOverallGrade(){
        float grades = 0;

        for (Class class1 : classes) {
            grades += class1.getGrade();
        }

        this.overallGrade = 100 * (grades / (this.classes.size() * 100));
    }
}