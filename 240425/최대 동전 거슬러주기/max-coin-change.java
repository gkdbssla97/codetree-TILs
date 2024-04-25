import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new 	InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
	    int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        
        int[] board = new int[n];
        int[] dp = new int[m + 1];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        dp[0] = 0;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - board[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - board[j]] + 1);
                }
            }
        }
        
        int res = -1;
        if(dp[m] != 0) res = dp[m];
        System.out.println(res);
    }
}