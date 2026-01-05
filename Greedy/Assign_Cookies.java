import java.util.*;
public class Assign_Cookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] greed = new int[n];
        int[] size = new int[m];
        for (int i = 0; i < n; i++) {
            greed[i] = sc.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            size[i] = sc.nextInt();
        }
        int max_childeren = findmaxchildren(greed, size);
        System.out.println(max_childeren);
        sc.close();
    }
    static int findmaxchildren(int[] greed , int[] size){
        Arrays.sort(greed);
        Arrays.sort(size);
        int i =greed.length-1, j = size.length-1;
        int count = 0 ;
        while (i>=0&&j>=0) {
            if(size[j]>=greed[i]){
                count++;
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        return count ;
    }
}
