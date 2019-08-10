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
        // check if the length of the string is odd, 
        // if it is then brackets are not balanced. 
        if(s.length() % 2 != 0)return "NO";

        Stack<Character> openDelims = new Stack<Character>();
        Stack<Character> closingDelims = new Stack<Character>();
        
        // Search through the string and check if it starts with an
        // opening delimiter. If it does then push the char on the 
        // open delimiter stack. 
        
        // If the string starts with a closing delimiter
        // (open delimiter stack is empty) then is it not balanced. 
        // Else check if 
            // open delimiter contains { and the current character in the string is }
            // or open delimiter contains ( and the current character in the string is )
            // or open delimiter contains [ and the current character in the string is ]
            // otherwise add the current character to the closing delimiter stack.  
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
        
        // Need to make sure that both stacks are empty, 
        // if they are then return YES. Otherwise try
        // to match opening delimiter with closing delimiter
        // from the top of each stack. If this doesn't work
        // return NO. 
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
