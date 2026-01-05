import java.util.*;
public class Job_Scheduling {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] deadlines= new int[n];
        int[] profits = new int[n];
        for(int i = 0;i<n;i++){
            deadlines[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }
        int maxprofit = jobScheduling(deadlines, profits, n);
        System.out.println(maxprofit);
        sc.close();
}
static int jobScheduling(int[] deadlines , int[] profits , int n){
    int[][] arr = new int[n][2];
    for(int i=0;i<n;i++){
        arr[i][0] = deadlines[i];
        arr[i][1] = profits[i];
    }
    Arrays.sort(arr,(a,b) -> b[1]-a[1]);
    int total_slot = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        total_slot=Math.max(total_slot,arr[i][0]);
    }
    int maxprofit=0;
    boolean[] slot = new boolean[total_slot];
    for(int i =0;i<n;i++){
        int deadline = arr[i][0];
        int profit = arr[i][1];
        for(int j = Math.min(deadline,total_slot)-1;j>=0;j--){
            if(!slot[j]){
                slot[j]=true;
                maxprofit+=profit;
                break;
            }
        }
    }
return maxprofit;
}
}
