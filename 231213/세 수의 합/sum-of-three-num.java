import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        // -1 1 1 2 4
        int cnt = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int target = k - arr[i] - arr[j];
                int left = j + 1;
                int right = n - 1;

                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(arr[mid] == target) {
                        cnt++;
                        break;
                    } else if(arr[mid] > target) {
                        right--;
                    } else left++;
                }
            }
        }
        System.out.println(cnt);
    }
}