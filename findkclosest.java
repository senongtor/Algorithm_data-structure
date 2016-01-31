import java.util.*;
public class findkclosest{
	public static int[] find(int[] arr,int k){
		int[] result=new int[k];
		final int t=k;
		Comparator<Integer> pc=new Comparator<Integer>(){
				    public int compare(Integer a,Integer b){
				    	return Math.abs(a-t)-Math.abs(b-t);
				    }	
				};
		PriorityQueue<Integer> pq=new PriorityQueue<>(k,pc);
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
		}
		for(int j=0;j<k;j++){
			result[j]=pq.poll();
		}
		return result;
	} 
	
	public static void main(String[] args){
		int[] arr=new int[]{2,1,4,2,6,12,3,8};
		int k=5;
		System.out.println(Arrays.toString(find(arr,k)));
	}
}