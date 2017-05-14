import java.util.*;
class Node{
  char val;
  Node left;
  Node right;
  public Node(){}
  public Node(char val){
    this.val=val;
  }
  // public String toString(){
  //   return String.format("%c",this.val);
  // }
}
public class TernaryExpressionBinaryTree{
  /**
  a?b?c:d:e
      a
    b   e
  c  d
  */
  public static Node buildTree(String s){
    Stack<Node> stack=new Stack<Node>();
    Node root=new Node(s.charAt(0));
    stack.push(root);
    for(int i=1;i<s.length()-1;i+=2){
      Node curr=new Node(s.charAt(i+1));
      if(s.charAt(i)=='?'){
        stack.peek().left=curr;
      }else if(s.charAt(i)==':'){
        stack.poll();
        while(!stack.isEmpty() && stack.peek().right!=null){
          stack.poll();
        }
        stack.peek().right=curr;
      }
      stack.push(curr);
    }
    return root;
  }
  public static Node recur(char[] chars,int l,int r){
    if(l==r){
      return new Node(chars[l]);
    }
    if(l>r){
      return null;
    }
    int count=0;
    int i=l;
    for(;i<=r;i++){
      if(chars[i]=='?'){
        count++;
      }else if(chars[i]==':'){
        count--;
        if(count==0){
          break;
        }
      }
    }
    Node root=new Node(chars[l]);
    root.left=recur(chars,l+2,i-1);
    root.right=recur(chars,i+1,r);
    return root;
  }
  public static void main(String[] args){
    String s="a?b?c:d:e";
    Node n=recur(s.toCharArray(),0,s.length()-1);
    System.out.println(n.right.val);
  }
}
