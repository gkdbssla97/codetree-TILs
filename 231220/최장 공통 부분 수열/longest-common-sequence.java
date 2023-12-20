import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int lenA, lenB;
    static String A, B;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = " " + br.readLine();
        B = " " + br.readLine();
        // System.out.println(A.charAt(1));
        // System.out.println(B.charAt(1));
        lenA = A.length() - 1;
        lenB = B.length() - 1;
        dp = new int[lenA + 1][lenB + 1];
        initialize();
        for(int i = 2; i <= lenA; i++) {
            for(int j = 2; j <= lenB; j++) {
                if(A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // print();
        System.out.println(dp[lenA][lenB]);
    }
    static void initialize() {
        dp[1][1] = (A.charAt(1) == B.charAt(1)) ? 1 : 0;
        for(int i = 2; i <= lenA; i++) {
            if(A.charAt(i) == B.charAt(1)) {
                dp[i][1] = 1;
            } else {
                dp[i][1] = dp[i - 1][1];
            }
        }

        for(int j = 2; j <= lenB; j++) {
            if(A.charAt(1) == B.charAt(j)) {
                dp[1][j] = 1;
            } else {
                dp[1][j] = dp[1][j - 1];
            }
        }
    }

    static void print() {
        for(int i = 0; i <= lenA; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}