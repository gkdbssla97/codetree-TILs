import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        long[] dp = new long[n];
        for(int i = 0; i < n; i++) {
            String[] _s = br.readLine().split(" ");
            int s = Integer.parseInt(_s[0]);
            int e = Integer.parseInt(_s[1]);
            int p = Integer.parseInt(_s[2]);

            board[i][0] = s;
            board[i][1] = e;
            board[i][2] = p;

            dp[i] = p;
        }
        Arrays.sort(board, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                Integer.compare(o1[1], o2[1]);
            } return Integer.compare(o1[0], o2[0]);
        });
        long max = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
               if(board[j][1] < board[i][0]) {
                    dp[i] += dp[j];
                    max = Math.max(max, dp[i]);
               } 
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsLong());
    }
}