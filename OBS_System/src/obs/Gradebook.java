/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obs;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author STUDENT
 */
public class Gradebook {
    private List<Grade> grades;

    public Gradebook() {
        this.grades = new ArrayList<>();
    }
    
    public void addGrade(Grade grade) throws InvalidPercentageException {
        if(isTotalPercentageValid(grade.getPercentage())){
            grades.add(grade);
        }
        else throw new InvalidPercentageException("Total Percentage is bigger than 100");
    }
    
    private boolean isTotalPercentageValid(double newPercentage){
        double totalp = 0;
        for(int i=0; i<grades.size(); i++){
            totalp += grades.get(i).getPercentage();
        }
        return 1-(totalp + newPercentage) >= 0;
    }
    
    public double calculateAverage(){
        double totalp = 0;
        for(int i=0; i<grades.size(); i++){
            totalp += grades.get(i).getPercentage();
        }
        if(totalp!=1){
            return -1;
        }
        double total=0;
        for(int i=0; i<grades.size(); i++){
            total += grades.get(i).getGrade() * grades.get(i).getPercentage();
        }
        return total;
    }
    
    @Override
    public String toString(){
        String result = "";
        for(int i=0; i<grades.size(); i++){
            result += "Grade " + (i+1)+ ":" + grades.get(i) + "\n";
        }
        double avg = calculateAverage();
        if(avg!=-1){
            result += "Average: " + avg;
        }
        return result;
    }
}
