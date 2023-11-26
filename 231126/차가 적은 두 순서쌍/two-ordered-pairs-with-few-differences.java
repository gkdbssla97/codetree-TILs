import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        
        int left = 0, right = n - 1;
        int minDiff = Integer.MAX_VALUE;
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                left = i + 1;
                right = j - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] - arr[left] - arr[right];
                    if (Math.abs(sum) < minDiff) {
                        minDiff = Math.abs(sum);
                        a = arr[i];
                        b = arr[j];
                        c = arr[left];
                        d = arr[right];
                    }
                    if (sum <= 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        System.out.println(minDiff);
    }
}