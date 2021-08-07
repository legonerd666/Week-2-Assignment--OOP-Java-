public class TakenClass {
    
    private TakeableClass takeableClass;
    private int grade;
    private int[] lastDayOfAttendance = new int[3];

    TakenClass(TakeableClass newTakeableClass, int[] newLastDayOfAttendance) {

        this.takeableClass = newTakeableClass;
        this.lastDayOfAttendance = newLastDayOfAttendance;

    }

    public TakeableClass getTakeableClass(){
        return this.takeableClass;
    }

    public void setTakeableClass(TakeableClass newTakeableClass){
        this.takeableClass = newTakeableClass;
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
        str.append("    Subject: " + this.takeableClass.getSubject().toString() + "\n");
        str.append("    Teacher: " + this.takeableClass.getTeacher().toString() + "\n");
        str.append("    Last Date of Attendance (D, M, Y): " + getLastDayOfAttendanceDMY() + "\n");
        str.append("    Grade: " + this.grade + "/100\n\n");
        return str.toString();
    }

}
