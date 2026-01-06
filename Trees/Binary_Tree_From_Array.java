package Trees;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}
public class Binary_Tree_From_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root = buildTree(arr, 0);
        printInOrder(root);
        sc.close();
    }
    static TreeNode buildTree(int[] arr, int index) {
      if(arr.length == 0 || index >= arr.length) {
          return null;
      }
        TreeNode root = new TreeNode(arr[index]);
        TreeNode[] node = new TreeNode[arr.length];
        node[index] = root;
        for(int i = 0 ;i<arr.length;i++){
            node[i] = new TreeNode(arr[i]);
        }
        for(int i = 0 ;i<arr.length;i++){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < arr.length){
                node[i].left = node[left];
            }
            if(right < arr.length){
                node[i].right = node[right];
            }
        }
        return node[0];
}
static void printInOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
}
}
