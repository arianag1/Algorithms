/**
 * Problem from Data Structures > LinkedList on HackerRank.com
 *
 * TITLE: Print the Elements of a Linked List
 * 
 * ABOUT:
 * Given a pointer to the head node of a linked list, print its
 * elements in order, one element per line. If the head pointer
 * is null don't print anything
 *
 * INPUT:
 * >> The first line of input n, the number of elements in the LinkedList
 * >> The next n lines contain one element each, which are the elements of the LinkedList
 *
 * CONSTRAINTS:
 * 1 <= n <= 1000
 * 1 <= list_i <= 1000, where list_i is the ith element in the list
 *
 * OUTPUT FORMAT:
 * Print the integer data for each element of the linked list to stdout/console. There 
 * should be one element per line. 
 *
 * SAMPLE INPUT: 
 * 2
 * 16
 * 13
 *
 * SAMPLE OUTPUT: 
 * 16
 * 13
 * 
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrintElementsOfLinkedList{

	static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

     // Complete the printLinkedList function below.
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void printLinkedList(SinglyLinkedListNode head) {
    	while(head != null){
    		System.out.println(head.data);
    		head = head.next; 
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        printLinkedList(llist.head);

        scanner.close();
    }	
}