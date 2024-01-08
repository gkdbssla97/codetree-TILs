import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        int left = 1;
        int right = s - 1;
        int res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if((mid) * (mid + 1) / 2 <= s) {
                left = mid + 1;
                res = Math.max(res, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
}