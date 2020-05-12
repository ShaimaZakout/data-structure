package LabDataStructure.rotionalnumber;


/**
 * A class that represents a rational number.
 *
 * @author Charles Hoot
 * //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
 * @version 5.1 (Modified for the Solution)
 * //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 */

public class Rational {

    // PUT PRIVATE DATA FIELDS HERE
//vvvvvvvvv ADDED CODE vvvvvvvvvvvvvvvv        
    private int numerator; //البسط
    private int denominator;//المقام
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    /**
     * The default constructor for objects of class Rational. Creates the
     * rational number 1.
     */
    public Rational() {
        numerator = 1;
        denominator = 1;
    }

    /**
     * The alternate constructor for objects of class Rational. Creates a
     * rational number equivalent to n/d.
     *
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */
    public Rational(int n, int d) {
        numerator = n;
        denominator = d;
        if (denominator == 0) { //ان المقام بيساوي صفر معناته يرجع اكسبشن
            throw new ZeroDenominatorException("Can not have a zero denominator");
        }
        normalize();
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Get the value of the Numerator
     *
     * @return the value of the numerator
     */
    public int getNumerator() {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//vvvvvvvvv REPLACEMENT vvvvvvvvvvvvvvv       
        return numerator;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Get the value of the Denominator
     *
     * @return the value of the denominator
     */
    public int getDenominator() {
        return denominator;
        //vvvvvvvvv REPLACEMENT vvvvvvvvvvvvvvv       

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Negate a rational number r
     *
     * @return a new rational number that is negation of this number -r
     */
    public Rational negate() {
        return new Rational(numerator * -1, denominator);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Invert a rational number r
     *
     * @return a new rational number that is 1/r.
     */
    public Rational invert() {
        return new Rational(denominator, numerator);

    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other
     * rational
     */
    public Rational add(Rational other) {
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
//vvvvvvvvv REPLACEMENT vvvvvvvvvvvvvvv       
        int resultDenominator = denominator * other.denominator;
        int resultNumerator = numerator * other.denominator + other.numerator * denominator;

        return new Rational(resultNumerator, resultDenominator);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */
    public Rational subtract(Rational other) {
        return add(other.negate());

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the
     * other rational.
     */
    public Rational multiply(Rational other) {
        int rn = (this.numerator * other.numerator);
        int rd = (this.denominator * other.denominator);
        return new Rational(rn, rd);
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
//vvvvvvvvv REPLACEMENT vvvvvvvvvvvvvvv       

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */
    public Rational divide(Rational other) {

        return multiply(other.invert());
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Put the rational number in normal form where the numerator and the
     * denominator share no common factors. Guarantee that only the numerator is
     * negative.
     *
     */
    private void normalize() {

        int absNumerator = Math.abs(numerator); //القيمة المطلقة للبسط
        int absDenominator = Math.abs(denominator);//القيمة المطلقة للمقام
        int signDenominator = denominator / absDenominator; //المقام على القيمة المطلقة للمقام

        int divideBy = gcd(absNumerator, absDenominator);//القاسم المشترك الاكبر للرقمين
        numerator = (numerator / divideBy) * signDenominator; 
        denominator = (denominator / divideBy) * signDenominator;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b) { //العامل المشترك الاكبر
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

   
}
