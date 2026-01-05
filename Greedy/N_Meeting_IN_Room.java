import java.util.*;
public class N_Meeting_IN_Room {
    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] start = new int[n];
    int[] end = new int[n];
    for(int i=0;i<n;i++){
        start[i] = sc.nextInt();
        end[i] = sc.nextInt();
    }
    int max_meetings = nMeetingInRoom(start, end, n);
    System.out.println(max_meetings);
    sc.close();
    }
static int nMeetingInRoom(int[] start , int[] end , int n){
    int[][] arr = new int[n][2];
    for(int i = 0 ; i<n;i++){
        arr[i][0]=start[i];
        arr[i][1]=end[i];
    }
    Arrays.sort(arr,(a,b) -> a[1]-b[1]);
    int count = 1 ;
    int last_end_time = arr[0][1] ;
    for(int i=1;i<n;i++){
        int s = arr[i][0];
        int e = arr[i][1];
        if(s>=last_end_time){
            count++;
            last_end_time = e; 
             }
    }
    return count ;
} 
}
