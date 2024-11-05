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
public class Grade {
    private int grade;
    private double percentage;

    public Grade(int grade, double percentage) {
        this.grade = grade;
        this.percentage = percentage;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public String toString(){
        return this.grade + " " + this.percentage * 100 + " %";
    }
}
