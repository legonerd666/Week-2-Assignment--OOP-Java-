public class Class {
    
    private String teacher;
    private String subject;
    private int grade;
    private int[] lastDayOfAttendance = new int[3];

    Class(String teacher, String subject, int[] lastDayOfAttendance) {

        this.teacher = teacher;
        this.subject = subject;
        this.lastDayOfAttendance = lastDayOfAttendance;

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

    public int[] getLastDayOfAttendance(){
        return this.lastDayOfAttendance;
    }
    public void setLastDayOfAttendance(int[] newLastDayOfAttendance){
        this.lastDayOfAttendance = newLastDayOfAttendance;
    }
    public String getLastDayOfAttendanceDMY(){
        StringBuilder str = new StringBuilder();
        str.append(this.lastDayOfAttendance[0] + ", ");
        str.append(this.lastDayOfAttendance[1] + ", ");
        str.append(this.lastDayOfAttendance[2]);
        return str.toString();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("    Subject: " + this.subject + "\n");
        str.append("    Teacher: " + this.teacher + "\n");
        str.append("    Last Date of Attendance: " + getLastDayOfAttendanceDMY() + "\n");
        str.append("    Grade: " + this.grade + "/100\n\n");
        return str.toString();
    }

}
