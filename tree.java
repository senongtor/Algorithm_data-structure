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
	public static Node inordersucrec(Node root, Node target){
	    if (root == null || p == null) {
	               return null;
	    }
		if(root!=null){
			if(root.data>target){
				return inordersucrec(root.left,target)==null?root:inordersucrec(root.left,target);
			}
			 return inordersucrec(root.right, target);
		}
	}
	public static Node inordersuc(Node root, Node target){
		if(root==null || target==null){
			return null;
		}
		Node re=new Node();
		while(root!=null){
			if(root.data>target){
				res=root
				root=root.left;
			}
			else{
				root=root.right;
			}
		}
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
	public static int getdist(Node root, Node a){
		if(root==null){
			return -1;
		}
		return disfromroot(root,a);
	}
	public static int disfromroot(Node root, Node a){
		
		if (root != null) {
					int x = 0;
					if ((root.data == a.data) || (x = disfromroot(root.left, a)) > 0
							|| (x = disfromroot(root.right, a)) > 0) {
						return x + 1;

					}
					return 0;
				}
				return 0;
	}
	public static Node LCA(Node root, Node p, Node q){
		if(root==null||p==null||q==null){
			return root;
		}
		Node l=LCA(root.left, p,q);
		Node r=LCA(root.right, p,q);
		if(l!=null && r!=null){
			return root;
		}
		if(l!=null){
			return l;
		}
		if(r!=null){
			return r;
		}
		return null;
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
			// public static int distance(Node root, Node a, Node b){
//
// 			}
public static int maxsum(Node root){
	    if(root.left==null&&root.right==null){
			return root.data;
		}
		if(root.left==null&&root.right!=null){
			return Math.max(sum(root),sum(root.right));
		}
		if(root.right==null&&root.left!=null){
			return Math.max(sum(root), sum(root.left));
		}
	return Math.max(Math.max(sum(root),sum(root.left)),sum(root.right));
}
public static int sum(Node root){
	if(root==null){
		return 0;
	}
	int l=sum(root.left);
	int r=sum(root.right);
	return l+r+root.data;
}
	public static void main(String[] args){
	
		Node root=new Node(-100);
		Node l=new Node(-10);
		root.left=l;
		
		root.right=null;
		
		// Node lr=new Node(105);
// 		l.right=lr;
// 		Node rl=new Node(-9);
// 		r.left=rl;
// 		Node rr=new Node(-16);
// 		r.right=rr;
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
// System.out.println(kthelt(root, 4));
System.out.println(maxsum(root));
	}
	
	
	
}