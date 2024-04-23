import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n + 1];
        int[] dp = new int[n + 1];

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= i + board[i]; j++) {
                if(j > n) {
                    dp[n] = Math.max(dp[n], dp[n - 1]);
                } else {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}