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
        int n = words.length();
        int cnt = 0;
        int len = -1;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int left = 0; left < n; left++) {
            while(right < n) {
                char c = words.charAt(right++);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == 1) {
                    cnt++;
                }
                if(cnt > k) {
                    len = Math.max(len, right - left - 1);
                    break;
                }
                // System.out.println("l, r" + " " + left + " " + right);
            }
            if(right == n && len == -1) {
                len = right - left;
                // System.out.println(len);
                break;
            }
            char l = words.charAt(left);
            map.put(l, map.get(l) - 1);
            if(map.get(l) == 0) {
                cnt--;
            }
        }

        System.out.println(len);
    }
}