package Graph;
import java.util.*;
public class Find_The_Minimum_Edges_in_the_path_in_Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minEdges(n));
        sc.close();
    }
    static int minEdges(int n ){
        if(n <= 1) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        queue.add(1);
        visited[1] = true;
        distance[1] = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == n){
                return distance[curr];
            }
            if(curr + 1 <= n && !visited[curr + 1]){
                queue.add(curr + 1);
                visited[curr + 1] = true;
                distance[curr + 1] = distance[curr] + 1;
            }
            if(curr * 3 <= n && !visited[curr * 3]){
                queue.add(curr * 3);
                visited[curr * 3] = true;
                distance[curr * 3] = distance[curr] + 1;
            }
    }
    return -1;
}
}
