/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.recursion;

/**
 *
 * @author hp
 */
public class ExampleOFRecurion {

    // printNumber
    public static void printNumber(int number) {

        if (number == 1) {
            return;
        } else {
            System.out.print(number + " ");
            printNumber(number - 1);
        }
    }

    //sum of number
    public static int sumOfNumber(int n) { //1+2+3+4+.....+n
        if (n == 1) {
            return 1;
        }
        return n + sumOfNumber(n - 1);
    }

    //factorial
    public static int factorial(int n) { //5! =5*4!
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    //fibonacci
    public static int fibonacci(int index) {
        if (index <= 1) {  // 0 , 1 
            return 1;
        }
        return fibonacci(index - 1) + fibonacci(index - 2);
    }

    //power
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);

    }

    //power2
    public static int power1(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return power1(x, n / 2) * power1(x, n / 2);
        } else {
            return x * power(x, n - 1);
        }
    }

    // cate Eyse
    public static int cateEyse(int cats) {
        if (cats == 0) {
            return 0;
        } else {
            return 2 + cateEyse(cats - 1);
        }
    }

    public static int mobileSpeakers(int mobiels) {
        return 0;
    }

    public static int Sum(int n) {// sum 1^1 + 2^2 + 3^3 + ….. + n^n
        if (n == 1) {
            return 1;
        }
        return (int) (Math.pow(n, n) + Sum(n - 1));

    }

    //(1) + (2*3) + (4*5*6) … n
    public static int seriesSum(int n) {
        return 0;

    }

    // logfact logN! 
    public static double logfact(int n) {
        if (n == 1) { //log 1 = 0           
            return 0;
        }
        return logfact(n - 1) + Math.log(n);
    }

    // product Tow Number
    public static int productTowNumber(int x, int y) {
        // if x is less than  
        // y swap the numbers 
        if (x < y) {
            return productTowNumber(y, x);
        } // iteratively calculate  
        // y times sum of x 
        else if (y != 0) {
            return (x + productTowNumber(x, y - 1));
        } // if any of the two numbers is  
        // zero return zero 
        else {
            return 0;
        }
    }

    // sum OF Digit
    public static int sumOFDigit(int n) { //1234
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOFDigit(n / 10);

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
//        printNumber(10);
//        System.out.println("");
//        System.out.println(sumOfNumber(3));
//        System.out.println(factorial(5));
        System.out.println(fibonacci(2));//0 1 1 2 3 5 8 13
//        System.out.println(power(2, 5));
//        System.out.println(power1(2, 5));
//        System.out.println(cateEyse(7));
//        System.out.println(Sum(2));
//        System.out.println(sumOFDigit(123));
//        System.out.println(gcd(64, 4));
         int n = 3; // Number of disks 
        towerOfHanoi(n, 1, 2, 3);   

    }
}
