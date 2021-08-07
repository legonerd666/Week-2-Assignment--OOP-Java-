import java.util.List;

public class TakeableClass {
    
    private Teacher teacher;
    private String subject;
    private List<Student> students;

    TakeableClass(Teacher teacher, String subject, List<Student> students) {

        this.teacher = teacher;
        this.subject = subject;
        this.students = students;

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
        return str.toString();
    }

}
