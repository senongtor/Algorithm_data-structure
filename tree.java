import java.util.*;

class Node{
 int data;
 Node left;
 Node right;
 public Node(int val){
	 data=val;
 }
 public Node(){}
	 // public String toString(){
 // 	 return "<" +tostring(this) + ">";
 // 	 }
 // 	public String tostring(Node r){
 // 		if(r==null){
 // 			return "";
 // 		}
 // 		return tostring(left)+Integer.toString(data)+tostring(right);
 // 	}
}

public class tree{
	private static List<Integer> result;
	private static String toString(Node root)
	{
	    String result = "";
	    if (root == null)
	        return "";
		result += "[";
	    result += toString(root.left);
		result += ",";
		result += Integer.toString(root.data);
		result += ",";
	    result += toString(root.right);
	    result += "]";
	    return result;
	}

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
// public static Node inordersucrec(Node root, Node target){
// 	    if (root == null || target == null) {
// 	               return null;
// 	    }
// 		if(root!=null){
// 			if(root.data>target.data){
// 				return inordersucrec(root.left,target)==null?root:inordersucrec(root.left,target);
// 			}
// 			 return inordersucrec(root.right, target);
// 		}
// 	}

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
		System.out.format("%d.1\n",root.data);
		while(root!=null){
			System.out.format("%d.2\n",root.data);
			if(root.data>target){
				if(root.data-target<Math.abs(currbest-target)){
					currbest=root.data;
				}
				root=root.left;
			}
			else if(root.data<target){
				System.out.format("%d.3\n",root.data);
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
	public static int getmin(Node root){
		if(root.left==null){
			return root.data;
		}
		while(root.left!=null){
			root=root.left;
		}
		return root.data;
	}
  public static boolean path(Node root, int sum){
    System.out.println(sum);
        if(root==null && sum==0){
            return true;
        }
        if(root==null && sum!=0){
            return false;
        }
        return path(root.left,sum-root.data)||path(root.right,sum-root.data);
    }
    public static boolean hasPathSum(Node root, int sum) {
        if(root==null){
            return false;
        }
        return path(root,sum);
    }
  // public static Node inordersuccessorParen(Node target){
  //   if(target==null){
  //     return null;
  //   }
  //   if(target.right!=null){
  //     return getmin(target.right);
  //   }
  //   Node paren=target.parent;
  //   while(paren!=null && paren.right==target){
  //     target=paren;
  //     paren=paren.parent;
  //   }
  //   return paren;
  // }
	public static int inordersuccessor(Node target, Node root){
		if(target.right!=null){
			return getmin(target.right);
		}
		Node succ=new Node();
		while(root!=null){
			if(root.data>target.data){
				succ=root;
				root=root.left;
			}
			else if(root.data<target.data){
				root=root.right;
			}
			else{
				break;
			}
		}
		return succ.data;
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
		Node root=new Node(1);
    Node r=new Node(2);
    root.left=r;
		// Node right=new Node(8);
		// root.right=right;
		// System.out.println(findclosest(root,3));
    System.out.println(hasPathSum(root,1));
		// Node root=new Node(8);
// 		Node l=new Node(5);
// 		root.left=l;
//
// 		Node r=new Node(12);
// 		root.right=r;
// 		Node ll=new Node(3);
// 		Node lr=new Node(7);
// 		l.left=ll;
// 		l.right=lr;
// 		Node rl=new Node(9);
// 		r.left=rl;
//
// 		System.out.println(inordersuccessor(rl,root));

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
// System.out.println(toString(root));
	}



}
