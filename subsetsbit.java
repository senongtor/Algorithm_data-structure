import java.util.*;
public class subsetsbit{
	public static List<List<Integer>> bit(int[] arr){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> sub=new ArrayList<Integer>();
		result.add(sub);
		int range=1<<arr.length;
		for(int i=1;i<range;i++){
			int count=0;
			List<Integer> tmp=new ArrayList<Integer>();
			for(int j=0;j<arr.length;j++){
				int num=1<<j;
				if((i&num)==num){
					tmp.add(arr[j]);
				}
			}
        // while(i>0){
// 			if((i&1)==1){
// 				tmp.add(arr[count]);
// 				count++;
// 			}
//         	i>>=1;
//         }


			result.add(tmp);
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] arr=new int[]{1,2,3,4};
		List<List<Integer>> result=bit(arr);
		System.out.println(result);
	}
}