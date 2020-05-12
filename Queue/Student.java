/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

/**
 *
 * @author hp
 */
public class Student extends EnteryPri<Student> implements Comparable<Student> {

    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student { " + "name=" + name + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Student s) {  //لو الترتيب بالعكس بنضرب ب -1
        return -1 * (this.id - s.id);

//        if (this.id > s.id) {
//            return 1;
//        } else if (this.getId() == s.getId()) {
//            return 0;
//        } else {
//            return -1;
//        }
//    }
    }

    public int compareTo2(Student s) {  //لو الترتيب بالعكس بنضرب ب -1
        return s.name.compareTo(name);
    }
}
