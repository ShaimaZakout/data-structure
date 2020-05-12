/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

/**
 *
 * @author hp
 * @param <SH>
 */
public class prioNodeQueue<SH extends Comparable<SH>> {
    
    pq first;
    pq last;
    
    private class pq implements Comparable<pq> {
        
        int p;
        pq next, prev;
        Node front;
        Node back;
        
        public pq(int p) {
            this.p = p;
            front = back = null;
        }
        
        private class Node {
            
            private SH data; // Entry in bag
            private Node next; // Link to next node

            private Node(SH dataPortion) {
                this(dataPortion, null);
            } // end constructor

            private Node(SH dataPortion, Node nextNode) {
                data = dataPortion;
                next = nextNode;
            } // end constructor
        } // end Node

        public void enqueue(SH newEntry) {
            Node newNode = new Node(newEntry, null);
            if (isEmpty()) {
                front = newNode;
                back=newNode;   //  مشتركة بين الحالتين
            }
            back.next = newNode;
            back = newNode;
        }
        
        public SH dequeue() {  //O(1)
            SH result;
            if (isEmpty()) {  //ممكن نستعيض عن هذا البلوك من خلال  getFront
                throw new EmptyQueueException("Attempting to access entries on an empty queue.");
            } else if (back == front) {  //or if(front.next==null)
                // front= front.next;  مشترك بين الحالتين
                back = null;
            }
            result = front.data;
            front = front.next;
            return result;
        }
        
        public SH getFront() {
            
            if (isEmpty()) {
                throw new EmptyQueueException("Attempting to access entries on an empty queue.");
            }
            return front.data;
            
        }
        
        public boolean isEmpty() {
            return (front == null && back == null);
        }
        
        public void clear() { //O(1)
            front = back = null;
        }
        
        @Override
        public int compareTo(pq t) {
            return ((int) this.p - (int) t.p);
        }
        
    }
    
    public void add(SH d, int p) {
        pq temp = new pq(p);
        if (this.isEmpty()) {
            temp.enqueue(d);
            first = temp;
            last = temp;
            temp.next = null;
         } else {
            pq t = first;
            while (t != null) {
                if (t.p != p) {
                    if (p < first.p) {
                        temp.enqueue(d);
                        temp.next = first;
                        first.prev = temp.next;
                        first = temp;
                    } else if (p > last.p && p != last.p) {
                        temp.next = null;
                        last.next = temp;
                        first = temp;
                    } else {
                        pq current = first.next;
                        while (current.p > p) {
                            current = current.next;
                        }
                        temp.enqueue(d);
                        current.prev.next = temp;
                        temp.next = current.prev;
                        temp.prev = current.prev.next;
                        current.prev = temp.next;
                     }
                    t = t.next;
                } else {
                    t.enqueue(d);
                }
             
                
            }
        }}
     public boolean isEmpty() {
        return first == null && last == null;
    }
     public SH  peek(){
        return first.getFront();
     }
     public SH pop(){
        first.dequeue();
       return first.getFront();
     }
 

//    static Node front, rear;
//// Linked List Node  
//    static class Node {
//
//        int info;
//        int priority;
//        Node prev, next;
//    }
//
//// Function to insert a new Node  
//    static void push(Node fr, Node rr, int n, int p) {
//        Node news = new Node();
//        news.info = n;
//        news.priority = p;
//
//        // If linked list is empty  
//        if (fr == null) {
//            fr = news;
//            rr = news;
//            news.next = null;
//        } else {
//            // If p is less than or equal front  
//            // node's priority, then insert at  
//            // the front.  
//            if (p <= (fr).priority) {
//                news.next = fr;
//                (fr).prev = news.next;
//                fr = news;
//            } // If p is more rear node's priority,   
//            // then insert after the rear.  
//            else if (p > (rr).priority) {
//                news.next = null;
//                (rr).next = news;
//                news.prev = (rr).next;
//                rr = news;
//            } // Handle other cases  
//            else {
//
//                // Find position where we need to  
//                // insert.  
//                Node start = (fr).next;
//                while (start.priority > p) {
//                    start = start.next;
//                }
//                (start.prev).next = news;
//                news.next = start.prev;
//                news.prev = (start.prev).next;
//                start.prev = news.next;
//            }
//        }
//        front = fr;
//        rear = rr;
//    }
//
//// Return the value at rear  
//    static int peek(Node fr) {
//        return fr.info;
//    }
//
//    static boolean isEmpty(Node fr) {
//        return (fr == null);
//    }
//
//// Removes the element with the  
//// least priority value form the list  
//    static int pop(Node fr, Node rr) {
//        Node temp = fr;
//        int res = temp.info;
//        (fr) = (fr).next;
//        if (fr == null) {
//            rr = null;
//        }
//
//        front = fr;
//        rear = rr;
//        return res;
//
//    }
//
//// Driver code  
//    public static void main(String args[]) {
//
//        push(front, rear, 2, 3);
//        push(front, rear, 3, 4);
//        push(front, rear, 4, 5);
//        push(front, rear, 5, 6);
//        push(front, rear, 6, 7);
//        push(front, rear, 1, 2);
//
//        System.out.println(pop(front, rear));
//        System.out.println(peek(front));
//
//    }
//}
//     Node head;
////     int priorty;
//    
//    private class Node{
//        int d ,p;
//        Node next;
//
//        public Node(int d, int p) {
//            this.d = d;
//            this.p = p;
//            this.next=null;
//        }}
//     public int peek(){
//         return head.d;
//     }
//      public int pop(){
//          int dd=head.d;
//          head=head.next;
//          return dd;
//      }
//      public int push(int d, int p){
//         Node start=head;
//         Node temp=new Node(d, p);
//         if(isEmpty()){
//          temp.next=head;
//             head=temp;
//         }
//         if(head.p>p){
//             temp.next=head;
//             head=temp;
//         }
//          else{
//             while(start.next!=null&&start.p<p){
//                 start=start.next;
//             }
//             temp.next=start.next;
//             start.next=temp;
//         }
//         return head.d;
//                 
//      }
//     public boolean isEmpty(){
//         return head==null;
//     }
//    
//     
//     
//    public static void main(String[] args) {
//       prioNodeQueue pq=new  prioNodeQueue();
//         pq.push(1, 4);
//          pq.push(5, 3);
//          System.out.println(pq.peek());
//    }
    public static void main(String[] args) {
        prioNodeQueue<Student> pq=new prioNodeQueue<>();
         pq.add(new Student("d",25), 2);
         pq.add(new Student("A",25), 1);
         pq.add(new Student("A",25), 1);
         System.out.println(pq.peek());  
          
    }}
