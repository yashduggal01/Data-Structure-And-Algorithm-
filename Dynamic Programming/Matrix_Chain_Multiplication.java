import java.util.*;
public class Matrix_Chain_Multiplication {
 static int[][] dp ;
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int[] arr = new int[n];
     for(int i =0 ;i<n;i++){
         arr[i]=sc.nextInt();
     }
     dp = new int[n][n];
     for(int[] row : dp){
         Arrays.fill(row,-1);
     }
     System.out.println(solve(arr,1,n));
     sc.close();
 }   
 static int solve(int[] arr , int i , int j){
     if(i>=j){
         return 0;
     }
     if(dp[i][j]!=-1){
         return dp[i][j];
     }
     int min = Integer.MAX_VALUE;
     for(int k = i ;k<j;k++){
         int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
         min = Math.min(min, temp);
     }
     return dp[i][j]=min;
 }
}
