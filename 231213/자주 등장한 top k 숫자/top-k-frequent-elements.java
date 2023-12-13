import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        // 3 3 2 1 1
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(s[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());
        entry.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed()
            .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())));

        HashMap<Integer, Integer> sorted = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> e : entry) {
            sorted.put(e.getKey(), e.getValue());
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> sEntry : sorted.entrySet()) {
            if(cnt == k) break;
            System.out.print(sEntry.getKey() + " ");
            cnt++;
        }
    }
}