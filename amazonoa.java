import java.util.*;
public class selectionsort{
	public static void select(int[] arr){ 
		for(int i=0;i<arr.length;i++){
			int index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[index]){
					index=j;
				}	
				int temp=arr[index];
				arr[index]=arr[i];
				arr[i]=temp;
			}
		}
	}
	public static void insertion(int[] arr){
		for(int i=1;i<arr.length;i++){
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		
	}
	public static void reverse(int[] arr){
		for(int i = 0; i < arr.length / 2; i++)
		{
		    int temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
		
	}
	public static int[] removeelt(int arr[], int index){
		int i,j,len=arr.length;
		if(index<len){
			for(i=index;i<len-1;i++){
				arr[i]=arr[i+1];
			}
			int rarr[]=new int[len-1];
			for(i=0;i<len-1;i++){
				rarr[i]=arr[i];		
			}
			return rarr;
		}
		else
			return arr;
	}
	public static int[] inplacesort(int arr[]){
		int i, max, location, j, temp, len = arr.length;
		for(i=0;i<len;i++){
			max=arr[i];
			location=i;
			for(j=i;j<len;j++){
				if(max<arr[j]){
					max=arr[j];
					location=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[location];
			arr[location]=temp;
		}
		return arr;
	}
	public static int[] replaceValues(int[] arr){
		int i,j,len=arr.length;
		if(len%2==0){
			for(i=0;i<len;i++)
				arr[i]=0;
		}
		else{
			for(j=0;j<len;j++)
				arr[j]=1;
		}
		return arr;
	}
	public static int[] sortArray(int[] arr){
		int len=arr.length;
		int small,pos,i,j,temp;
		for(i=0;i<=len-1;i++){
			for(j=i;j<len;j++){
				temp=0;
				if(arr[i]<arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public static void printpattern(int num){
		int i,print=0;
		if(num%2==0){
			print=0;
			for(i=0;i<num;i++){
				System.out.println(print+" ");
			print+=2;
		}
		}
		else{
			print=1;
			for(i=0;i<num;i++){
				System.out.println(print+" ");
			print+=2;
		}
		}
	}
	public static void main(String[] args){
		int[] arr=new int[]{3,1,5,12,23,7,9};
		printpattern(2);
		// reverse(arr);
// 		System.out.println(Arrays.toString(arr));
// 		int[] result=new int[]{0,0,0,0,0,0};
// 		for(int i=0;i<=arr.length-1;i++){
// 			int temp=arr[arr.length-i-1];
// 			result[i]=temp;
// 		}
		// System.out.println(Arrays.toString(sortArray(arr)));
 	}

}