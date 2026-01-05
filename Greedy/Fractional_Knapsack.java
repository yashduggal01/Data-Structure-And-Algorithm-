import java.util.*;
public class Fractional_Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        double maxValue = fractionalKnapsack(weights, values, n, capacity);
        System.out.printf("%.2f\n", maxValue);
        sc.close();
    }
    static double fractionalKnapsack(int[] weights, int[] values, int n, int capacity) {
        double[][] arr = new double[n][3];
        for(int i =0;i<n;i++){
            arr[i][0]=weights[i];
            arr[i][1]=values[i];
            arr[i][2]=(double)values[i]/weights[i];
        }
        Arrays.sort(arr, (a, b) -> Double.compare(b[2], a[2]));
        double totalValue = 0.0;
        for(int i =0;i<n;i++){
            int wt = (int) arr[i][0];
            int val = (int) arr[i][1];
            if(capacity==0){
                break;
            }
            if(capacity>=wt){
                totalValue+=val;
                capacity-=wt;
            }
            else{
                totalValue+=val*((double)capacity/wt);
                capacity=0;
                break;
            }
        }
        
        return totalValue;
    }
}
