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
        board = new int[n][m];
        dp = new int[n][m];
        max = 1;
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                check(i, j);
            }
        }
        // print();
        System.out.println(max + 1);   
    }
    static void check(int x, int y) {
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(board[x][y] > board[i][j]) {
                   dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
                }
                max = Math.max(max, dp[x][y]);
            }
        }
    }

    static void print() {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}