import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(s[i]);
            // map.put(key, 0);
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(s[i]);
            if(map.containsKey(k - key)) {
                cnt += map.get(key);
            } map.put(key, map.getOrDefault(key, 0) + 1);
        }
        System.out.println(cnt);
    }
}