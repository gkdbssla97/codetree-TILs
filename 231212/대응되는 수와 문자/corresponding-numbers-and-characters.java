import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.

        HashMap<String, Integer> map1 = new LinkedHashMap<>();
        HashMap<Integer, String> map2 = new LinkedHashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            map1.put(str, i);
            map2.put(i, str);
        }
        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            if(str.compareTo("0") >= 0 && str.compareTo("9") <= 0) {
                System.out.println(map2.get(Integer.parseInt(str)));
            } else System.out.println(map1.get(str));
        }
    }
}