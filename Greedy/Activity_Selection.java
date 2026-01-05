import java.util.*;
public class Activity_Selection {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];
        for(int i=0;i<n;i++){
            start[i] = sc.nextInt();
            finish[i] = sc.nextInt();
        }
        activity_selection(start, finish, n);
        sc.close();
    }
    static void activity_selection(int[] start , int[] finish , int n){
        int[][] arr = new int[n][2];
        for(int i = 0 ; i<n;i++){
            arr[i][0]=start[i];
            arr[i][1]=finish[i];
        }
        Arrays.sort(arr,(a,b) -> a[1]-b[1]);
        System.out.print(arr[0][0]+" ");
        int last_finish_time = arr[0][1] ;
        for(int i=0;i<n;i++){
            int s = arr[i][0];
            int f = arr[i][1];
            if(s>=last_finish_time){
                System.out.print(s+" ");
                last_finish_time = f; 
                 }
        }

    }
}
