import java.util.*;
public class wiggle{
    public static void wiggleSort(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1){
            return;
        }
        int len=nums.length;
        int[] re=new int[len];
        
        Arrays.sort(nums);
        int index=0;
        for(int i=0;i<len/2;i++){
            re[index]=nums[i];
            int shift=len-len/2;
            re[index+1]=nums[i+shift];
            index+=2;
        }
        if((nums.length&1)==1){
            re[nums.length-1]=nums[len/2];
        }
        System.arraycopy(re, 0, nums, 0, len);
    }
	public static void main(String[] args){
		int[] arr=new int[]{1, 3, 2, 2, 3, 1};
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}