import java.util.*;
class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(){}
  public TreeNode(int val){
    this.val=val;
  }
}
public class BoundaryOfBTree{
  static List<Integer> nodes = new ArrayList<>(1000);
  public static List<Integer> boundaryOfBinaryTree(TreeNode root) {

      if(root == null) return nodes;

      nodes.add(root.val);
      leftBoundary(root.left);
      leaves(root.left);
      leaves(root.right);
      System.out.println(nodes);
      rightBoundary(root.right);

      return nodes;
  }
  public static void leftBoundary(TreeNode root) {
      if(root == null || (root.left == null && root.right == null)) return;
      nodes.add(root.val);
      if(root.left == null) leftBoundary(root.right);
      else leftBoundary(root.left);
  }
  public static void rightBoundary(TreeNode root) {
      if(root == null || (root.right == null && root.left == null)) return;
      if(root.right == null)rightBoundary(root.left);
      else rightBoundary(root.right);
      nodes.add(root.val); // add after child visit(reverse)
  }
  public static void leaves(TreeNode root) {
      if(root == null) return;
      if(root.left == null && root.right == null) {
          nodes.add(root.val);
          return;
      }
      leaves(root.left);
      leaves(root.right);
  }
  public static void main(String[] args){
      TreeNode root=new TreeNode(1);
      TreeNode l=new TreeNode(2);
      TreeNode r=new TreeNode(3);
      root.left=l;
      root.right=r;
      TreeNode ll=new TreeNode(4);
      TreeNode lr=new TreeNode(5);
      l.left=ll;
      l.right=lr;
      TreeNode lrl=new TreeNode(7);
      TreeNode lrr=new TreeNode(8);
      lr.left=lrl;
      lr.right=lrr;
      TreeNode rl=new TreeNode(6);
      r.left=rl;
      TreeNode rll=new TreeNode(9);
      TreeNode rlr=new TreeNode(10);
      rl.left=rll;
      rl.right=rlr;
      // System.out.println(boundaryOfBinaryTree(root));
      char ch='a';
      System.out.println((char)(ch-32));
  }
//     _____1____
//    /          \
//   2            3
//  / \          /
// 4   5        6
//    / \      / \
//   7   8    9  10
}
