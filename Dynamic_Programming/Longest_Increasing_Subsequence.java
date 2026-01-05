import java.util.*;    
public class Longest_Increasing_Subsequence {
    static int[][] dp ;
    static int lengthOfLIS(int[] nums) {
        dp = new int[nums.length+1][nums.length+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(nums,0,-1);
    }
    static int solve(int[] nums , int curr, int prev){
        if(curr == nums.length){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int take = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + solve(nums, curr+1, curr);
        }
        int notTake = solve(nums, curr+1, prev);
        dp[curr][prev+1] = Math.max(take, notTake);
        return dp[curr][prev+1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(arr));
        sc.close();
    }
}
