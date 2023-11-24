import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n + 1];
        
        String[] s = br.readLine().split(" ");
        int sum = 0;
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
            sum += board[i + 1];
        }
        int[][] dp = new int[n + 1][sum + 1];
        // 10 - 2n
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if(j - board[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - board[i]] + board[i], dp[i - 1][j]);
                } 
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++) {
            // for(int j = 0; j <= n; j++) {
                res = Math.min(res, Math.abs(sum -  2 * dp[n][i]));
            // }
        }
        // for(int i = 0; i <= n; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(res);
    }
}