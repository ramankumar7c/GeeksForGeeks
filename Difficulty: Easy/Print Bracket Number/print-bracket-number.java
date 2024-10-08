//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        int op = 0;
        ArrayList<Integer>result = new ArrayList<>();
        int[] stack = new int[str.length()];
        int stackIndex = -1;
        
        for(char c : str.toCharArray()){
            if(c == '('){
                op++;
                stack[++stackIndex]=op;
                result.add(op);
            }
            else if(c==')')
                result.add(stack[stackIndex--]);
        }
        return result;
    }
};