/**
 * Problem from Data Structures > LinkedList on HackerRank.com
 *
 * TITLE: Insert a Node at the Head of a Linked List
 * 
 * ABOUT:
 * Given the pointer to the head node of a linked list. Change 
 * the next pointers of the nodes so that their order is reversed. 
 *
 * INPUT:
 * The input is handled by code editor and is as follows: 
 * >> The first line contains an integer , denoting the number of test cases. 
 * Each test case is of the following format: 
 * >> The first line contains an integer n, denoting the number of elements in the linked list
 * >> The next n lines contain an integer each, denoting the elements of the linked list.
 *
 * CONSTRAINTS:
 * 1 <= t <= 10
 * 1 <= n <= 1000
 * 1 <= list_i <= 1000, where list_i is the ith element in the list
 *
 * OUTPUT FORMAT:
 * Change the next pointers of the nodes that their order is reversed
 * and return the head of the reversed linked list. Do NOT print 
 * anything to stdout/console.
 * The output is handled by the code in the editor. The output format 
 * is as follows:
 * For each test case, print in a new line the elements of the linked
 * list after reversing it, separated by spaces.
 *
 * SAMPLE INPUT: 
 * 1
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * SAMPLE OUTPUT: 
 * 5 4 3 2 1 
 * 
 */ 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseALinkedList{
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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if(head == null || head.next == null)return head; 

        SinglyLinkedListNode originalHead = head; 
        while(originalHead.next != null){
            SinglyLinkedListNode newHead = new SinglyLinkedListNode(originalHead.next.data);  
            originalHead.next = originalHead.next.next; 
            newHead.next = head; 
            head = newHead; 
        }
        return head; 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

            SinglyLinkedListNode llist1 = reverse(llist.head);

            printSinglyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}