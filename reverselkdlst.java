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
	public static void main(String[] args){
		Node head=new Node(1);
		Node h1=new Node(2);
		Node h2=new Node(3);
		head.next=h1;
		h1.next=h2;
		Node re=reverserecur(head);
		while(re.next!=null){
        System.out.println(re.val);
		re=re.next;
	    }
		System.out.println(re.val);
// 		Node r=reverseitr(head);
// 		System.out.println(r.val);
	}
	
}