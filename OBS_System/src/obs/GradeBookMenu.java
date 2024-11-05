/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STUDENT
 */
public class GradeBookMenu {
    private static List<Student> students;

    public GradeBookMenu() throws InvalidMenuSelectionException {
        this.students = new ArrayList<>();
        displayMenu();
    }
    
    public static void displayMenu() throws InvalidMenuSelectionException{
        try{
            int i=0;
            do{
            System.out.println("Welcome to Gradebook System!");
            System.out.println("Please select one of the options below");
            System.out.println("1 - Add Student");
            System.out.println("2 - List Students");
            System.out.println("3 - Add Grade for a student");
            System.out.println("4 - Display a student");
            System.out.println("5 - Terminate");
            Scanner user_choice = new Scanner(System.in);
            i = user_choice.nextInt();
            if(i>5 || i<0){
                throw new InvalidMenuSelectionException("You should choose a value between 1 and 5. Try again.");
            }
            if(i==1){
                Scanner stu_obj = new Scanner(System.in);
                System.out.println("Enter name:");
                String name = stu_obj.nextLine();
                System.out.println("Enter surname:");
                String surname = stu_obj.nextLine();
                Student stu = new Student(name,surname);
                students.add(stu);
            }
            else if(i==2){
                for(int count=0; count<students.size(); count++){
                    System.out.println(students.get(count).toString());
                }
            }
            else if(i==3){
                Scanner stu_obj = new Scanner(System.in);
                System.out.println("Enter name:");
                String name = stu_obj.nextLine();
                System.out.println("Enter surname:");
                String surname = stu_obj.nextLine();
                for(int count=0; count<students.size(); count++){
                    if(students.get(count).getName().equals(name) && 
                            students.get(count).getSurname().equals(surname)){
                        System.out.println("Enter the percentage of the grade:");
                        double perc = stu_obj.nextDouble();
                        System.out.println("Enter the grade (out of 100):");
                        int gr = stu_obj.nextInt();
                        students.get(count).addGrade(perc, gr);
                    }
                }
            }
            else if(i==4){
                Scanner stu_obj = new Scanner(System.in);
                System.out.println("Enter the name of the student:");
                String name = stu_obj.nextLine();
                System.out.println("Enter the surname of the student:");
                String surname = stu_obj.nextLine();
                for(int count=0; count<students.size(); count++){
                    if(students.get(count).getName().equals(name) && 
                            students.get(count).getSurname().equals(surname)){
                        System.out.println(students.get(count).toString());
                    }
                }
            }
            }
            while(i!=5);
        }
        catch(InvalidMenuSelectionException e){

        } catch (InvalidPercentageException ex) {
            System.out.println("Error.");
        }
    }
}
