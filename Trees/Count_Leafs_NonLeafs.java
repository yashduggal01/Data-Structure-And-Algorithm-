package Trees;
import java.util.*;
    class TreeNode {
        int data;
        TreeNode left; 
        TreeNode right;
        public TreeNode() {
        data = 0;
        }
        public TreeNode(int d)  {
        data = d;
        }
    }
public class Count_Leafs_NonLeafs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            arr[i]=sc.nextInt();
        }
            TreeNode root = buildTree(arr, 0); // Using shared TreeNode class
    int leafs = countleaf(root);
    int nonLeafs = countnonleaf(root);
    int[] counts = {leafs, nonLeafs};
        System.out.println("Leaf Nodes: " + counts[0]);
        System.out.println("Non-Leaf Nodes: " + counts[1]);
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
static int countleaf(TreeNode root){
    if(root==null){
        return 0;
    }
    if(root.left==null && root.right==null){
        return 1;
    }
    return countleaf(root.left) + countleaf(root.right);
}
static int countnonleaf(TreeNode root){
    if(root==null || (root.left==null && root.right==null)){
        return 0;
    }
    return 1 + countnonleaf(root.left) + countnonleaf(root.right);
} 
}
