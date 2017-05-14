import java.util.*;
class Node{
	char data;
	Node left;
	Node right;
	public Node(char dat){
		data=dat;
	}
	public Node(){}
	public String toString(){
		return String.format("%c",this.data);
	}
}
public class ternerytotree{
	private static String toString(Node root)
	{
	    String result = "";
	    if (root == null)
	        return "";
	    result += toString(root.left);
			result += ",";
			result += Character.toString(root.data);
			result += ",";
	    result += toString(root.right);
	    result += ",";
	    return result;
	}
    public static Node convert(String s){
				if(s.length()==0){
					return null;
				}
				Stack<Node> stack=new Stack<Node>();
				Node root=new Node(s.charAt(0));
				stack.push(root);
				for(int i=1;i<s.length()-1;i+=2){
					Node n=new Node(s.charAt(i+1));
					if(s.charAt(i)=='?'){
						stack.peek().left=n;
					}
					if(s.charAt(i)==':'){
						stack.pop();
						while(stack.peek().right!=null){
							stack.pop();
						}
						stack.peek().right=n;
					}
					stack.push(n);
				}
		    return root;
    }
	public static void main(String[] args){
		String s="a?b?c:d:e";
		System.out.println(convert(s));
	}
}
