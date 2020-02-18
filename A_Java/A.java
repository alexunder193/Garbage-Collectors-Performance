//package gr.dit.homework2;

/* Linked list Node*/
class Node {
	byte[] data = new byte[1000000]; 
    Node next;
} 

public class A {
	

	public static void main(String[] args) {
		long start = System.nanoTime();  
		Node head = null; 

		try {
		    for (;;) {
		    	head = A.push(head);
		    	if (A.listLength(head) % 1000 == 0)
		            System.out.println(A.listLength(head));
		    }
		} catch (@SuppressWarnings("unused") OutOfMemoryError e) {
		    // Ignore
		}
		// free some memory
		head = A.deleteList(head);
		System.out.println((A.listLength(head) + 1) + " Memory full");
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Memory full in : " + elapsedTime + " nanoseconds");
		head = A.deleteList(head,4);
		start = System.nanoTime();
		for (int i=0; i< 1000000; i++) {
			A.listLength(head);
			//System.out.println(B.listLength(head));
		}
		elapsedTime = System.nanoTime() - start;
		System.out.println("1000000 traversals completed in:" + elapsedTime + " nanoseconds");
		System.out.println("Done");
		//long heapMaxSize = Runtime.getRuntime().maxMemory();
		//System.out.println(heapMaxSize);
	}
	
//	public static void printList(Node head) { 
//	    Node n = head; 
//	    while (n != null) { 
//	        System.out.print(n.data + " "); 
//	        n = n.next; 
//	    } 
//	    System.out.print("\n"); 
//	}
	
	public static Node push(Node head) { 
		Node newNode = new Node(); 
		newNode.next = head; 
        head = newNode; 
        return head;
    }
	
	public static int listLength(Node head) {
		int length = 0;
		Node current = head;
	    while (current != null) { 
	        length++; 
	        current = current.next; 
	    }
		return length;
    }
	
	public static Node deleteList(Node head, int factor)  {
		if (head == null) {
			return null;
		}
		Node current = head.next; 
		Node previous = head;
		int i = 0;
		while (current != null)  { 
			if (i % factor != 0) {
				previous.next = current.next;
			    current = current.next;  
			} else {
				previous = current;
				current=current.next;
			}
			i++;
			
		}  
  
		return head;
	}
	
	public static Node deleteList(Node head)  {  
		Node current = head;  
		Node next = null;  
		while (current != null)  {  
		    next = current.next;  
		    current = null;  
		    current = next;  
		    break;
		}  
		head = next;  
		return head;
	}

} 

