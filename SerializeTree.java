import java.util.*;
class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(){}
  public TreeNode(int val){
    this.val=val;
  }
  public String toString(){
    return String.format("%d",this.val);
  }
}
public class SerializeTree{
    // public static String serialize(TreeNode root) {
    //     StringBuilder sb = new StringBuilder();
    //     if (root == null) return sb.toString();
    //     preorder(root, sb);
    //     return sb.substring(0, sb.length() - 1);
    // }
    // private static void preorder(TreeNode root, StringBuilder sb) {
    //     if (root == null) return;
    //     sb.append(root.val).append("#");
    //     preorder(root.left, sb);
    //     preorder(root.right, sb);
    // }
    public static String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val));
        sb.append("#");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
       if(data.length()==0){
         return null;
       }
       String[] nodes=data.split("#");
       return buildTree(nodes,0,nodes.length-1);
    }
    private static TreeNode buildTree(String[] nodes, int l, int r) {
        if(l>r){
          return null;
        }
        int rootVal=Integer.parseInt(nodes[l]);
        TreeNode root=new TreeNode(rootVal);
        int i=l;
        for(;i<=r;i++){
          if(rootVal<Integer.parseInt(nodes[i])){
              break;
          }
        }
        root.left=buildTree(nodes,l+1,i-1);
        root.right=buildTree(nodes,i,r);
        return root;
    }

    public static void main(String[] args){
      /**
           9
        4    13
      2   7
      */
        TreeNode root=new TreeNode(9);
        TreeNode rl=new TreeNode(4);
        TreeNode rr=new TreeNode(13);
        root.left=rl;
        root.right=rr;
        TreeNode rll=new TreeNode(2);
        TreeNode rlr=new TreeNode(7);
        rl.left=rll;
        rl.right=rlr;
        String serial=serialize(root);
        serial=serial.substring(0,serial.length()-1);
        System.out.println(serial);
        //9#4#2#7#13
        System.out.println(deserialize(serial).left.right);
    }
}
