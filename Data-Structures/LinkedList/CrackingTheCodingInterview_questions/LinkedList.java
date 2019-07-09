public class LinkedList
{
	public Node head; 
	private int size = 0; 

	public void appendToTail(int data)
	{

		if(head == null){
			head = new Node(data);
			size++;  
			return;  
		}

		Node currentNode = head; 
		while(currentNode.next != null){
			currentNode = currentNode.next; 
		}

		currentNode.next = new Node(data); 
		size++; 
	}

	public void prepend(int data)
	{
		Node newHead = new Node(data); 

		newHead.next = head;
		head = newHead;
		size++; 
	}

	/*
	* HackerRank Problem: insert a node at
	* a specific position in a linked list
	*
	* You're given the pointer to the head
	* node of a linked list, an integer to
	* add to the list and the position at 
	* which the integer must be inserted. 
	* Create a new node with the given 
	* integer, insert this node at the
	* desired position and return the head
	* node. A position of 0 indicates head,
	* a position of 1 indicates one node 
	* away from the head and so on. The 
	* head pointer given may be null meaning
	* that the inital list is empty
	*
	*
	*/
	public void insert(int data, int position){
		Node newNode = new Node(data);
		int index = 1; 

		if(position == 0){
			newNode.next = head;
			head = newNode; 
			return; 
		}
		Node currentNode = head;
		while(currentNode.next != null){
			if(index == position){
				newNode.next = currentNode.next;
				currentNode.next = newNode; 
				return; 
			}
			index++;
			currentNode = currentNode.next; 
		}
	}

	public void deleteNode(int data)
	{
		if(head == null){
			return; 
		}
		if(head.data == data){
			head = head.next; 
			size--; 
			return; 
		} 

		Node currentNode = head;
		while(currentNode.next != null){	

			if(currentNode.next.data == data){

				currentNode.next = currentNode.next.next; 
				size--; 
				return; 
			}

			currentNode = currentNode.next; 
		}
	}

	/*
	* Exercise 2.1 in Cracking the coding
	* interview 6th edition
	*
	* Remove Dups: 
	* Write code to remvoe duplicates from 
	* an unsorted linked list
	*
	*/

	public void deleteDuplicates(int data)
	{
		if (head == null) return; 
		
		Node currentNode = head;
		while(currentNode.next != null){
			if(head.data == data){

				head = head.next;
				currentNode = head;
				size--; 

			}else if(currentNode.next.data != data){

				currentNode = currentNode.next; 
			
			}else if(currentNode.next.data == data){

				currentNode.next = currentNode.next.next; 
				size--; 
			}
		}
		return; 
	}

	/*
	* Exercise 2.2 in Cracking the coding
	* interview 6th edition
	*
	* Return Kth to last: 
	* Implement an algorithm to find the 
	* kth to the last element of a singly 
	* linked list  
	*
	*/
	public int findKthElement(int kth){

		if(kth > size){
			return 0; 
		}
		int element = size - kth; 
		Node currentNode = head; 
		while(currentNode.next != null && element > 0){
			currentNode = currentNode.next; 
			element--; 
		}
		return currentNode.data; 
	}

	/*
	* Exercise 2.3 in Cracking the coding
	* interview 6th edition
	*
	* Delete Middle Node: 
	* Implement an algorith to delete a 
	* node in the middle (i.e, any ndoe
	* but the first and the last node,
	* not necessarity the exact middle) 
	* of a singly linked list, given 
	* only access to that node 
	*
	*/
	public void deleteMiddleNode(int data){
		if(head.data == data)return; 
		Node currentNode = head;
		while(currentNode.next.next != null){
			if(currentNode.next.data == data){
				currentNode.next = currentNode.next.next; 
				return; 
			}
			currentNode = currentNode.next; 
		}
	}

	/*
	* Exercise 2.4 in Cracking the coding
	* interview 6th edition
	*
	* Partition: 
	* Write code to partition a linked list 
	* around a value x, such that all nodes
	* less than x come before all nodes 
	* greater than or equal to x. If x
	* is contained within the list, the 
	* values of x only need to be after the
	* elements less than x. The partition 
	* element x can appear anywhere in the 
	* "right partition"; it does not need to 
	* appear between teh left and right 
	* partitions
	*
	*/

	public void partition(){
		//
	}

	/*
	* Exercise 2.5 in Cracking the coding
	* interview 6th edition
	*
	* Sum Lists: 
	* You have two numbers represented by  
	* a linked list, where each node 
	* contains a single digit. The digits
	* are stored in reverse order, such that
	* the 1's digit is at the head of the 
	* list. Write a function that adds the 
	* two numbers and returns the sum as a 
	* linked list. 
	*
	*/

	private int getNumReverse(Node head)
	{
		int multi = 1, total = 0; 
		Node currentNode = head; 

		while(currentNode != null){
			total += (multi * currentNode.data);
			currentNode = currentNode.next; 
			multi *= 10;  
		}
		return total; 
	}
	private int getNum(Node head)
	{
		int multi = 10, total = 0; 
		Node currentNode = head; 

		while(currentNode != null){
			total = (total * multi) + currentNode.data; 
			currentNode = currentNode.next;
		}
		return total;  
	}
	public LinkedList sumList(LinkedList list1, LinkedList list2, Boolean reverse)
	{

		LinkedList newList = new LinkedList(); 
		int sum  = 0;
		if(reverse){
			sum = list1.getNumReverse(list1.head) + list2.getNumReverse(list2.head);
		}else if(reverse == false){
			sum = list1.getNum(list1.head) + list2.getNum(list2.head); 
		}
		while(sum > 0){
			newList.prepend(sum % 10); 
			sum /= 10; 
		}

		return newList; 
	}

	/*
	* Exercise 2.6 in Cracking the coding
	* interview 6th edition
	*
	* Palindrome: 
	* Implement a function to check if a
	* linked list is a palindrome
	*
	*/
	public Boolean isAPalindrome(Node head){
		int num = getNum(head); 
		int reverseNum = getNumReverse(head);
		if(num == reverseNum) return true;
		return false; 
	}

	/*
	* Exercise 2.5 in Cracking the coding
	* interview 6th edition
	*
	* Intersection: 
	* Given two (singly) linked lists, 
	* determine if the two lists intersect. 
	* Return the intersecting ndoe. Node 
	* that the intersection is defined based
	* on reference, not value. That is if the
	* kth node of the first linked list is the
	* exact same node (by reference) as the jth
	* node of the second linke list, then they 
	* are intersecting. 
	*
	*/
	public Node findIntersectingNode(LinkedList l1, LinkedList l2){
		
		
	}
	public intersection(LinkedList l1, LinkedList l2){
		if(l1.size() > l2.size()){

		}
	}
	public int size()
	{
		return size; 
	}
	public String toString()
	{
		String list = "";

		Node currentNode = head;

		while(currentNode.next != null)
		{
			list += currentNode.data;
			list += "\n";
			currentNode = currentNode.next; 
		}

		list += currentNode.data; 

		return list; 
	}
}
