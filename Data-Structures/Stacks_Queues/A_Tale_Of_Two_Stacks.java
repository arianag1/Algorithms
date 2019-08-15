import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static class MyQueue<T>{
        private Stack<T> pushStack = new Stack();
        private Stack<T> popStack = new Stack();

        public T enqueue(T obj){
            return pushStack.push(obj);
        }

        public T dequeue(){
            if(!popStack.empty())return popStack.pop(); 
            while(!pushStack.empty()){
                popStack.push(pushStack.pop()); 
            }
            return popStack.pop(); 
        }

        public T peek(){
            if(!popStack.empty())return popStack.peek(); 
           
            while(!pushStack.empty()){
                popStack.push(pushStack.pop()); 
            }
            return popStack.peek();
        }
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

