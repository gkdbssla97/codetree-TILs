import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] board = new int[n + 1][2];
        int[] dp = new int[m + 1];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            board[i + 1][0] = w;
            board[i + 1][1] = v;
        }

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i - board[j][0] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - board[j][0]] + board[j][1]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}