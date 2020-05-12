/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabDataStructure.recursion;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class recursionAplication {

    public static void countUp(int n) { //5  1 2 3 4 5

        if (n > 0) {
            countUp(n - 1);
            System.out.println(n);
        }

    }

    public static void countDown(int n) {

        if (n > 0) {

            System.out.println(n);
            countUp(n - 1);
        }

    }

    public static void displayChar(char c, int n) {
        if (n == 0) {
            return;
        }
        System.out.print(c);
        displayChar(c, n - 1);

    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    /* Q1 */
    public static void asksEnterInput() {
        Scanner s = new Scanner(System.in);
        System.out.println(" Enter integer is between 1 and 10");
        int input = s.nextInt();
        if (input > 0 && input <= 10) {
            return;
        }
        asksEnterInput();

    }

//    public static String Apalindrome(String s) {  //   بدها تفكير وروقان كيف احولها من لوب لريكرجن ؟؟؟
//        String ss = "";
//        int last=s.length()-1;
//        int start=0;
//          for (int i = s.length()-1; i >= 0; i--) {
//            ss += s.charAt(i) + "";
//            System.out.println(ss);
//        }
//        if (ss.equals(s)) {
//            System.out.println("its correct");
//        }
//        return "";
//    }
    static boolean isPalRec(String str, int s, int e) {
        if (s == e) {
            return true;
        }
        if ((str.charAt(s)) != (str.charAt(e))) {
            return false;
        }
        if (s < e + 1) {
            return isPalRec(str, s + 1, e - 1);
        }
        return true;
    }

    static boolean isPalindrome(String str) {
        int n = str.length();

        if (n == 0) {
            return true;
        }
        return isPalRec(str, 0, n - 1);
    }

    public static int f(int n) {
        if (n <= 4) {
            return 1;
        }
        return f(n / 4) + f(n / 2);

    }
//

    public static int squareRoot(int number, int lowGuess, int highGuess, int tolerance) {
         int newGuess = (lowGuess + highGuess) / 2;
        if ((highGuess - newGuess) / newGuess < tolerance) {
            return newGuess;
        } else if (newGuess * newGuess > number) {
            return squareRoot(number, lowGuess, newGuess, tolerance);
        } else if (newGuess * newGuess < number) {
            return squareRoot(number, newGuess, highGuess, tolerance);
        } else {
            return newGuess;
         }
    }
 



    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char ch;

        do {
            System.out.println("1. count Up ");
            System.out.println("2. count Down");
            System.out.println("3. display Char");
            System.out.println("4. asks Enter Input");
            System.out.println("5. is Palindrome");
            System.out.println("6. f");
            System.out.println("7. count Node");
            System.out.println("8. Recursion Draw Circle");
            System.out.println("9. square Root");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter n");
                    countUp(s.nextInt());
                    break;
                case 2:
                    System.out.println("Enter int n");
                    countDown(s.nextInt());
                    break;
                case 3:
                    System.out.println("Enter int  char and n");
                    displayChar(s.next().charAt(0), s.nextInt());

                    break;
                case 4:
                    asksEnterInput();
                    break;
                case 5:
                    System.out.println("Enter the String");
                    if (isPalindrome(s.next())) {
                        System.out.println("is Palindrome");
                    } else {
                        System.out.println("is not Palindrome");
                    }

                    break;
                case 6:
                    System.out.println("Enter n");
                    System.out.println(f(s.nextInt()));

                    break;
                case 7:

                    linkedList list = new linkedList();
                    list.add(
                            "shaimaa");
                    list.add(
                            "omar");
                    list.add(
                            "sara");
                    list.add(
                            "shaimaa");
                    list.add(
                            "omar");
                    list.add(
                            "sara");
                    System.out.println("The number of Node is :" + list.countNode(list.head));
                    break;
                case 8:
                    new RecursionDrawCircle();
                    break;
                case 9:
                    System.out.println("the square Root is :"+ squareRoot(0,5,10,20));  
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = s.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }

}
