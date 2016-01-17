import java.util.*;
public class triangle{
	public static int minpath(List<List<Integer>> l){
		if(l==null||l.size()==0){
			return 0;
		}
		int n=l.size();
		int[] lookup=new int[n];
		for(int i=0;i<n;i++){
			lookup[i]=l.get(n-1).get(i);
		}
		for(int j=n-2;j>=0;j--){
			for(int k=0;k<=j;k++){
				lookup[k]=l.get(j).get(k)+Math.min(lookup[k],lookup[k+1]);
			}
		}
		return lookup[0];
	}
	public static void main(String[] args){
		List<List<Integer>> l= new ArrayList<List<Integer>>();
		int count=1;
		for(int i=0;i<3;i++){
			List<Integer> t=new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				t.add(count++);
			}
			l.add(t);
		}
		System.out.println(minpath(l));
	}
}