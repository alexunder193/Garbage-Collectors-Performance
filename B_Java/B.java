//package gr.dit.homework2;

/* Linked list Node*/
class Node {
	byte[] data = new byte[1000000]; 
    Node next;
} 

public class B {
	

	public static void main(String[] args) {
		long start = System.nanoTime();  
		Node head = null; 

		try {
		    for (;;) {
		    	head = B.push(head);
		    	if (B.listLength(head) % 1000 == 0)
		            System.out.println(B.listLength(head));
		    }
		} catch (@SuppressWarnings("unused") OutOfMemoryError e) {
		    // Ignore
		}
		// free some memory
		head = B.deleteList(head);
		System.out.println((B.listLength(head) + 1) + " Memory full");
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Memory full in : " + elapsedTime);
		
		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
			head = B.push(head);
			head = B.deleteList(head);
		}
		elapsedTime = System.nanoTime() - start;
		System.out.println("1000 iterations with insertions deletions completed in:" + elapsedTime + " nano seconds");
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
