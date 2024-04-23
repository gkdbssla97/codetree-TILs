import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][2];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int x2 = Integer.parseInt(s[1]);
            board[i + 1][0] = x1;
            board[i + 1][1] = x2;
        }

        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(board[j][1] < board[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}