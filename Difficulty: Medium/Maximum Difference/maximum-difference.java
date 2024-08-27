//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int maxDiff = 0;
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<n;i++){
            while(!s.isEmpty() && s.peek() >= arr[i])
                s.pop();
            l[i] = s.isEmpty() ? 0 : s.peek();
            s.push(arr[i]);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek() >= arr[i])
                s.pop();
            r[i] = s.isEmpty() ? 0 : s.peek();
            s.push(arr[i]);
        }
        for(int i=0;i<n;i++)
            maxDiff = Math.max(maxDiff, Math.abs(l[i] - r[i]));
            
        return maxDiff;
    }
}
