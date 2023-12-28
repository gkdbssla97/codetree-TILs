import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("add")) {
                int k = Integer.parseInt(s[1]);
                int v = Integer.parseInt(s[2]);
                map.put(k , v);
            } else if(s[0].equals("find")) {
                int k = Integer.parseInt(s[1]);
                System.out.println(map.containsKey(k) ? map.get(k) : "None");
            } else if(s[0].equals("print_list")) {
                if(map.size() == 0) System.out.println("None");
                else {
                    for(Integer value : map.values()) {
                        System.out.print(value + " ");
                    } System.out.println();
                }
            } else if(s[0].equals("remove")) {
                int k = Integer.parseInt(s[1]);
                map.remove(k);
            }
        }
    }   
}