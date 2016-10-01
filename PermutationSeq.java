import java.util.*;
public class PermutationSeq {
	public static String getPermutation(int n, int k){
		int []num = new int[n];
		int permCount = 1;
		for(int i=0;i<n;i++)
		{
			num[i] = i+1;
			permCount*=(i+1);
		}
		k--; 

		StringBuilder target = new StringBuilder();  
	
		for(int i=0;i<n;i++){  
			System.out.println(k);
			permCount = permCount/(n-i);
			int choosed = k/permCount; 
			target.append(num[choosed]); 
		
			for(int j=choosed;j<n-i-1;j++){  
				num[j] = num[j+1];  
			}
			System.out.println(Arrays.toString(num));  
			k = k%permCount; //在每组中数字的位置 
		}  
	
		return target.toString();  
	}  
	public static void main(String[] args){
		System.out.println(getPermutation(4,4));
	}
}