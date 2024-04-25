import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] board = new int[n];
        int[] dp = new int[m + 1];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j - board[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - board[i]] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        String str = "No";
        if(dp[m] != 10001) str = "Yes";
        System.out.println(str);
    }
}