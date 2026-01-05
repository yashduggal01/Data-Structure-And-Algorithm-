import java.util.*;
public class minimum_cost_path_to_last_element {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(minCostPath(cost, m, n, 0, 0));
        sc.close();
    }
    static int minCostPath(int[][]cost , int m, int n , int i , int j){
        if(i==m&&j==n){
            return cost[m-1][n-1];
        }
        if(i>=m||j>=n){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = minCostPath(cost, m, n, i + 1, j);
        int right = minCostPath(cost, m, n, i, j + 1);
        int diag = minCostPath(cost, m, n, i + 1, j + 1);
        return dp[i][j] = cost[i][j] + Math.min(down, Math.min(right, diag));
    
    }
}
