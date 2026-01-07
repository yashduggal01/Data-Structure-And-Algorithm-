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
public class Print_the_cousins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        TreeNode root = buildTree(arr, 0);
        printCousins(root, target);
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
static void printCousins(TreeNode root, int target){
    if(root==null||root.val==target){
        System.out.print(-1);
        return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean found = false;
    while(!queue.isEmpty()&&!found){
        int levelSize = queue.size();
        List<Integer> cousins = new ArrayList<>();
        for(int i=0;i<levelSize;i++){
            TreeNode currentNode = queue.poll();
            if((currentNode.left!=null&&currentNode.left.val==target)||
               (currentNode.right!=null&&currentNode.right.val==target)){
                found = true;
            }else{
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                    cousins.add(currentNode.left.val);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                    cousins.add(currentNode.right.val);
                }
            }
        }
        if(found){
            if(cousins.isEmpty()){
                System.out.print(-1);
            }else{
                for(int val : cousins){
                    System.out.print(val + " ");
                }
            }
            return;
        }
    }
    System.out.print(-1);
}
}
