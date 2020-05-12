/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.ImplementDirectAddressingTables;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class DirectAddressingTables {
      private String[] arr ;
    private final int DEFAULT_CAPACITY = 100;
 
     public DirectAddressingTables(int capacity)
    {
        arr = new String[capacity + 1];
    }
    
    
    /* Constructor */
    public DirectAddressingTables()
    {
//        this(DEFAULT_CAPACITY);   //Why wrong
        arr = new String[DEFAULT_CAPACITY];
    }
    
   
    /* function to insert */
    public void insert(int k, String d)
    {
        arr[k] = d;
    }
    /* function to delete */
    public void delete(int k)
    {
        arr[k] = null;
    }
    /* function to get value */
    public String get(int k)
    {
        return arr[k];
    }
    /* function to clear */
    public void clear()
    {
        int l = arr.length; //عمل متغير جديد وحط فيه طول القديمة
        arr = new String[l]; //اعطى طول القديمة للجديدة وانشئ فيها اري جديدة دون نقل محتويات القديمة
    }
    /* function to print */
    public void printTable()
    {
        System.out.println("\nDirect Addressing Table : ");
        int l = arr.length;
        for (int i = 0; i < l; i++)
            if (arr[i] != null)
                System.out.println(i +" "+ arr[i]);
        System.out.println();        
    }
 
 
 
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Direct Addressing Table Test\n\n");
 
        /* Make object of DirectAddressingTable */
       DirectAddressingTables dat = new DirectAddressingTables();
 
        char ch;
        /*  Perform DirectAddressingTable operations  */
        do    
        {
            System.out.println("\nDirect Addressing Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");            
            System.out.println("4. clear");
 
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter int key and string value");
                dat.insert( scan.nextInt(), scan.next() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter int key");
                dat.delete( scan.nextInt() ); 
                break;                        
            case 3 : 
                System.out.println("Enter int key");
                System.out.println("Value = "+ dat.get( scan.nextInt() )); 
                break;                                   
            case 4 : 
                dat.clear();
                System.out.println("Direct Addressing Table Cleared\n");
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Display hash table */
            dat.printTable();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
    
}
