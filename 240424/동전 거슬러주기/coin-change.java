import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new 	InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] board = new int[n + 1];
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 100_001);
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }
        dp[0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - board[j] >= 0) {
                    if(dp[i - board[j]] == 100_001) continue;
                    dp[i] = Math.min(dp[i], dp[i - board[j]] + 1);
                }
            }
        }
        System.out.println(dp[m]);
    }
}