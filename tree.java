import java.util.*;

class Node{
 int data;
 Node left;
 Node right;
 public Node(int val){
	 data=val;
 }
 public Node(){}
}

public class tree{
	private static List<Integer> result;
	
	public static void inordertraversal(Node root,List<Integer> l){
		if(root==null){
			return;
		}
		inordertraversal(root.left,l);
		l.add(root.data);
		inordertraversal(root.right,l);
	}
	public static List<Integer> iterative(Node root){
		Stack<Node> s=new Stack<Node>();
		List<Integer> l=new LinkedList<Integer>();
		Node p=root;
		
		while(p!=null||!s.isEmpty()){
			if(p!=null){
				s.push(p);
				p=p.left;
			}
			else{
				Node t=s.pop();
				l.add(t.data);
				p=t.right;
			}
		}
		
		return l;
	}
	public static int kthelt(Node root,int k){
		Stack<Node> s=new Stack<Node>();
		int l=0;
		Node p=root;
		int count=0;
		while(p!=null||!s.isEmpty()){
			if(p!=null){
				s.push(p);
				p=p.left;
			}
			else{
				Node t=s.pop();
				
				l=t.data;
				count++;
				if(count==k){
					return l;
				}
				p=t.right;
			}
		}
		return -1;
	}
	public static List<Integer> preorderTraversalit(Node root) {
	        List<Integer> l=new LinkedList<Integer>();
	        if(root==null){
	            return l;
	        }
	        Stack<Node> stack=new Stack<Node>();

	        Node curr=root;
	        while(curr!=null || !stack.isEmpty()){
	            if(curr!=null){
	                l.add(curr.data);
	                stack.push(curr);
	                curr=curr.left;
	            }
	            else{
	                Node tmp=stack.pop();
	                curr=tmp.right;
	            }
	        }
	        return l;
	    }
	public static int findclosest(Node root,int target){
		
		if(root.left==null&&root.right==null){
			return root.data;
		}
		int currbest=root.data;
		while(root!=null){
			if(root.data==target){
				currbest=root.data;
			}
			if(root.data>target){
				if(root.data-target<Math.abs(currbest-target)){
					currbest=root.data;
				}
				root=root.left;
			}
			if(root.data<target){
				if(target-root.data<Math.abs(currbest-target)){
					currbest=root.data;
				}
				root=root.right;
			}
		}
		return currbest;
	}
	
	public static int findclosestit(Node root,int target){
		
		if(root==null){
			return Integer.MAX_VALUE;
		}
		int left=findclosestit(root.left,target);
		int right=findclosestit(root.right,target);
		
		int result=0;
		if(Math.abs(root.data-target)<=Math.abs(left-target) && Math.abs(root.data-target)<=Math.abs(right-target)){
			result=root.data;
		}
		else if(Math.abs(left-target)<=Math.abs(root.data-target) && Math.abs(left-target)<=Math.abs(right-target)){
			result=left;
		}
		else if(Math.abs(right-target)<=Math.abs(root.data-target) && Math.abs(right-target)<=Math.abs(left-target)){
			result=right;
		}
		return result;
	}
	public List<Integer> postorderTraversal(Node root) {
	        List<Integer> l=new LinkedList<Integer>();
	        if(root==null){
	            return l;
	        }
	        Stack<Node> stack=new Stack<Node>();
	        Node curr=root;
	        while(curr!=null||!stack.isEmpty()){
	            if(curr!=null){
	                l.add(curr.data);
	                stack.push(curr);
	                curr=curr.right;
	            }
	            else{
	                Node tmp=stack.pop();
	                curr=tmp.left;
	            }
	        }
	        Collections.reverse(l);
	        return l;
	    }
		public int maxDepth(Node root){
		        if(root==null){
		            return 0;
		        }
		        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
		    }
		    public boolean isBalanced(Node root) {
		        if(root==null){
		            return true;
		        }
		        Node curr=root;
        
		            int diff=Math.abs(maxDepth(curr.left)-maxDepth(curr.right));
                
            
		            return diff<=1 && isBalanced(root.left) && isBalanced(root.right);
        
		    }
	public static void main(String[] args){
	
		Node root=new Node(8);
		Node l=new Node(4);
		root.left=l;
		Node r=new Node(13);
		root.right=r;
		Node ll=new Node(1);
		l.left=ll;
		Node lr=new Node(5);
		l.right=lr;
		Node rl=new Node(9);
		r.left=rl;
		Node rr=new Node(16);
		r.right=rr; 
		// result=iterative(root);
		// System.out.println(result.size());
		// Iterator<Integer> it=result.iterator();
		// while(it.hasNext()){
		// 	System.out.println(it.next());
		// }
		// List<Integer> list=new LinkedList<Integer>();
// 		list=preorderTraversalit(root);
		// System.out.println(list);
		// List<Integer> li=iterative(root);
// 		System.out.println(li);
System.out.println(kthelt(root, 4));
	}
	
	
	
}