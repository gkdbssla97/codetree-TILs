import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(s[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        s = br.readLine().split(" ");
        for(int i = 0; i < s.length; i++) {
            int key = Integer.parseInt(s[i]);
            if(map.containsKey(key)) System.out.print(map.get(key) + " ");
            else System.out.print(0 + " ");
        }
    }
}