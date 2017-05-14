//import java.util.AbstractMap.SimpleEntry;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.Iterator;
import java.util.Map.Entry;
// import java.util.PriorityQueue;
// import java.util.Queue;
// import java.util.Set;
// import java.util.List;
// import java.util.LinkedList;
// import java.util.Map;
import java.util.*;
public class topkthfreq{
	public static List<Integer> topkth(int[] arr,int k){
		List<Integer> re=new LinkedList<Integer>();
		if(arr.length==0||arr==null){
			return re;
		}
		Map<Integer,Integer> freq=new HashMap<Integer,Integer>();
		for(int a:arr){
			if(!freq.containsKey(a)){
				freq.put(a,1);
			}
			else{
				freq.put(a,freq.get(a)+1);
			}
		}

		Comparator<Entry<Integer, Integer>> cmp = new Comparator<Entry<Integer, Integer>>(){
		    public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2){
		      return e2.getValue() - e1.getValue();
		    }
		  };

		  Queue<Entry<Integer, Integer>> q = new PriorityQueue<Entry<Integer, Integer>>(freq.size(), cmp);
		  for(Map.Entry<Integer,Integer> e:freq.entrySet()){
			  q.add(e);
		  }
		  while(k>0){
			  re.add(q.poll().getKey());
			  k--;
		  }
        // Map<Integer,Integer> pq=new TreeMap<Integer,Integer>(new Comparator<Integer>(){
//         	public int compare(Integer a, Integer b){
//         		return b-a;
//         	}
//         });
// 		for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
// 			pq.put(entry.getValue(),entry.getKey());
// 		}
// 		int count=0;
// 		for(Map.Entry<Integer,Integer> e:pq.entrySet()){
// 			if(count==k){
// 				break;
// 			}
// 			re.add(e.getValue());
// 			count++;
// 		}
		return re;
	}
	public static void main(String[] args){
		int[] arr=new int[]{1,1,21,21,21,4,2,3,3,3,3};
		System.out.println(topkth(arr,3));
	}
}
