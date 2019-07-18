import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> delims = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char delim = s.charAt(i); 
            if(delim == '{' || delim == '[' || delim == '('){
                delims.push(Character.valueOf(delim));
            }else if(delim == '}' && !delims.peek().equals('{') || delim == ']' && !delims.peek().equals('[') || delim == ')' && !delims.peek().equals('(')){
                return "NO"; 
            }else{
                delims.pop(); 
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
