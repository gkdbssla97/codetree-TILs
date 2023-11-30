import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= 10_000; i++) {
            arr.add(new ArrayList<>());
        }
        
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            arr.get(start).add(end);
            int tmp = Math.max(start, end);
            max = Math.max(max, tmp);
            set.add(start);
        }
        Queue<Integer> q = new LinkedList<>(set);
        // System.out.println("max: " + max);
        boolean flag = false;
        while(!q.isEmpty()) {
            int p = q.poll();
            // System.out.println(p);
            visited = new boolean[max + 1];
            visited[p] = true;
            dfs(p);
            int cnt = (int)(IntStream.rangeClosed(0, max).filter(e -> visited[e]).count());
            // System.out.println(cnt);
            if(cnt == max) {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
    static void dfs(int start) {

        for(int i = 0; i < arr.get(start).size(); i++) {
            int next = arr.get(start).get(i);
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}