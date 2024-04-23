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
        Arrays.sort(board, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(board[j][1] < board[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}