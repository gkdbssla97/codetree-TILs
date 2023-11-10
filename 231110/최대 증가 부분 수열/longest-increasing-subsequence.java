import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];
        int[] dp = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < s.length; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(board[i] > board[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(max);
    }
}