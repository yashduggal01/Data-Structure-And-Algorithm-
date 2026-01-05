import java.util.*;
public class Longest_Common_Subsequence {
    static int[][] dp ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        dp = new int[s1.length()+1][s2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int length = solve(s1,s2,0,0);
        System.out.print(length);
        sc.close();
    }
    static int solve(String s1 , String s2,int i , int j){
        if (i>=s1.length()||j>=s2.length()) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+solve(s1,s2,i+1,j+1);
        }
        int take = solve(s1, s2, i+1, j);
        int skip = solve(s1, s2, i, j+1);
        return dp[i][j]=Math.max(take,skip);
    }
}
