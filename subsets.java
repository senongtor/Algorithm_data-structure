//Build from the empty set, add element to the generated subsets and add them to the result list.
import java.util.*;
public class subsets{
  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        List<Integer> subset=new LinkedList<Integer>(); 
        result.add(subset);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int n=result.size();
            for(int j=0;j<n;j++){
                List<Integer> s=new ArrayList<Integer>(result.get(j));
                s.add(nums[i]);
                result.add(s);
            }
        }
   return result;
   }
}