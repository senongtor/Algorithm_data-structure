//output the numbers in an array with odd number of frequecny(from Amazon intern interview)
import java.util.*;
public class oddfreq{
	public static List<Integer> find(int[] arr){
		List<Integer> result=new ArrayList<Integer>(); 
		if(arr==null || arr.length==0){
			return result;
		}
		int count=1;
		int number=arr[0];
		for(int i=1;i<arr.length;i++){
			if(number==arr[i]){
				count++;
			}
			else{
				if(count%2==1){
					result.add(number);
				}
				number=arr[i];
				count=1;
			}
		} 
		if(count%2==1){
			result.add(number);
		}
		return result;  
	}	
	
	public static List<Integer> mapfind(int[] arr){
		List<Integer> result=new ArrayList<Integer>();
		if(arr==null||arr.length==0){
			return result;
		}
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i],1);
			}
			else{
				int freq=map.get(arr[i]);
				map.put(arr[i],freq+1);
			}
		}
		for(Integer s:map.keySet()){
			if((map.get(s)&1)==1){
				result.add(s);
			}
		}
		return result;
	}
	public static void main(String[] args){
		int[] arr=new int[]{1,3,3,3,5,6,6,9,9,11};
		List<Integer> result=new ArrayList<Integer>(mapfind(arr));
		System.out.println(result);
	}
}