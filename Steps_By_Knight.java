// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    
    private static final int[] kdr = new int[]{-2, -2, 2, 2, -1, 1, -1, 1};
    private static final int[] kdc = new int[]{-1, 1, -1, 1, 2, 2, -2, -2};
    private static Queue<int[]> qq;
    private static boolean[][] visited;
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int k[], int t[], int n)
    {
        // Code here
        
        qq = new LinkedList<>();
        visited = new boolean[n + 5][n + 5];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(visited[i], false);
        }
        
        qq.offer(new int[]{k[0], k[1]});
        visited[k[0]][k[1]] = true;
        int steps = 0; 
        while (!qq.isEmpty()) {
            int size = qq.size();
            while (size-- > 0) {
                int[] top = qq.poll();
                //System.out.println(top[0] + " " + top[1]);
                if (top[0] == t[0] && top[1] == t[1])
                    return steps;
                util(n, top[0], top[1]);
            }
            steps++;
        }
        
        return -1;
    }
    
    private static void util(int n, int r, int c) {
        for (int i = 0; i < 8; i++) {
            int r_new = r + kdr[i];
            int c_new = c + kdc[i];
            if (r_new >= 1 && r_new <= n && c_new >= 1 && c_new <= n && !visited[r_new][c_new]) {
                qq.offer(new int[]{r_new, c_new});
                visited[r_new][c_new] = true;
            }
        }
    }
}
