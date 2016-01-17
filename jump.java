public class jump{
	public static boolean canjump(int[] a){
		boolean[] can=new boolean[a.length];
		can[0]=true;
		for (int i=1; i<a.length;i++){
			for (int j=0;j<i;j++){
				if (can[j] && j+a[j]>=i){
					can[i]=true;
				break;
			}
			}
		}
		return can[a.length-1];
	}
	public static boolean canJump(int[] nums) {
	        boolean[] checker=new boolean[nums.length];
	        checker[0]=true;
	        for(int i=0;i<nums.length;i++){
	            if(checker[i]==true){
	                if(nums[i]+i>nums.length-1){
	                    checker[nums.length-1]=true;
	                    break;
	                }
	                else{
	                for(int j=i;j<=nums[i]+i;j++)
	                checker[j]=true;
	                }
	            }
	        }
	        return checker[nums.length-1];
	    }
	public static boolean can(int[] nums){
		int max=0;
		for(int i=0;i<nums.length;i++){
			while(nums[i]+i>max){
				max=nums[i]+i;
			}
			if(max<i) return false;
		}
		return true;
	}	
	public static void main(String[] args){
		int[] test=new int[]{2,3,1,1,4};
		System.out.println("It is "+can(test));
	}
}