/**
 * Problem from Data Structures > LinkedList on HackerRank.com
 *
 * TITLE: Insert a Node at the Head of a Linked List
 * 
 * ABOUT:
 * Given the pointer to the head node of a linked list and you 
 * need to print all its elements in reverse order from tail to 
 * head, one element per line. 
 *
 * INPUT:
 * The input is handled by code editor and is as follows: 
 * >> The first line contains an integer n, denoting the number of elements to be inserted at the head of the linked list. 
 * >> The next n lines contain one element each, denoting the elements of the linked list in the order.
 *
 * CONSTRAINTS:
 * 1 <= n <= 1000
 * 1 <= list_i <= 1000, where list_i is the ith element in the list
 *
 * OUTPUT FORMAT:
 * Complete the reversePrint function in the editor below and print 
 * the elements of the linked list in the reverse order, each in a new line.
 *
 * SAMPLE INPUT: 
 * 3
 * 5
 * 16
 * 12
 * 4
 * 2
 * 5
 * 3
 * 7
 * 3
 * 9
 * 5
 * 5
 * 1
 * 18
 * 3
 * 13
 *
 * SAMPLE OUTPUT: 
 * 5
 * 2
 * 4
 * 12
 * 16
 * 9
 * 3
 * 7
 * 13
 * 3
 * 18
 * 1
 * 5
 *
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class PrintInReverse{
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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    // Complete the reversePrint function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void reversePrint(SinglyLinkedListNode head) {
        if(head.next == null)System.out.println(head.data);
        else{
            String reversedNodes = ""; 
            SinglyLinkedListNode currentNode = head;
            while(currentNode != null){
                reversedNodes = currentNode.data+"\n"+reversedNodes; 
                currentNode = currentNode.next; 
            }
            System.out.print(reversedNodes);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            reversePrint(llist.head);
        }

        scanner.close();
    }		
}