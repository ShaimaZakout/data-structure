package LabDataStructure.pqtest;

import java.sql.Date;

/**
 * A driver that demonstrates the classes Assignment and AssignmentLog.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Driver {

    public static void main(String[] args) {
        AssignmentLog al = new AssignmentLog();
        System.out.println("ding these entries:");
        al.addProject("CSC211", "femal", Date.valueOf("2020-10-15"));
        al.addProject("CSC211", "maeal", Date.valueOf("2020-09-15"));
        al.addProject("CSC211", "femal", Date.valueOf("2020-09-30"));
        al.addProject("CSC211", "femal", Date.valueOf("2020-09-30"));
        al.addProject("CSC211", "maeal", Date.valueOf("2020-10-01"));
        al.addProject("CSC211", "sha", Date.valueOf("2020-09-30"));
        al.addProject("CSC211", "femal", Date.valueOf("2020-09-30"));
         al.addProject("CSC211", "sha", Date.valueOf("2020-09-30"));
        al.addProject("CSC211", "femal", Date.valueOf("2020-09-30"));
        System.out.println(" First entry should be  \n" + al.getNextProject());
         System.out.println("Log contains"); 
//          while (al.getNextProject() != null) {
//             System.out.println(al.removeNextProject());
//        }
//         System.out.println("/////////////////");
    al.addProject("CSC211", "maeal", Date.valueOf("2020-09-15"));
        al.addProject("CSC211", "maeal", Date.valueOf("2020-10-01"));
     al.addProject("CSC211", "femal", Date.valueOf("2020-09-30"));
     al.addProject("CSC211", "femal", Date.valueOf("2020-09-30"));
     while (al.getNextProject() != null) {
             System.out.println(al.removeNextProject());
        } 
    }  // end main
}  // end Driver

/*
 Adding these entries:
 2020-10-15 CSC211 Exercise 2
 
 2020-09-15 CSC212 Exercise 4
 
 2020-09-30 CSC213 Exercise 6
 
 2020-10-01 CSC214 Exercise 8
 
 
 First entry should be 2020-09-15 CSC212 Exercise 4
 
 2020-09-15 CSC212 Exercise 4
 
 Log contains
 2020-09-15 CSC212 Exercise 4
 
 2020-09-30 CSC213 Exercise 6
 
 2020-10-01 CSC214 Exercise 8
 
 2020-10-15 CSC211 Exercise 2
 
 Done!!
 */
