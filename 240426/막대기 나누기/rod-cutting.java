import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] board = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + board[j]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}