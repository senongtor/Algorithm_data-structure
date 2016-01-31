//add two numbers represented as two linkedlists. PRACTICE.
class ListNode{
	int data;
	ListNode next;
	public ListNode(){};
	public ListNode(int val){
		data=val;
	}
}


public class add2number{
	
	public static ListNode addtwo(ListNode l1,ListNode l2){
		int carry=0;
		ListNode newh=new ListNode(0);
		ListNode p1=l1;
		ListNode p2=l2;
		ListNode p3=newh;
		while(p1!=null || p2!=null){
			if(p1!=null){
				carry+=p1.data;
				p1=p1.next;
			}
			if(p2!=null){
				carry+=p2.data;
				p2=p2.next;
			}
			p3.next=new ListNode(carry%10);
			p3=p3.next;
			carry=carry/10;
		}
		if(carry==1){
			p3.next=new ListNode(1);
		}
		return newh.next;
	}
	
	public static void main(String[] args){
		ListNode head1=new ListNode(2);
		ListNode h2=new ListNode(4);
		head1.next=h2;
		ListNode h3=new ListNode(3);
		h2.next=h3;
		
		ListNode head2=new ListNode(5);
		ListNode g2=new ListNode(6);
		head2.next=g2;
		ListNode g3=new ListNode(4);
		g2.next=g3;
		ListNode result=addtwo(head1,head2);
		ListNode resulthead=result;
		StringBuilder str = new StringBuilder("");
		while(resulthead!=null){
		str.append(resulthead.data);
		resulthead=resulthead.next;
	}
	System.out.println(str.reverse());
	}  
  

}