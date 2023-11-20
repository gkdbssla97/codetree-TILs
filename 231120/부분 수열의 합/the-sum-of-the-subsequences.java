import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] board = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                //CASE 1: i - 1번째 선택
                if(j - board[i] >= 0 && dp[i - 1][j - board[i]]) {
                    dp[i][j] = true; 
                } 
                if(dp[i - 1][j]) dp[i][j] = true;
            }
        }
        System.out.println(dp[n][m] ? "Yes" : "No");
    }
}