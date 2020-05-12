package LabDataStructure.pqtest;

import java.sql.Date;

/**
 * An immutable class that represents an assignment.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Assignment implements Comparable<Assignment> {
     private String course;
    private String task;
    private Date date; // Due date
     public Assignment(String courseCode, String theTask, Date dueDate) {
        course = courseCode;
        task = theTask;
        date = dueDate;
    } // end constructor

    public String getCourseCode() {
        return course;
    } // end getCourseCode

    public String getTask() {
        return task;
    } // end getTask

    public Date getDueDate() {
        return date;
    } // end getDueDate

    @Override
    public String toString() {
        return date.toString() + " " + course + " " + task + "\n";
    } // end toString

    @Override
    public int compareTo(Assignment t) {
        return (this.date.compareTo(t.date));  
    }
} // end Assignment

