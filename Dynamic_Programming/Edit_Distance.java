import java.util.*;
public class Edit_Distance {
    static int[][] dp ;
    static int minop(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(str1, str2, m, n);
    }
    static int solve(String str1, String str2, int m, int n) {
        if (m == 0) {
            return n; // Insert all characters of str2
        }
        if (n == 0) {
            return m; // Remove all characters of str1
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            dp[m][n] = solve(str1, str2, m - 1, n - 1);
        } else {
            int insertOp = 1 + solve(str1, str2, m, n - 1);
            int removeOp = 1 + solve(str1, str2, m - 1, n);
            int replaceOp = 1 + solve(str1, str2, m - 1, n - 1);
            dp[m][n] = Math.min(insertOp, Math.min(removeOp, replaceOp));
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
       int minoperations = minop(str1, str2);
       System.out.println(minoperations);
        sc.close();
    }
}
