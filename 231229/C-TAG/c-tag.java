import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] selected;
    static String[] a, b;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        selected = new int[3];
        a = new String[n];
        b = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }
        for(int i = 0; i < n; i++) {
            b[i] = br.readLine();
        }
        combination(0, 0, 3);
        System.out.println(answer);
    }
    static void combination(int start, int cnt, int r) {
        if(cnt == r) {
            // System.out.println(Arrays.toString(selected));
            HashSet<String> setA = new HashSet<>();
            HashSet<String> setB = new HashSet<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                String str = a[i];
                for(int j = 0; j < 3; j++) {
                    sb.append(str.charAt(selected[j]));
                }
                setA.add(sb.toString());
            }
            // System.out.println(setA);
            boolean flag = true;
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                String str = b[i];
                for(int j = 0; j < 3; j++) {
                    sb.append(str.charAt(selected[j]));
                }
                // if(selected[0] == 5 && selected[1] == 6 && selected[2] == 7) {
                //     System.out.println(sb.toString());
                // }
                if(setA.contains(sb.toString())) {
                    return;
                }
            }
            // if(selected[0] == 5 && selected[1] == 6 && selected[2] == 7) {
            //     System.out.println(Arrays.toString(selected));
            //     System.out.println(setA);
            // }
            answer++;
            return;
        }
        for(int i = start; i < m; i++) {
            selected[cnt] = i;
            combination(i + 1, cnt + 1, r);
        }
    }
}