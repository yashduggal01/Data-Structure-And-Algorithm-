import java.util.*;
public class Minimum_Coins {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int amount = sc.nextInt();
    int n = sc.nextInt();
    int[] coins = new int[n];
    for(int i=0;i<n;i++){
        coins[i] = sc.nextInt();
    }
    int min_coins = findMinimumCoins(coins, amount);
    System.out.println(min_coins);
    sc.close();
}
static int findMinimumCoins(int[] coins , int amount){
    Arrays.sort(coins);
    int count = 0 ;
    for(int i=coins.length-1;i>=0;i--){
        while(amount>=coins[i]){
            amount -= coins[i];
            count++;
        }
    }
    return count ;
}
}