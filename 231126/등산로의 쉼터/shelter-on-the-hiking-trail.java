import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] cost = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            cost[i + 1] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            if(cost[start] < cost[end]) {
                arr.get(start).add(end);
            }

            if(cost[end] < cost[start]) {
                arr.get(end).add(start);
            }
        }
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = dijkstra(i, n, cost, dp);
            // System.out.println("----");
            System.out.println(dp[i]);
        }
    }
    static int dijkstra(int start, int n, int[] cost, int[] dp) {
        if(dp[start] != 0) {
            return dp[start];
        }
        int max = 0;
        for(int i = 0; i < arr.get(start).size(); i++) {
            int next = arr.get(start).get(i);
            max = Math.max(max, dijkstra(next, n, cost, dp));
        }
        dp[start] = max + 1;
        return dp[start];
    }
}