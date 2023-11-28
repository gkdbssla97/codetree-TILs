import java.util.*;
import java.io.*;

public class Main {
    static int[] dp, parent;
    static boolean[] visited;
    static int max = 0;
    static int idx = 0;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        dp = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            arr.get(start).add(new Node(end, cost));
            arr.get(end).add(new Node(start, cost));
        }
        visited[1] = true;
        dfs(1, 0);
        // System.out.println(idx + " " + max);
        visited = new boolean[n + 1];
        
        max = 0;
        visited[idx] = true;
        dfs(idx, 0);
        System.out.println(max);
    }
    
    static void dfs(int start, int cost) {
        if(max < cost) {
            max = cost;
            idx = start;
        }
        for(int i = 0; i < arr.get(start).size(); i++) {
            Node next = arr.get(start).get(i);
            if(!visited[next.end]) {
                visited[next.end] = true;
                dfs(next.end, cost + next.cost);
            }
        }
    }

    static class Node {
        int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}