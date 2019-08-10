import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length() % 2 != 0)return "NO";

        Stack<Character> openDelims = new Stack<Character>();
        Stack<Character> closingDelims = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '[')
                openDelims.push(ch);
            else if(ch == '}' || ch == ')' || ch == ']'){
                if(openDelims.empty())
                    return "NO"; 
                if(ch == '}' && openDelims.peek() == '{')
                    openDelims.pop(); 
                else if(ch == ')' && openDelims.peek() == '(')
                    openDelims.pop(); 
                else if(ch == ']' && openDelims.peek() == '[')
                    openDelims.pop();
                else
                    closingDelims.push(ch);
            }
        }

        while(!openDelims.empty() || !closingDelims.empty()){
            if(!openDelims.empty() && closingDelims.empty())
                return "NO";
            else if(openDelims.empty() && !closingDelims.empty())
                return "NO"; 
            else if(openDelims.peek() == '{'){
                if(closingDelims.peek() == '}'){
                    openDelims.pop();
                    closingDelims.pop();
                }else
                    return "NO"; 
            }else if(openDelims.peek() == '('){
                if(closingDelims.peek() == ')'){
                    openDelims.pop();
                    closingDelims.pop();
                }else
                    return "NO"; 
            }else if(openDelims.peek() == '['){
               if(closingDelims.peek() == ']'){
                    openDelims.pop();
                    closingDelims.pop();
                }else
                    return "NO"; 
            }
        }
       
       return "YES"; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
