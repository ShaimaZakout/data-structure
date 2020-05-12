package LabDataStructure.pqtest;

import java.sql.Date;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.PriorityQueue;

/**
 * A class that represents a log of assignments ordered by priority.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AssignmentLog {

    private Queue<Assignment> log;
    private Queue<Assignment> log2;
    private Queue<Assignment> log3;

    public AssignmentLog() {
        log = new ArrayDeque<>();
        log2 = new ArrayDeque<>();
        log3 = new ArrayDeque<>();

    } // end constructor

    public void addProject(Assignment newAssignment) {
        log.add(newAssignment);
    }// end addProject

    public void addProject(String courseCode, String task, Date dueDate) {
        //        Assignment newAssignment=new Assignment(courseCode, task, dueDate);
        Assignment newAssignment = new Assignment(courseCode, task, dueDate);
        if (newAssignment.getTask().equals("femal")) {
            log.add(newAssignment);
        } else if (newAssignment.getTask().equals("sha")) {
            log2.add(newAssignment);
        } else {
            log3.add(newAssignment);
        }
        System.out.println(newAssignment);
    } // end addProject

    public Assignment getNextProject() {
        if (!log.isEmpty()) {
            Assignment s = log.peek();
            return s;
        } else if (!log2.isEmpty()) {
            Assignment s = log2.peek();
            return s;
        } else {
            Assignment s = log3.peek();
            return s;
        }
    } // end getNextProject

    public Assignment removeNextProject() {
        if (!log.isEmpty()) {
            Assignment s = getNextProject();
            log.remove();
            return s;
        } else if (!log2.isEmpty()) {
            Assignment s = log2.peek();
            log2.remove();
            return s;
        } else {
            Assignment s = log3.peek();
            log3.remove();
            return s;
        }

    } // end removeNextProject
} // end AssignmentLog
