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

        ArrayList<Node> arr = new ArrayList<>();
        for(Integer key : map.keySet()) {
            arr.add(new Node(key, map.get(key)));
        }   
        Collections.sort(arr, (o1, o2) -> {
            if(o1.value == o2.value) {
                return o2.key - o1.key; 
            } return o2.value - o1.value;
        });
         
        for(int i = 0; i < k; i++) {
            System.out.print(arr.get(i).key + " ");
        }
    }
    static class Node {
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
/**
3, 2
2, 1
1, 2
**/