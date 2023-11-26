import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new 	InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 0; i < s.length; i++) {
            arr[i + 1] = Integer.parseInt(s[i]);
        }
        dp[1] = arr[1];

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        int res = Integer.MIN_VALUE;
        // System.out.println(Arrays.toString(dp));
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}