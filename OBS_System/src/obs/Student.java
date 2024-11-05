/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obs;

/**
 *
 * @author STUDENT
 */
public class Student {
    private String ID;
    private String Name;
    private String Surname;
    private Gradebook gb;
    private static int ID_Counter = 1;

    public Student(String Name, String Surname) {
        this.ID = ID_Counter+"";
        this.Name = Name;
        this.Surname = Surname;
        ID_Counter++;
        this.gb = new Gradebook();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    
    public String printGrades(){
        return gb.toString();
    }
    
    public void addGrade(double percentage, int grade) throws InvalidPercentageException{
        this.gb.addGrade(new Grade(grade,percentage));
    }
    
    @Override
    public String toString(){
        return this.ID+ " " + this.Name + " " + this.Surname + "\n" + printGrades();
    }
}
