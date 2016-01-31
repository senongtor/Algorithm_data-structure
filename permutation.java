import java.util.*;

public class permutation{
public static List<List<Integer>> permutenaive(int[] nums){
	List<List<Integer>> result=new ArrayList<List<Integer>>();
	
	if(nums==null || nums.length==0){
		return result;
	}
	
	List<Integer> list=new ArrayList<Integer>();
	helper(nums, list, result);
	
	return result;
}

public static void helper(int[] nums, List<Integer> list, List<List<Integer>> result){
	if(nums.length==list.size()){
		result.add(new ArrayList<Integer>(list)); 
		return;
		
	}
	
	for(int i=0;i<nums.length;i++){
		if(list.contains(nums[i])){
			continue;
		}
		
		list.add(nums[i]);
		helper(nums, list, result);
		list.remove(list.size()-1);
		
	}
}

public void helperunique(int[] nums, List<Integer> curr, List<List<Integer>> re, boolean[] visited){
        if(curr.size()==nums.length){
         re.add(new LinkedList<Integer>(curr));
         return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            curr.add(nums[i]);
            visited[i]=true;
            helper(nums,curr,re, visited);
            visited[i]=false;
            curr.remove(curr.size()-1);
            
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(nums==null||nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited=new boolean[nums.length];
        List<Integer> curr=new LinkedList<Integer>();
        helper(nums,curr,result, visited);
       
        return result;
    }

public static void main(String[] args){
	int[] nums=new int[]{1,1,2};
	for (int i=0;i<6;i++){
	System.out.println(permutenaive(nums).get(i));
}
}

}