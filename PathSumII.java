public class PathSumII{
	public void add(TreeNode root, List<List<Integer>> result, List<Integer> curr, int sum){
	        if(root==null){
	            return;
	        }
	        curr.add(root.val);
	        if(root.left==null&&root.right==null&&root.val==sum){
	            result.add(curr);
	        }
	        add(root.left,result,new ArrayList<Integer>(curr),sum-root.val);
	        add(root.right,result,new ArrayList<Integer>(curr),sum-root.val);
	    }
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> result=new ArrayList<List<Integer>>();
	        if(root==null){
	            return result;
	        }
	        add(root,result,new ArrayList<Integer>(), sum);
	        return result;
	    }
}