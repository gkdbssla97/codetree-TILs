import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Integer, Integer> map = new LinkedHashMap<>();
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String cmd = s[0];
            int key = -1;
            int value = -1;
            if(cmd.equals("add")) {
                key = Integer.parseInt(s[1]);
                value = Integer.parseInt(s[2]);
            } else {
                key = Integer.parseInt(s[1]);
            }
            if(cmd.equals("add")) map.put(key, value);
            else if(cmd.equals("find")) {
                if(map.get(key) == null) System.out.println("None");
                else System.out.println(map.get(key));
            } else if(cmd.equals("remove")) {
                if(map.get(key) == null) continue;
                else map.remove(key);
            }
        }
    }
}