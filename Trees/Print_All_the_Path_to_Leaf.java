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
public class Print_All_the_Path_to_Leaf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root = buildTree(arr, 0);
        printAllPaths(root);

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

  static void printAllPaths(TreeNode root) {
    // Write your code here
      if(root==null){
        return ;
      }
      int[] count = new int[1];
      List<Integer> list = new ArrayList<>();

      solve(root,list,count);
      System.out.print(count[0]);
  }
static void solve(TreeNode root, List<Integer> list , int[] count){
     list.add(root.val);
    if(root.left==null&&root.right==null){
        for(int n : list) System.out.print(n+" ");
        System.out.println(list.size()-1);
        count[0]++;
    }
   
    if(root.left!=null){
        solve(root.left,list,count);
    }
    if(root.right!=null){
        solve(root.right,list,count);
    }
    list.remove(list.size()-1);
}
}