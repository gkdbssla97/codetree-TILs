import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        board = new int[n + 1][2];
        // visited = new boolean[sum + 1][n + 1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            board[i + 1][0] = w;
            board[i + 1][1] = v;
            sum += w;
        }
        dp = new int[n + 1][m + 1];
        int max = -1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j >= board[i][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j - board[i][0]] + board[i][1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i -1][j];
                }
                max = Math.max(dp[i][j], max);
            }
            // System.out.println(Arrays.toString(dp));
        }
        for(int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(max);
    }
}