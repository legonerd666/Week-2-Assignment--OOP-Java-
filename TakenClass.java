public class TakenClass {
    
    private TakeableClass takenClass;
    private int grade;
    private int[] lastDayOfAttendance = new int[3];

    TakenClass(TakeableClass newTakeableClass, int[] newLastDayOfAttendance) {

        this.takenClass = newTakeableClass;
        this.lastDayOfAttendance = newLastDayOfAttendance;

    }

    public TakeableClass getTakenClass(){
        return this.takenClass;
    }

    public void setTakenClass(TakeableClass newTakenClass){
        this.takenClass = newTakenClass;
    }

    public int getGrade(){
        return this.grade;
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
        str.append("    Subject: " + this.takenClass.getSubject().toString() + "\n");
        str.append("    Teacher: " + this.takenClass.getTeacher().toString() + "\n");
        str.append("    Last Date of Attendance: " + getLastDayOfAttendanceDMY() + "\n");
        str.append("    Grade: " + this.grade + "/100\n\n");
        return str.toString();
    }

}
