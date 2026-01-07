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
public class Is_Identical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i =0 ;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i =0 ;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        TreeNode root1 = buildTree(arr1, 0);
        TreeNode root2 = buildTree(arr2, 0);
        System.out.print(isIdentical(root1,root2));
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
static boolean isIdentical(TreeNode root1, TreeNode root2){
    if(root1==null&&root2==null){
        return true;
    }
    if(root1==null||root2==null){
        return false;
    }
    return (root1.val==root2.val)&&isIdentical(root1.left,root2.left)&&isIdentical(root1.right,root2.right);
} 
}