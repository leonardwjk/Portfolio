/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Student implements Comparable<Student>{
    private int idNo;
    private String name;
    private String phoneNo;
    private Calendar entryDateTime;
    
   
    public Student(int idNo, String name) {
        this.idNo = idNo;
        this.name = name;
        this.entryDateTime = Calendar.getInstance();
    }

    
    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(Student otherStudent) {
        // Compare based on idNo
        if (this.idNo < otherStudent.idNo) {
            return -1;
        } else if (this.idNo > otherStudent.idNo) {
            return 1;
        }

        // If idNo is equal, compare based on name
        return this.name.compareTo(otherStudent.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return idNo == student.idNo && Objects.equals(name, student.name);
    }
    
    public String toString() {
    return "Student ID : " + idNo + " ---- Name : " + name ;
}
    
    public Calendar getEntryDateTime() {
        return entryDateTime;
    }

}