import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] cost, parent, dp;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        parent = new int[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            
            arr.get(i + 2).add(c);
            arr.get(c).add(i + 2);
            parent[i + 2] = c;
            if(a == 1) {
                cost[i + 2] = b;
            } else {
                cost[i + 2] = 0;
            }
        }
        visited[1] = true;
        dfs(1);
        System.out.println(dp[1]);
    }
    static void dfs(int x) {

        for(int i = 0; i < arr.get(x).size(); i++) {
            int y = arr.get(x).get(i);
            if(!visited[y]) {
                visited[y] = true;
                dfs(y);
            }
        }
        dp[x] = cost[x];

        for(int i = 0; i < arr.get(x).size(); i++) {
            int y = arr.get(x).get(i);
            if(parent[y] == x) {
                dp[x] += dp[y];
            }
        }
    }
}