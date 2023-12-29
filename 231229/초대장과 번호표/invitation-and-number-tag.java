import java.util.*;
import java.io.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int g = Integer.parseInt(s[1]);
        for(int j = 0; j < g; j++) {
            s = br.readLine().split(" ");
            int cnt = Integer.parseInt(s[0]);
            HashSet<Integer> tmp = new HashSet<>();
            int size = 0;
            int num = -1;
            for(int i = 1; i <= cnt; i++) {
                int v = Integer.parseInt(s[i]);
                if(v == 1) {
                    set.add(1);
                    size++;
                } else if(set.contains(v)) {
                    size++;
                } else {
                    num = v;
                }
            }
            if(size == cnt - 1) {
                if(num != -1) set.add(num);
            }
        }
        System.out.println(set.size());
    }
}