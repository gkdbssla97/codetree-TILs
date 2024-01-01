import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int aLen = Integer.parseInt(s[0]);
        int bLen = Integer.parseInt(s[1]);
        int cnt = 0;
        s = br.readLine().split(" ");
        HashSet<Integer> a = new HashSet<>();
        for(String str : s) {
            a.add(Integer.parseInt(str));
        }
        s = br.readLine().split(" ");
        HashSet<Integer> b = new HashSet<>();
        int aCnt = 0;
        for(String str : s) {
            int val = Integer.parseInt(str);
            b.add(val);
            if(a.contains(val)) {
                aCnt++;
            } else {
                cnt++;
            }
        }
        System.out.println(a.size() - aCnt + cnt);
    }
}