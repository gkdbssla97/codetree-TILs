import java.util.*;
import java.io.*;

public class Main {
    static int[][] board, dp;
    static int n, m, max;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int[][] board = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                board[i + 1][j + 1] = Integer.parseInt(s[j]);
            }
        }

        dp[1][1] = 1;

        for(int i = 0; i <= n ; i++) {
            for(int j = 0; j <= m; j++) {

                for(int x = i + 1; x <= n; x++) {
                    for(int y = j + 1; y <= m; y++) {
                        if(board[x][y] > board[i][j]) {
                            dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i <= n; i++) {
            int tmp = Arrays.stream(dp[i]).map(e -> e).max().getAsInt();
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}