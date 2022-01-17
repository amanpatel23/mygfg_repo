// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = new String[N];
            
            for(int i=0; i<N; i++)
                arr[i] = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.palindromepair(N,arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palindromepair(int N, String arr[]) {

        Map<String, Integer> freq = new HashMap<>();
        for (String s : arr)
            freq.put(s, freq.getOrDefault(s, 0) + 1);

        for (String s : arr) {
            String rev1 = new StringBuilder(s).reverse().toString();
            if (freq.containsKey(rev1)) {
                if (!s.equals(rev1))
                    return 1;
                else if (freq.get(s) > 1)
                    return 1;
            }
        }

        for (String s : arr) {
            int len = s.length();
            for (int i = 0; i <= (len - 2); i++) {
                if (isPalindrome(s, 0, i)) {
                    String rev = new StringBuilder(s.substring(i + 1)).reverse().toString();
                    if (freq.containsKey(rev))
                        return 1;
                }

                if (isPalindrome(s, i + 1, len - 1)) {
                    String rev = new StringBuilder(s.substring(0, i + 1)).reverse().toString();
                    if (freq.containsKey(rev))
                        return 1;
                }
            }
        }

        return 0;
    }

    private static boolean isPalindrome(String s, int l, int r) {

        int i = l, j = r;
        while (j - i >= 1) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
};