class TreeNode{
  public int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(){}
  public TreeNode(int val){
    this.val=val;
  }
}

public class BinaryTreeLongestConsecutive{
  static int max = 0;
  public static int longestConsecutive(TreeNode root) {
    if (root == null) {
        return 0;
    }
    helper(root);
    return max;
  }
  private static int[] helper(TreeNode root) {
    if (root == null) {
        return null;
    }
    int[] curr = {1, 1, root.val};
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    if (left != null) {
        if (root.val == left[2] + 1) {
            curr[0] = Math.max(curr[0], left[0] + 1);
        } else if (root.val == left[2] - 1) {
            curr[1] = Math.max(curr[1], left[1] + 1);
        }
    }
    if (right != null) {
        if (root.val == right[2] + 1) {
            curr[0] = Math.max(curr[0], right[0] + 1);
        } else if (root.val == right[2] - 1) {
            curr[1] = Math.max(curr[1], right[1] + 1);
        }
    }
    System.out.printf("increasing: %d,decreasing: %d\n",curr[0],curr[1]);
    max = Math.max(max, curr[0] + curr[1] - 1);
    return curr;
  }
  public static void main(String[] args){
    TreeNode root=new TreeNode(2);
    TreeNode l=new TreeNode(1);
    TreeNode r=new TreeNode(3);
    root.left=l;
    root.right=r;
    System.out.println(longestConsecutive(root));
  }
}
