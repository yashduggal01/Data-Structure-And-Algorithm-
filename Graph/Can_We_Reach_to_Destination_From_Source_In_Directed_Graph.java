package Graph;
import java.util.*;

public class Can_We_Reach_to_Destination_From_Source_In_Directed_Graph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        if(canReach(n, adj, source, destination))
            System.out.println("YES");
        else
            System.out.println("NO");

        sc.close();
    }

    static boolean canReach(int n, List<List<Integer>> adj, int source, int destination){

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()){

            int curr = queue.poll();

            if(curr == destination)
                return true;

            for(int neighbor : adj.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
