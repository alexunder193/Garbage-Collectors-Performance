#include<iostream>
#include <list> 
#include <bits/stdc++.h>
#include <ctime>
using namespace std;  
	
	class Node { 
		public: 
		    unsigned char array[1000000]; 
		    Node* next; 
	}; 

int printLength(Node* n) 
{ 
	int length = 0;
    while (n != NULL) { 
        length++; 
        n = n->next; 
    }
	return length;  
} 

void deleteList(Node** head_ref)  
{  
	Node* current = *head_ref;  
	Node* next;  
	  
	while (current != NULL)  
	{  
	    next = current->next;  
	    free(current);  
	    current = next;  
	    break;
	}  
	*head_ref = next;  
}

void massiveDeleteList(Node** head_ref, int factor)  {  
	Node* current = *head_ref;  
	Node* next;  
	
	if (current == NULL) {
			return;
	}
	
	current = (*head_ref)->next;
	Node* previous = *head_ref;
	
	int i = 0;
	while (current != NULL)  {
		if(i % factor != 0) {
			previous->next = current->next;
			next = current->next;
			free(current);
			current = next;
		}
		else {
			previous = current;
			current = current->next;	
		}  
		i++;
	}    
}

void push(Node** head_ref)  
{  
    Node* new_node = new Node();   
    new_node->next = (*head_ref);  
    (*head_ref) = new_node;  
}  

  
	
int main() 
{ 
	clock_t begin = clock();
    Node* head = NULL; 
    try {
    	for (;;) {
			push(&head);   
		    if (printLength(head) % 1000 == 0)
		        std::cout << printLength(head) << endl;
		    if (printLength(head) == 3485) 
		    	break;
		}
	} catch (const std::exception& e) {
    // Ignore
	}
	deleteList(&head);
	std::cout << printLength(head) + 1 << " List size" << endl;
	clock_t end = clock();
	double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
	std::cout << "Memory full in :  " << elapsed_secs << std::endl;
	massiveDeleteList(&head,4);
	begin = clock();
	for (int i=0; i< 1000000; i++) {
		printLength(head);
		//std::cout << printLength(head) << endl;
	}
	end = clock();
	elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
	std::cout << "1000000 traversals completed in:" << elapsed_secs << std::endl;
	std::cout << "Done" <<endl;
    return 0; 
} 
