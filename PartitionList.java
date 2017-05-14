import java.util.*;
class ListNode{
  int val;
  ListNode next;
  public ListNode(){}
  public ListNode(int val){
    this.val=val;
  }
  public String toString(){
    ListNode n=this;
    StringBuilder sb=new StringBuilder();
    while(n!=null){
      sb.append(n.val).append("->");
      n=n.next;
    }
    return sb.toString().substring(0,sb.length()-2);
  }
}
public class PartitionList{
    public static ListNode partition(ListNode head, int x) {
        ListNode fake=new ListNode(-1);
        ListNode beforetail=fake;
        ListNode prev=fake;
        ListNode curr=head;
        fake.next=curr;
        while(curr!=null){
            if(curr.val<x){
                ListNode next=curr.next;
                prev.next=curr.next;
                curr.next=beforetail.next;
                beforetail.next=curr;
                beforetail=beforetail.next;
                curr=next;
                if(prev==null){
                  prev=prev.next;
                }
            }else{
                prev=prev.next;
                curr=curr.next;
            }
        }
        return fake.next;
    }
    private static ListNode getKthFromBack(ListNode head,int k){
        if(head==null){
          return null;
        }
        ListNode f=head;
        ListNode s=head;
        int i=0;
        while(f!=null && f.next!=null){
          f=f.next;
          i++;
          if(i==k-1){
            break;
          }
        }
        while(f!=null && f.next!=null){
          f=f.next;
          s=s.next;
        }
        return s;
    }
    private static ListNode reverse(ListNode head,int m,int n){
      ListNode fake=new ListNode(-1);
        fake.next=head;
        ListNode prev=fake;
        for(int i=0;i<m-1;i++){
            prev=prev.next;
        }
        ListNode curr=prev.next;
        for(int i=0;i<n-m;i++){
            ListNode next=curr.next;
            curr.next=next.next;
            next.next=prev.next;
            prev.next=next;
        }
        return fake.next;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        ListNode h1=new ListNode(4);
        ListNode h2=new ListNode(3);
        ListNode h3=new ListNode(2);
        ListNode h4=new ListNode(5);
        ListNode h5=new ListNode(2);
        head.next=h1;
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        // System.out.println(partition(head,2));
        System.out.println(getKthFromBack(head,2).val);
    }
}
