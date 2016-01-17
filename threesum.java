import java.util.*;
public class threesum{
	public static List<List<Integer>> generate(int[] arr){
		Arrays.sort(arr);
		List<List<Integer>> l=new LinkedList<List<Integer>>();
		for(int i=0;i<arr.length-2;i++){
			if(i==0||arr[i]>arr[i-1]){
				int negate=-arr[i];
				int start=i+1;
				int end=arr.length-1;
				while(start<end){
					if(arr[start]+arr[end]==negate){
						List<Integer> tmp=new LinkedList<Integer>();
						tmp.add(arr[i]);
						tmp.add(arr[start]);
						tmp.add(arr[end]);
						l.add(tmp);
						start++;
						end--;
						while(start<end && arr[start]==arr[start-1]){
							start++;
						}
						while(start<end && arr[end]==arr[end+1]){
							end--;
						}
					}
					else if(arr[start]+arr[end]<negate){
						start++;
					}
					else{
						end--;
					}
				}
			}
		}
		return l;
	}
	public static void main(String[] args){
		int[] arr= new int[]{-1,0,1,2,-1,-4};
		List<List<Integer>> l=new LinkedList<List<Integer>>();
		l=generate(arr);
		System.out.println(l);
	}

}