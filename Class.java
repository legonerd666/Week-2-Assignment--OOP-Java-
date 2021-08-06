public class Class {
    
    private String teacher;
    private String subject;
    private int grade;

    Class(String teacher, String subject) {

        this.teacher = teacher;
        this.subject = subject;

    }

    public String getTeacher(){
        return this.teacher;
    }
    public String getSubject(){
        return this.subject;
    }
    public int getGrade(){
        return this.grade;
    }

    public void setTeacher(String newTeacher){
        this.teacher = newTeacher;
    }
    public void setSubject(String newSubject){
        this.subject = newSubject;
    }
    public void setGrade(int newGrade){
        if (newGrade > 100 || newGrade < 0){
            System.out.println("That grade is invalid");
        } else{
            this.grade = newGrade;
        }
    }

}
