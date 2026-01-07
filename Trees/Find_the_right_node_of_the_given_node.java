 package Trees;
import java.util.*;
public class Find_the_right_node_of_the_given_node {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        TreeNode root = buildTree(arr, 0);
        TreeNode result = findRightNode(root, target);
        if(result != null) {
            System.out.println("Right node of " + target + " is: " + result.val);
        } else {
            System.out.println("No right node found for " + target);
        }
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
static TreeNode findRightNode(TreeNode root, int target) {
    if(root == null) {
        return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
        int levelSize = queue.size();
        for(int i = 0; i < levelSize; i++) {
            TreeNode currentNode = queue.poll();
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    return null;
}
}
