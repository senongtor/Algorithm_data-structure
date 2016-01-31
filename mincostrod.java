import java.util.*;
public class mincostrod{
	public static int mincost(int[] arr){
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int a:arr){
			pq.add(a);
		}
		int min=0;
		int cost=0;
		while(!pq.isEmpty()){
			min=pq.poll();
			if(!pq.isEmpty()){
			min+=pq.poll();
	 	    }
			pq.add(min);
			cost+=min;
		}
		return cost;
	}
	public static void main(String[] args){
		int[] arr=new int[]{3,4,6};
		System.out.println(mincost(arr));
	}
}