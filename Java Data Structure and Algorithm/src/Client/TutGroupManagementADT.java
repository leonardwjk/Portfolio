/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import ADT.SortedListInterface;
import Entity.Student;
import ADT.TutGroupManagement;
import java.util.Scanner;
/**
 *
// * @author user
 */
public class TutGroupManagementADT {
    
    public static void main(String[] args) {

            
    Scanner scanner = new Scanner(System.in);
    
    TutGroupManagement<Student> tutGroup = new TutGroupManagement<>();
    TutGroupManagement<Student> tutGroup2 = new TutGroupManagement<>();
     
    
    //hardcode students
        tutGroup.add(new Student(2204093, "Leonard Wong Ji Kin"));
        tutGroup.add(new Student(2204105, "Tho Hui Teng"));
        tutGroup.add(new Student(2204084, "Aloysius Fan Wen Shuen"));
        tutGroup.add(new Student(2204089, "Chong Jian Feng"));

        
       tutGroup2.add(new Student(2204106, "Belle Lim"));
       tutGroup2.add(new Student(2204107, "Coco Ong"));
       tutGroup2.add(new Student(2204108, "Derek Chan"));
       tutGroup2.add(new Student(2204111, "Elle Tan"));
       tutGroup2.add(new Student(2204115, "James Ong"));
       tutGroup2.add(new Student(2204112, "Henry Tan"));
       tutGroup2.add(new Student(2204116, "Sean Hew"));
         
       boolean exit = false;
       
            while (!exit) {
            System.out.println("\nMENU:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List Student Info");
            System.out.println("4. Find Student");
            System.out.println("5. Filter Students");
            System.out.println("6. Change Student Tutorial Group");
            System.out.println("7. Generate Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
              case 1:
                    System.out.print("Enter Student ID to add : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Student Name to add : ");
                    String name = scanner.nextLine();

                    int group;
                    boolean validGroup = false;
                    while (!validGroup) {
                        System.out.print("Select which Tutorial Group to add the Student to (Enter 1 or 2) : ");
                        group = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (group == 1) {
                            tutGroup.add(new Student(id, name));
                            validGroup = true; // Exit the loop if the group is valid
                        } else if (group == 2) {
                            tutGroup2.add(new Student(id, name));
                            validGroup = true; // Exit the loop if the group is valid
                        } else {
                            System.out.println("Invalid group. Please enter 1 or 2.");
                        }
                    }
                    System.out.println("Student ID : " + id + ", Name : " + name + " has been successfully added.");
                            break;
                    
                case 2 :
                    System.out.print("Enter Tutorial Group(1 or 2): ");
                        int rGroup = scanner.nextInt();
                            if (rGroup == 1){
                                tutGroup.list();
                                System.out.println("Enter Student ID you wish to remove : ");
                                int id2 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter Student Name you wish to remove : ");
                                String name2 = scanner.nextLine();
                                   
                                tutGroup.remove(new Student(id2,name2));
                                
                                System.out.println("Updated RSW TUTORIAL GROUP 1");
                                System.out.println("");
                                    tutGroup.list();
                                    System.out.println("Student ID : " + id2 + ", Name : " + name2 + " has been successfully remove");
                            }
                            
                            
                            else if (rGroup == 2){
                                tutGroup2.list();
                                System.out.println("Enter Student ID you wish to remove : ");
                                int id2 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter Student Name you wish to remove : ");
                                String name2 = scanner.nextLine();
                                   
                                tutGroup2.remove(new Student(id2,name2));
                                
                                System.out.println("Updated RSW TUTORIAL GROUP 2");
                                System.out.println("");
                                    tutGroup2.list();
                                    System.out.println("Student ID : " + id2 + ", Name : " + name2 + "has been successfully remove");
                            }
                            
                        
                    break;
                    
                case 3 : 
                       System.out.print("Select the tutorial group (1 or 2) that you will like to list out(Enter 3 to list both : ");
                            int listgroup = scanner.nextInt();
                                if(listgroup == 1){
                                    System.out.println("RSW TUTORIAL GROUP 1");
                                    tutGroup.list();
                                }
                                
                                else if(listgroup == 2){
                                    System.out.println("RSW TUTORIAL GROUP 2");
                                    tutGroup2.list();
                                }
                                
                                else if(listgroup == 3){
                                    System.out.println("RSW TUTORIAL GROUP 1");
                                    tutGroup.list();
                                    System.out.println("");
                                    System.out.println("RSW TUTORIAL GROUP 2");
                                    tutGroup2.list();
                                }
                                break;
                                
                case 4 : 
                      System.out.println("FIND STUDENT : ");
                      System.out.print("Enter the ID to find: ");
                            int idToFind = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            Student foundStudent1 = tutGroup.find(idToFind);
                            Student foundStudent2 = tutGroup2.find(idToFind);

                            if (foundStudent1 != null) {
                             System.out.println("Student Found in Group 1 - ID: " + foundStudent1.getIdNo() + ", Name: " + foundStudent1.getName());
                         }

                         if (foundStudent2 != null) {
                              System.out.println("Student Found in Group 2 - ID: " + foundStudent2.getIdNo() + ", Name: " + foundStudent2.getName());
                            }

                            if (foundStudent1 == null && foundStudent2 == null) {
                             System.out.println("Student not found in both groups.");
                         }
                        break;
                        
                case 5 :
                    System.out.print("Enter the ID prefix to filter students: "); // Use print instead of println
                    String idPrefix = scanner.nextLine(); // Read the input for filtering
                    System.out.println("Filtered Students in Group 1:");
                    tutGroup.filter(idPrefix);
                    System.out.println("Filtered Students in Group 2:");
                    tutGroup2.filter(idPrefix);
                    break;
                    
                case 6 :
                    System.out.print("Change Student Tutorial Group");
                    System.out.println("RSW TUTORIAL GROUP 1");
                    tutGroup.list();
                    System.out.println("");
                    System.out.println("RSW TUTORIAL GROUP 2");
                    tutGroup2.list();
                    System.out.print("Enter Student ID: ");
                    int id2 = scanner.nextInt();
                    
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = scanner.nextLine();

                    Student studentToMove = new Student(id2, name2);

                    boolean movedToGroup1 = tutGroup.Change(studentToMove, tutGroup2);
                    boolean movedToGroup2 = false;

                    if (!movedToGroup1) {
                        // If the student wasn't moved to group 1, try moving to group 2
                        movedToGroup2 = tutGroup2.Change(studentToMove, tutGroup);
                    }

                     // Print updated tutorial groups
                    System.out.println("Updated RSW TUTORIAL GROUP 1");
                    tutGroup.list();
                    System.out.println("Updated RSW TUTORIAL GROUP 2");
                    tutGroup2.list();

    break;
                case 7 :
                        System.out.println("*****************REPORT FOR RSW STUDENT********************");
                        System.out.println("Group 1");
                        tutGroup.generateReport();
                        System.out.println("Group 2");
                        tutGroup2.generateReport();
                        break;
               
                case 8:
                        // Exit the program
                        exit = true;
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
                    
    }
            }
    }


