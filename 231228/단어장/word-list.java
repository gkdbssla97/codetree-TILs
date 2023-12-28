import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }   
}