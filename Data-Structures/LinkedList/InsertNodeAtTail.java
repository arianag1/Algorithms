/**
 * Problem from Data Structures > LinkedList on HackerRank.com
 *
 * TITLE: Insert a Node at the Tail of a Linked List
 * 
 * ABOUT:
 * Given a pointer to the head node of a linked list, and an integer 
 * to add the list. Create a new node with the given integer. Insert 
 * this node at the tail of the linked list and return the head node 
 * of the linked list formed after inserting this node. The given head
 * pointer may be null, meaning that the initial list is empty. 
 *
 *
 * INPUT:
 * The input is handled by code editor and is as follows: 
 * >> The first line contains an integer n, denoting the elements of the linked list. 
 * >> The next n lines contain an integer each, denoting the elements that needs to be inserted at tail. 
 *
 * CONSTRAINTS:
 * 1 <= n <= 1000
 * 1 <= list_i <= 1000, where list_i is the ith element in the list
 *
 * OUTPUT FORMAT:
 * Insert the new node at the tail and just return the head of the updated linked list. 
 * Do not print anything to stdout/console. 
 * The output is handled by code in hte editor and is as follows:
 * Print the elements of the linked list from head to tail, each in a new line. 
 *
 * SAMPLE INPUT: 
 * 5
 * 141
 * 302
 * 164
 * 530
 * 474
 *
 * SAMPLE OUTPUT: 
 * 141
 * 302
 * 164
 * 530
 * 474
 *
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertNodeAtTail {

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

        public SinglyLinkedList() {
            this.head = null;
        }

      
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if(head == null) return head = new SinglyLinkedListNode(data);

        SinglyLinkedListNode currentNode = head;
        
        while(currentNode.next != null){
            currentNode = currentNode.next; 
        } 
        currentNode.next = new SinglyLinkedListNode(data); 
        return head; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        	
          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

          llist.head = llist_head;
        }

        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}