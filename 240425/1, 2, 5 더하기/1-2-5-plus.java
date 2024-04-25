import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = {1, 2, 5};
    static int n;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new 	InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
        int[] board = {1, 2, 5};
        int[] dp = new int[n + 1];
        
        // Arrays.fill(dp, 1001);
        dp[0] = 1;
        for(int j = 0; j <= n; j++) {
            for(int i = 0; i < 3; i++) {
                if(j - board[i] >= 0) {
                    dp[j] = (dp[j] + dp[j - board[i]]) % 10007;
                }
            }
        }
        
        System.out.println(dp[n] % 10007);
    }
}