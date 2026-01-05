import java.util.*;
public class ZeroOneKnapsack {
    static int[][] dp ;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i =0 ;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i =0 ;i<n;i++){
            val[i]=sc.nextInt();
        }
        dp = new int[n+1][W+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(knapsack(wt, val, W, n));
        sc.close();
    }
    static int knapsack(int[] wt, int[] val, int W, int n) {
       if(n==0 || W==0){    
           return 0;
       }
       if(dp[n][W]!=-1){
           return dp[n][W];
       }
       if(wt[n-1]<=W){
              int include = val[n-1] + knapsack(wt, val, W - wt[n-1], n - 1);
              int exclude = knapsack(wt, val, W, n - 1);
              return dp[n][W] = Math.max(include, exclude);
         } else {
              return dp[n][W] = knapsack(wt, val, W, n - 1);
       }
}
}
