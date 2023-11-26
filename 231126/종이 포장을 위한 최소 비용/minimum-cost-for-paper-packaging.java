import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] stone = new int[n + 1];
        int[] box = new int[m + 1];
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++) {
            stone[i + 1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(stone);
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 1 2 4 8 11 12
        for(int i = 0; i < m; i++) {
            box[i + 1] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        stone[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = i; j >= 1; j--) {
                dp[i] = Math.min(dp[i], dp[j - 1] + box[stone[i] - stone[i - 1] + 1]);
            }
            System.out.println(Arrays.toString(dp));
        }

        
    }
}