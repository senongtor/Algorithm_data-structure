public class bucketfinddup{
	public static int find(int[] arr){
		for(int i=0;i<arr.length;i++){
			
		   if(arr[i]-1>0){
			if(arr[arr[i]-1]>0){
				arr[arr[i]-1]=arr[arr[i]-1]*(-1);
			}
			else{
				return arr[i];
			}
		   }
		}
		return -1;
	}
		
	public static void main(String[] args){
		int[] arr=new int[]{2,1,2,4,3};	
	    System.out.println(find(arr));
	}
}