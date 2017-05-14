class Node{
  int val;
  Node left;
  Node right;
  public Node(){}
  public Node(int val){this.val=val;}
  public String toString(){
    return String.format("%d",val);
  }
}
public class BinaryTreeMaxPathSum{
  private List<Node>
  public static int maxx(Node root){
    if(root==null){
      return 0;
    }
    int left=maxx(root.left);
    int right=maxx(root.right);
    return Math.max(left,right)+root.val;
  }
  public static int maxsum(Node root){
    if(root==null){
      return 0;
    }
    return maxx(root);
  }
  public static void main(String[] args){
    Node root=new Node(10);
    Node l=new Node(-2);
    Node r=new Node(7);
    Node ll=new Node(8);
    Node lr=new Node(-4);
    root.left=l;
    root.right=r;
    l.left=ll;
    l.right=lr;

    System.out.println(maxsum(root));
  }
}
