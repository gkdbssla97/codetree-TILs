import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String words = s[0];
        int k = Integer.parseInt(s[1]);

        int right = 0;
        int left = 0;
        int n = words.length();
        int cnt = 0;
        int len = -1;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        while(left <= right && right < n) {
            char c = words.charAt(right);
            if(!map.containsKey(c) && cnt < k) {
                if(right == len) {
                    len = Math.max(len, right - left - 1);
                } else {
                    len = Math.max(len, right - left);
                }
                right++;
                cnt++;
                map.put(c, 1);
            } else if(cnt <= k && map.containsKey(c)) {
                if(right == len) {
                    len = Math.max(len, right - left - 1);
                } else {
                    len = Math.max(len, right - left);
                }
                right++;
            } else if(!map.containsKey(c) && cnt >= k) {
                if(right == len) {
                    len = Math.max(len, right - left - 1);
                } else {
                    len = Math.max(len, right - left);
                }
                map.remove(words.charAt(left));
                left++;
                cnt--;    
            }
            // System.out.println("l, r" + " " + left + " " + right);
        }
        if(right == len) {
            len = Math.max(len, right - left - 1);
        } else {
            len = Math.max(len, right - left);
        }
        System.out.println(len);
    }
}