package LabDataStructure.queuetest;
/**
 * A class to represent customer in a bank line.  
 * 
 * It will be displayable so all methods must be synchronized.
 * 
 * @author Charles Hoot 
 * @version 5.0
 */

public class Customer
{
    private final int arrivalTime;//هي نفسها الكلوك   وقت الانتظار 
    private final int transactionTime;//نستطيع الوصول له بشكل عشوائي   وقت العملية للمستخدم
    private final int CustomerNumber; //رقم المستخدم

    public Customer(int arrivalTime, int transactionTime, int CustomerNumber) {
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
        this.CustomerNumber = CustomerNumber;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTransactionTime() {
        return transactionTime;
    }

    public int getCustomerNumber() {
        return CustomerNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "arrivalTime=" + arrivalTime + ", transactionTime=" + transactionTime + ", CustomerNumber=" + CustomerNumber + '}';
    }
    
}
