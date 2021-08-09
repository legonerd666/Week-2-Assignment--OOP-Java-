import java.util.ArrayList;
import java.util.List;

public class TakeableClass {
    
    private Teacher teacher;
    private String subject;
    private List<Student> students;

    TakeableClass(Teacher teacher, String subject) {

        this.teacher = teacher;
        this.subject = subject;
        this.students = new ArrayList<>();

    }

    public Teacher getTeacher(){
        return this.teacher;
    }
    public String getSubject(){
        return this.subject;
    }
    
    public void setTeacher(Teacher newTeacher){
        this.teacher = newTeacher;
    }
    public void setSubject(String newSubject){
        this.subject = newSubject;
    }

    public List<Student> getStudents(){
        return this.students;
    }

    public void setStudents(List<Student> newStudents){
        this.students = newStudents;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("    Subject: " + this.subject + "\n");
        str.append("    Teacher: " + this.teacher.getName() + "\n");
        str.append("    Students:\n");
        for (Student student : students) {
            str.append("        Name: " + student.getName() + "\n");
            str.append("        ID: " + student.getID() + "\n\n");
        }
        return str.toString();
    }

}
