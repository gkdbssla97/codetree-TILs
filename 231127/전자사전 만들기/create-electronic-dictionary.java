import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int t = Integer.parseInt(s[1]);
        String[] board = new String[n];

        HashMap<String, List<String>> map = new LinkedHashMap<>();
        HashMap<String, Integer> index = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            board[i] = word;
            index.put(word, i + 1);
        }

        
        for(int i = 0; i < t; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            String b = s[1];

            if(map.get(b) == null) {
                List<String> arr = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    if(board[j].startsWith(b)) {
                        arr.add(board[j]);
                    }
                }
                Collections.sort(arr, (o1, o2) -> o1.compareTo(o2));
                
                map.put(b, arr);
                
                List<String> list = map.get(b);
                // System.out.println(list);
                if(list.size() > 0) {
                    if(list.size() >= a) {
                        System.out.println(index.get(list.get(a - 1)));
                    } else {
                        System.out.println(-1);
                    }
                } else System.out.println(-1);
            } else {
                List<String> list = map.get(b);
                if(list.size() > 0) {
                    if(list.size() >= a) {
                        System.out.println(index.get(list.get(a - 1)));
                    } else {
                        System.out.println(-1);
                    }
                } else System.out.println(-1);
            }
        }
    }
}