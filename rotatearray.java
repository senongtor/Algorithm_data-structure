import java.util.*;
public class rotatearray{
	public void reverse(int[] nums,int i,int j){
	        int temp=0;
	        while(i<j){
	            temp=nums[i];
	            nums[i]=nums[j];
	            nums[j]=temp;
	            i++;
	            j--;
	        }
	    }
	    public void rotate(int[] nums, int k) {
	        k=k%nums.length;
	        reverse(nums,0,nums.length-k-1);
	        reverse(nums,nums.length-k,nums.length-1);
	        reverse(nums,0,nums.length-1);
	    }
		
		public static void rotate2(int[] nums, int k) {
		        k=k%nums.length;
		        int[] temp = new int[k];
		        for(int i=nums.length-k;i<nums.length;i++){
		            temp[i-nums.length+k]=nums[i];
		        }
		        for(int i=nums.length-k-1;i>=0;i--){
		            nums[i+k]=nums[i];
		        }
		        for(int i=0;i<k;i++){
		            nums[i]=temp[i];
		        }
		    }
			public static void main(String[] args){
				int[] nums=new int[]{1,2,3,4,5,6,7};
				rotate2(nums,3);
				System.out.println(Arrays.toString(nums));
			}
}