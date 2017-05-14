class SegmentTreeNode {
    int start;
    int end;
    int sum;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}
public class SegmentTreeQuery {

    SegmentTreeNode root;
    
    public SegmentTreeNode buildTree(int[] nums,int start,int end){
        if(start==end){
            return new SegmentTreeNode(start,end,nums[start]);
        }
        int mid=(start+end)/2;
        SegmentTreeNode left = buildTree(nums,start, mid);
        SegmentTreeNode right = buildTree(nums,mid + 1, end);
        SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum + right.sum);
        root.left=left;
        root.right=right;
        return root;
    }

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        this.root=buildTree(nums,0,nums.length-1);
    }

    public int sumRange(int i, int j) {
        return recur(this.root,i,j);
    }

    public int recur(SegmentTreeNode root,int i,int j){
        int mid=(root.start+root.end)/2;
        if(i<=root.start && j>=root.end){
            return root.sum;
        }else if(j<=mid){
            return recur(root.left,i,j);
        }else if(i>mid){
            return recur(root.right,i,j);
        }else if(i <= mid && j > mid){
            return recur(root.left,i,mid)+recur(root.right,mid+1,j);
        }
        return 0;
    }
}
