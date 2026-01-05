import java.util.*;
class count_no_of_ways_to_cover_distance {
static int[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int k = sc.nextInt();
        dp=new int[d+1];
        Arrays.fill(dp,-1);
        System.out.println(countWays(d, k));
        sc.close();
    }
    static int countWays(int d , int k){
        if(d==0){
            return 1;
        }
        if(d<0){
            return 0;
        }
        int ways = 0;
        for(int i =1 ;i<=k;i++){
            ways +=countWays(d-i, k);
        }
        return dp[d]=ways;
    }
}