import java.util.*;
import java.util.BitSet; 
public class twosum{

	public static List<List<Integer>> twopointer(int[] arr, int t){
		List<List<Integer>> re=new LinkedList<List<Integer>>();
		        Arrays.sort(arr);
		        int start=0;
		        int end=arr.length-1;
				
				while(start<end){
					if(arr[start]+arr[end]==t){
						List<Integer> tmp=new LinkedList<Integer>();
						tmp.add(arr[start]);
						tmp.add(arr[end]);
						re.add(tmp);
						start++;
						end--;
						while(start < end && arr[start] == arr[start - 1]){
							start++;
						}
						while(start < end && arr[end] == arr[end + 1]){
							end--;
						}
					}
					else if(arr[start]+arr[end]<t){
						start++;
					}
					else{
						end--;
					}
				}
				return re;
	}
	public static List<Integer> twooccur(int[] arr){
		List<Integer> re=new LinkedList<Integer>();
		for(int i=0;i<arr.length;i++){
			if(arr[Math.abs(arr[i]-1)]<0){
				re.add(i);
			}
			else{
				arr[arr[i] - 1] *= -1;
			}
		}
		return re;
	}
	public static void main(String[] args){
		int[] arr=new int[]{1,1,2,2,3,4,4,4};
		System.out.println(twooccur(arr));
		BitSet bits1 = new BitSet(100000); 
		for(int i=0;i<20;i++){
			bits1.set(i);
		}
		System.out.println(bits1);
	}
}