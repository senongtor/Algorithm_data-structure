class Node{
	int val;
	Node next;
	public Node(int data){
		val=data;
	}
	public Node(){}
	public String toString(){
		return "VAL:"+Integer.toString(val);
	}	
}

public class reverselkdlst{
	public static Node reverserecur(Node head){
		if(head==null||head.next==null) return head;
		Node t=reverserecur(head.next);		
		head.next.next=head;
		head.next=null;
		return t;
	}

	public static Node reverseitr(Node head){
		if(head==null||head.next==null){
			return head; 
	    }
		Node temp=head;
		Node curr=head;
		Node fake=new Node(-1);
		while(curr!=null){
			temp=curr.next;
			curr.next=fake.next;
			fake.next=curr;
			curr=temp;
		}
		return fake.next;
	}
	public static int backwards(Node head, int k){
		if(head==null){
			return head.val;
		}
		int count=0;
		Node fast=head;
		while(fast!=null){
			fast=fast.next;
			count++;
			if(count==k){
				break;
			}
		}
		if(count<k){
			return Integer.MIN_VALUE;
		}
		Node curr=head;
		while(fast.next!=null){
			fast=fast.next;
			curr=curr.next;
		}
		return curr.val;
	}
	public static int middle(Node head){
		Node fast=head;
		Node slow=head;
		while(fast.next != null){
		          slow = slow.next;
		          fast = fast.next;
		          if(fast.next != null){
		              fast = fast.next;
		          }
		      }
		
		return slow.val;
	}
	public static boolean isPalindromerev(Node head){
	    if(head==null){
	               return true;
	           }
	           Node fast=head;
	           Node slow=head;
	           Node fakehead=new Node(-1);
	           fakehead.next=head;
	           int count=0;
	           while(fast.next!=null){
	               fast=fast.next;
	               slow=slow.next;
	               fakehead=fakehead.next;
	               count++;
	               if(fast.next!=null){
	                   fast=fast.next;
	                   count++;
	               }
	           }
	           if(count%2==0){
	               fakehead.next=null;
	           }
	           else{
	               slow=slow.next;
	               fakehead.next=null;
	           }
			   Node newh=reverserecur(slow);
			   Node traverse=newh;
	           Node h=head;
	           while(traverse!=null){
	               if(traverse.val!=h.val) return false;
	               slow = traverse.next;
	               h = h.next;
	           }
	           return true;
		// Node record=head;
// 		Node tra=head;
// 		Node trar=record;
// 		while(tra!=null){
// 			trar.next=tra.next;
// 		}
// 		Node rev=reverserecur(head);
// 		Node a=record;
// 		Node b=rev;
// 		while(a!=null||b!=null){
// 			if(a==null||b==null){
// 				return false;
// 			}
// 			if(a.val!=b.val){
// 				return false;
// 			}
// 			a=a.next;
// 			b=b.next;
// 		}
// 		return true;
	}
	    public static boolean isPalindromestr(Node head) {
	        if(head==null){
	            return false;
	        }
	        String s="";
	        String rever="";
	        while(head!=null){
	            s=s+Integer.toString(head.val);
	            rever=Integer.toString(head.val)+rever;
	            head=head.next;
	        }
	        return s.equals(rever)? true:false;
	    }
	public static void main(String[] args){
		Node head=new Node(1);
		Node h1=new Node(2);
		
		Node h2=new Node(2);
		Node h3=new Node(1);
		
		head.next=h1;
		h1.next=h2;
		h2.next=h3;
	
		System.out.println(isPalindromerev(head));
		// Node re=reverserecur(head);
// 		while(re.next!=null){
//         System.out.println(re.val);
// 		re=re.next;
// 	    }
// 		System.out.println(re.val);
// System.out.println(middle(head));
// 		Node r=reverseitr(head);
// 		System.out.println(r.val);
	}
	
}