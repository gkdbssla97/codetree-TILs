import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n + 2];
        int[][] dp = new int[n + 2][2];
        String[] s = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }
    

        // 1. 증가 -> 감소 
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 1; j < i; j++) {
                if(board[j] < board[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }
        // 2. 감소 -> 증가 
        for(int i = n; i >= 1; i--) {
            dp[i][1] = 1;
            for(int j = i + 1; j <= n; j++) {
                if(board[j] < board[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }

        // int left = 0;
        // for(int i = 1; i <= n; i++) {
        //     System.out.print(dp[i][0] + " ");
        //     // left = Math.max(left, dp[i][0]);
        // }
        // System.out.println();

        // int right = 0;
        // for(int i = 1; i <= n; i++) {
        //     System.out.print(dp[i][1] + " ");
        //     // right = Math.max(right, dp[i][1]);
        // } 
        // System.out.println();
        // 왼쪽에서부터, 오른쪽에서부터 중간에 만나는 교차점은 어떻게 판단?
        // 선형탐색으로 그냥 최댓값인거 찾아내면됨 

        int max = 0;
        for(int i = 1; i <= n; i++) {
            
            max = Math.max(max, dp[i][0] + dp[i][1] - 1);
            
        }
        System.out.println(max);
    }
}