import java.util.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n + 1];
        int[] dp = new int[n + 1];
        
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }
        Arrays.fill(dp, 1);
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(board[j] < board[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());
    }
}