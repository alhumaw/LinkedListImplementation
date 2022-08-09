

import java.util.Random;

public class Tester {

    public static void main(String[] args) throws Exception {

        LinkedList A = new LinkedList(); 
        LinkedList A2 = new LinkedList();
     /*
        for(int i = 0; i < 30; i++){
         A.addLast(i);
         A2.addLast(i);
         }
       */
        int randomListSize = 20000;
        for(int i = 0; i < randomListSize; i++) {
        	int randomInt = (int)(Math.random()*3000000);
        	A.addLast(randomInt);
        	A2.addLast(randomInt);	
        }
        
        
        double then = System.currentTimeMillis();
        A.mergeSort();
        
        double now = System.currentTimeMillis();
        System.out.println("Is the list sorted?: " + A.isSorted());
        System.out.println("Time cost in milliseconds for mergesort " + (now - then));
        System.out.println(A.isSorted()); //verify that your merge sort implementation works.
        System.out.println("Size of list A is: " + A.getSize());

        
        then = System.currentTimeMillis();
        A2.insertionSort();
        now = System.currentTimeMillis();
        System.out.println("Time cost in milliseconds for insertionsort " + (now - then));
        System.out.println(A2.isSorted() ); //verify that your insertion sort works.
        System.out.println("Size of list A2 is: " + A2.getSize());


    }
}//end of tester class
