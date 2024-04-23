import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n];
        int[] dp = new int[n];

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == Integer.MIN_VALUE) continue;
                if(j + board[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}