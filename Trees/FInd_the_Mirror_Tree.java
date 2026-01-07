package Trees;
import java.util.*;
 class Node {
    int data;
     Node left; 
     Node right;
     public Node() {
       data = 0;
     }
     public Node(int d)  {
       data = d;
     }
   }
public class FInd_the_Mirror_Tree {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();   
    int[] arr = new int[n];
    for(int i =0 ;i<n;i++){
        arr[i]=sc.nextInt();
    }
    Node root = buildTree(arr, 0);
    Node mirrorRoot = findMirror(root);
    printInOrder(mirrorRoot);
    sc.close(); 
   }
static Node buildTree(int[] arr, int index) {
  if(arr.length == 0 || index >= arr.length) {
      return null;
  }
    Node root = new Node(arr[index]);
    Node[] node = new Node[arr.length];
    node[index] = root;
    for(int i = 0 ;i<arr.length;i++){
        node[i] = new Node(arr[i]);
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
static void printInOrder(Node root) {
    if (root == null) {
        return;
    }
    printInOrder(root.left);
    System.out.print(root.data + " ");
    printInOrder(root.right);
}
static Node findMirror(Node root) {
  // Write your code here
    if(root==null) return null;
    findMirror(root.left);
    findMirror(root.right);
    Node temp = root.left;
    root.left=root.right;
    root.right=temp;
    return root;
}
}
