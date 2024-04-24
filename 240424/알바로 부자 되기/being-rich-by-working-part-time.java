import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][3];
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++) {
            String [] s = br.readLine().split(" ");
            int _s = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            int p = Integer.parseInt(s[2]);
            board[i + 1][0] = _s;
            board[i + 1][1] = e;
            board[i + 1][2] = p;
            dp[i + 1] = p;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(board[j][1] < board[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + board[j][2]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}