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
	public static void main(String[] args){
		Node head=new Node(1);
		Node h1=new Node(2);
		Node h2=new Node(3);
		Node h3=new Node(4);
		
		head.next=h1;
		h1.next=h2;
		h2.next=h3;
	
		// Node re=reverserecur(head);
// 		while(re.next!=null){
//         System.out.println(re.val);
// 		re=re.next;
// 	    }
// 		System.out.println(re.val);
System.out.println(middle(head));
// 		Node r=reverseitr(head);
// 		System.out.println(r.val);
	}
	
}