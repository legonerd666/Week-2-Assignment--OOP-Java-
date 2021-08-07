public class Teacher {

    private String name;
    private int ID;

    Teacher(String newName, int newID){
        this.name = newName;
        this.ID = newID;
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

    @Override
    public String toString(){
        return this.name;
    }
    
}
