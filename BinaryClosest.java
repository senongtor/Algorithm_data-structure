import java.util.*;
import java.util.Stack;
class TreeNode{
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(){}
  public TreeNode(int val){
    this.val=val;
  }
}
class Node{
  int val;
  Node next;
  public Node(){}
  public Node(int val){
    this.val=val;
  }
}
public class BinaryClosest{
public static List<Integer> closestKValues(TreeNode root, double target, int k) {
  List<Integer> res = new ArrayList<>();

  Stack<Integer> s1 = new Stack<Integer>(); // predecessors
  Stack<Integer> s2 = new Stack<Integer>(); // successors

  inorder(root, target, false, s1);
  inorder(root, target, true, s2);

  System.out.println(s1);
  System.out.println(s2);

  while (k-- > 0) {
    if (s1.isEmpty())
      res.add(s2.pop());
    else if (s2.isEmpty())
      res.add(s1.pop());
    else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
      res.add(s1.pop());
    else
      res.add(s2.pop());
  }


  return res;
}

// inorder traversal
public static void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
  if (root == null) return;

  inorder(reverse ? root.right : root.left, target, reverse, stack);
  // early terminate, no need to traverse the whole tree
  if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
  // track the value of current node
  stack.push(root.val);
  inorder(reverse ? root.left : root.right, target, reverse, stack);
}

public static String print(TreeNode root){
  if(root==null){
    return "null";
  }

  String curr="(";
  curr+=String.valueOf(root.val);
  curr+=" ";
  curr+=print(root.left);
  curr+=" ";
  curr+=print(root.right);
  curr+=")";
  return curr;
}
// public static int countOccurence(int[] arr,int target){
//   int l=0;
//   int r=arr.length-1;
//   while(l<r){
//     int m=(l+r)/2;
//     if(arr[m]==target){
//
//     }
//   }
// }
private static TreeNode convert(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }

        Node slow=head;
        Node fast=head;
        Node prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=convert(head);
        root.right=convert(slow.next);
        return root;
    }
    public static TreeNode sortedListToBST(Node head) {
        if(head==null){
            return null;
        }

        return convert(head);

    }
    public static Node deleteDuplicates(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node fake=new Node(-1);
        Node fh=fake;
        int val=head.val;
        head=head.next;
        fake.next=new Node(head.val);
        fake=fake.next;
        System.out.println(fake.val);
        while(head!=null){
            if(head.val!=val){
                fake.next=new Node(head.val);
                fake=fake.next;
                val=head.val;
            }
            head=head.next;
        }
        return fh.next;
    }
    public static int removeDuplicates(int[] nums) {
       if(nums.length<=1){
           return nums.length;
       }
       int val=nums[0];
       int idx=1;
       for(int i=1;i<nums.length;i++){
           if(nums[i]!=val){
               val=nums[i];
               nums[idx++]=val;
           }
       }
       System.out.println(Arrays.toString(nums));
       return idx;
   }
public static void main(String[] args){
  TreeNode root=new TreeNode(8);
  TreeNode rl=new TreeNode(5);
  TreeNode rr=new TreeNode(11);
  TreeNode rll=new TreeNode(3);
  TreeNode rlr=new TreeNode(7);
  root.left=rl;
  root.right=rr;
  rl.left=rll;
  rl.right=rlr;
  // System.out.println(closestKValues(root, 4.3, 3));
  int[] arr=new int[]{1,2,3,4,4,4,4,5,7,7,7};
  System.out.println(removeDuplicates(arr));
  // System.out.println(countOccurence(arr,4));
  Node head=new Node(1);
  Node h1=new Node(3);
  Node h2=new Node(3);
  Node h3=new Node(4);
  Node h4=new Node(5);
  head.next=h1;
  h1.next=h2;
  h2.next=h3;
  h3.next=h4;
  // System.out.println(deleteDuplicates(head));
  // System.out.println(print(sortedListToBST(head)));

  }
}
