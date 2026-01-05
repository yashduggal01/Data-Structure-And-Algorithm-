import java.util.*;
class Maximum_Product_Subarray {
static int maxProduct(int[] arr) {
    int n = arr.length;
    int maxSoFar = arr[0];
    int minSoFar = arr[0];
    int result = arr[0];

    for (int i = 1; i < n; i++) {
        if (arr[i] < 0) {
            int temp = maxSoFar;
            maxSoFar = minSoFar;
            minSoFar = temp;
        }

        maxSoFar = Math.max(arr[i], maxSoFar * arr[i]);
        minSoFar = Math.min(arr[i], minSoFar * arr[i]);

        result = Math.max(result, maxSoFar);
    }
    return result;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(maxProduct(arr));
    sc.close();
}
}