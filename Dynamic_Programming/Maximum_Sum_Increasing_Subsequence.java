import java.util.*;
public class Maximum_Sum_Increasing_Subsequence {
    static int[][] dp ;
    static int msis(int[] arr) {
        dp = new int[arr.length + 1][arr.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(arr, 0, -1);
    }
    static int solve(int[] arr, int curr, int prev) {
        if (curr == arr.length) {
            return 0;
        }
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }
        int take = 0;
        if (prev == -1 || arr[curr] > arr[prev]) {
            take = arr[curr] + solve(arr, curr + 1, curr);
        }
        int notTake = solve(arr, curr + 1, prev);
        dp[curr][prev + 1] = Math.max(take, notTake);
        return dp[curr][prev + 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxsum = msis(arr);
        System.out.println(maxsum);
        sc.close();
    }
}

