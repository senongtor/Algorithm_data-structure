import java.util.*;
class Node{
	char data;
	Node left;
	Node right;
	public Node(char dat){
		data=dat;
	}
	public Node(){}
	
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
		Node root = new Node(s.charAt(0));  
		    Node n = root;  
		    Stack<Node> stack =  new Stack<Node>();  
		    for (int i = 1; i < s.length(); i += 2) {  
		        if (s.charAt(i) == '?') {  
		            n.left = new Node (s.charAt(i + 1));  
		            stack.add(n);  
		            n = n.left;  
  
		        }  
		        else if (s.charAt(i) == ':') {  
		            n = stack.pop();  
		                        
		            n.right = new Node (s.charAt(i+1));  
		             
		            n = n.right;  
		        }  
		    }  
		    return root;  
    }
	public static void main(String[] args){
		String s="a?b?c:d:e";
		System.out.println(toString(convert(s)));
	}
}