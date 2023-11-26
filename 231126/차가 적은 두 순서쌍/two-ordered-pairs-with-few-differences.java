import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] board = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(board);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 4; i++) {
            for(int j = n - 1; j >= i + 3; j--) {
                int left = i + 1;
                int right = j - 1;
                while(left < right) {
                    int L = board[i] - board[left];
                    int R = board[j] - board[right];
                    int sum = Math.abs(L - R);
                    min = Math.min(min, Math.abs(sum));
                    if(sum <= 0) {
                        left++;    
                    } else {
                        right--;
                    }
                    
                }
            }
        }
        System.out.println(min);
    }
}