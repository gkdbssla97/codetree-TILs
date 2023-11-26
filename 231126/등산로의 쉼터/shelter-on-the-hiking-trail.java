import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] cost = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            cost[i + 1] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            if(cost[start] < cost[end]) {
                arr.get(start).add(end);
            }

            if(cost[end] < cost[start]) {
                arr.get(end).add(start);
            }
        }

        for(int i = 1; i <= n; i++) {
            int result = dijkstra(i, n, cost);
            // System.out.println("----");
            System.out.println(result);
        }
    }
    static int dijkstra(int start, int n, int[] cost) {
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 1));
        boolean[][][] visited = new boolean[n + 1][n + 1][n + 1];
        while(!q.isEmpty()) {
            Node p = q.poll();
            // System.out.println(p.route);
            max = Math.max(max, p.cnt);

            for(int i = 0; i < arr.get(p.idx).size(); i++) {
                int next = arr.get(p.idx).get(i);
                if(cost[next] > cost[p.idx] && !visited[start][p.idx][p.cnt]) {
                    visited[start][p.idx][p.cnt] = true;
                    q.offer(new Node(next, p.cnt + 1));
                }
            }
        }
        return max;
    }
    static class Node {
        int idx, cnt;
        
        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}