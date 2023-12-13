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
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(s[i]);
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 1 -> 2
        // 2 -> 1
        // 4 -> 1
        // -1 -> 1
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
            }
            for(int j = 0; j < i; j++) {
                int target = k - arr[i] - arr[j];
                if(map.containsKey(target)) {
                    cnt += map.get(target);
                }
            }
        }
        System.out.println(cnt);
    }
}