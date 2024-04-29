import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] s = br.readLine().split(" ");
        int sum = 0;
        
        int[] board = new int[n + 1];

        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(s[i]);
            board[i + 1] = Integer.parseInt(s[i]);
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        int max = (int)1e9;
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j - board[i] >= 0 && dp[i - 1][j - board[i]]) {
                    dp[i][j] = true;
                }
                if(dp[i - 1][j]) dp[i][j] = true;
            }
        }
        for(int i = 1; i <= sum; i++) {
            if(dp[n][i])
                max = Math.min(max, Math.abs(i - (sum - i)));
        }
        System.out.println(max);
    }
}