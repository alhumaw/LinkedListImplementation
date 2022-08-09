

public class LinkedList{


   private class Node {
      private Object data;  
      private Node next, prev;
    
      private Node(Object d, Node pref, Node next)
      {
         
         this.prev = pref;
         this.next = next;
         this.data = d;
       
      }
   }

   private Node head;
   private int size;
   
   

   public LinkedList() {
      this.head = new Node(null, null, null);
      this.head.next = this.head;
      this.head.prev=this.head;
      this.size = 0;
   }

   public boolean isEmpty() {
      return this.head == this.head.next;
   } 
	
   public int getSize() {
      return this.size;	
   }
	

   public void addFirst(Object data) {
      Node nn = new Node(data, this.head, this.head.next);
      this.head.next.prev = nn;
      this.head.next = nn;
      this.size ++;
   }


   public void addLast(Object data) {
      // create new node with given parameters
      Node nn = new Node(data, this.head.prev, this.head);
      // connecting our new node with the original last node in the list
      this.head.prev.next = nn;
      this.head.prev = nn;
      // increase the size
      this.size++;
      
   
   }
    
	public Object getFirst(){
      if(head.next == null)
         throw new IllegalArgumentException("null");
         return head.next.data;
         }
   public Object removeLast() {
   	
      if(isEmpty()) {
         return this.head;
      }
      Node temp = this.head.prev;
      this.head.prev = this.head.prev.prev;
      this.head.prev.next = this.head;
      size--;
      return temp;
   }
	
   public Object removeFirst() {
      if(isEmpty()) {
         return this.head;
      }
      Node temp = this.head.next;
      this.head.next = this.head.next.next;
      this.head.next.prev = this.head;
      size--;
      return temp;
   }
	
   public void mergeSort() throws Exception {		
   	
      Queue q = new Queue();
      Node cur = this.head.next;
   	
      while(cur != head) {
         LinkedList newList = new LinkedList();
         newList.addFirst(cur.data);
         q.enqueue(newList);
         cur = cur.next;
      }
      while(q.size > 1) {
         LinkedList subList1 = (LinkedList)q.dequeue();
         LinkedList subList2 = (LinkedList)q.dequeue();
        
         
         LinkedList tempList = merge(subList1, subList2);
         q.enqueue(tempList);
      	
      	
      	
      }
      LinkedList subList3 = (LinkedList)q.dequeue();
      head.next = subList3.head.next;
     
   	
   }				            // subList 1, subList 2
   private LinkedList merge(LinkedList A, LinkedList B) {
      LinkedList C = new LinkedList();
      
    while(A.size != 0 && B.size != 0) {
         Node fA = A.head.next;
         Node fB = B.head.next;
         /*
     System.out.println("A and B size: " + A.size + "," +  B.size);  
     System.out.println("fA and fB data: " + fA.data + "," +  fB.data);  
*/
    if((int)fA.data < (int)fB.data){
         
            A.removeFirst();
            C.addLast(fA.data);
         }
         // fB >= fA
         else {
            B.removeFirst();
            C.addLast(fB.data);
         }
      }
      // while there are still items in the list, and there are no more items in List B 
      while(A.size != 0) {
         Node fA = A.head.next;
         C.addLast(fA.data);
         A.removeFirst();
      	
      }
      // while there are still items in list B, and there are no more items in list A
      while(B.size != 0) {
         Node fB = B.head.next;
         C.addLast(fB.data);
         B.removeFirst();
      	
      }
     

   return C;	
   }
	
   public boolean isSorted() {
      Node cur = head.next;
      while(cur.next.data != null) {
         if((Integer)cur.data <= (Integer)cur.next.data) {
            cur = cur.next;
         }
         else {
            return false;
         }
      }
   	
   	
      return true;
   }
	
   public void insertionSort() {
      Node lastSorted, sortedWalker;
      Comparable firstUnsortedData;
   
      for(lastSorted = this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next){
      
         firstUnsortedData = (Comparable)lastSorted.next.data;
      
         for(sortedWalker = lastSorted; sortedWalker != head && 
               ((Comparable)sortedWalker.data).compareTo(firstUnsortedData) > 0;
               sortedWalker = sortedWalker.prev){
            sortedWalker.next.data = sortedWalker.data;
         }
         sortedWalker.next.data = firstUnsortedData;
      }
               
                 
   		
   }
	
	

	
}


