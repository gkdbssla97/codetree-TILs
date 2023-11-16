import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][2];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            board[i][0] = start;
            board[i][1] = end;
        }

        Arrays.sort(board, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } return Integer.compare(o1[0], o2[0]);
        });
        
        int end = -1;
        int cnt = 0;
        int max = 0;
        Arrays.fill(dp, 1);
        for(int j = 1; j < n; j++) {
            for(int i = 0; i < n; i++) {
                if(board[j][0] > board[i][1]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);
                } 
            }
        }
        System.out.println(max);
    }
}