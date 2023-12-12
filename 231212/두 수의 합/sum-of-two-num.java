import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countPairs(arr, k));
    }

    private static int countPairs(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num : arr) {
            if(map.containsKey(k - num)) {
                count += map.get(k - num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}