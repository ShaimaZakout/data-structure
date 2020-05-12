package LabDataStructure.queuetest;

import java.util.Random;

/**
 * Simulates a waiting line.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class WaitLine {

    private QueueInterface<Customer> line;
    private int numberOfArrivals; //عدد الزبائن الي وصلوا
    private int numberServed; //عدد الي خدمتهم
    private int totalTimeWaited; // معدل وقت االانتظار

    public WaitLine() {
        line = new VectorQueue<>();
        reset();
    } // end default constructor

    /**
     * Simulates a waiting line with one serving agent.
     *
     * @param duration The number of simulated minutes.
     * @param arrivalProbability A real number between 0 and 1, and the
     * probability that a customer arrives at a given time
     * @param maxTransactionTime The longest transaction time for a customer
     */
    public void simulate(int duration, double arrivalProbability, int maxTransactionTime) {
        int transactionTimeleft = 0;   //هنا راح تساعدني بانياحسب الوقت الي راح يستناه الزبون بعد مرور الوقت   
        for (int clock = 0; clock < duration; clock++) {
            if (Math.random() < arrivalProbability) {//الزبون راح يجي بشكل عشوائي فبدي اتاكد انه وجود الزبون بشكل عشوائي اقل احتمالية وصول زبون  
                // System.out.println("new customer"+clock); هنا هذه الفكرة اعملناها فقط عشان اتاكد من فكرة العشوائي انه مش كل مرة بحقق الكود 
                int transctionTime = (int) (Math.random() * maxTransactionTime + 1);//هنا عشان اجيب وقت الخدمةالي بده يعملها المستخدم بنروح بنعمل راندوم قيمة عشوائية لحد اقصى وقت خدمة ممكن يستعملها المستخدم
                numberOfArrivals++;
                Customer nextArrival = new Customer(clock, transctionTime, numberOfArrivals);
                line.enqueue(nextArrival);
                System.out.println("Customer " + numberOfArrivals
                        + " enters line at time " + clock
                        + ". Transaction time is " + transctionTime);

            }
            if (transactionTimeleft > 0) {  //معناته انه في واحد بشتغله ما بناخد من الكيو بناخد لمن يكون هاد الوقت صفر
                transactionTimeleft--; //بقلل الوقت بواحد   لانه بديت بخدمته
            } else if (!line.isEmpty()) { //اذا ماكانت فارغة بناخد واحد من الكيو
                Customer nextCustomer = line.dequeue();
                transactionTimeleft = nextCustomer.getTransactionTime() - 1; //وقت الي اجاه الدور
                int timeWaited = clock - nextCustomer.getArrivalTime();//وقت الانتظار لاهله بيساوي الوقت الي اجافيه ناقص الوقت الي طلع فيه
                totalTimeWaited += timeWaited;
                numberServed++;
                System.out.println("Customer " + nextCustomer.getCustomerNumber()
                        + " begins service at time " + clock
                        + ". Time waited is " + timeWaited);
            }
        }
    }

    // end simulate
    /**
     * Displays summary results of the simulation.
     */
    public void displayResults() {
        System.out.println();
        System.out.println("Number served = " + numberServed);//عدد الي خدمتهم
        System.out.println("Total time waited = " + totalTimeWaited); // مجموع وقت الانتظار لكل العناصر
        double averageTimeWaited = ((double) totalTimeWaited) / numberServed; //معدل وقت الانتظار
        System.out.println("Average time waited = " + averageTimeWaited);
        int leftInLine = numberOfArrivals - numberServed;   // قديش لسا ضايل في الكيو
        System.out.println("Number left in line = " + leftInLine);

    } // end displayResults

    /**
     * Initializes the simulation.
     */
    public final void reset() {
        line.clear();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
    } // end reset
} // end WaitLine
