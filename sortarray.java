import java.util.*;
public class sortarray{
	public static void main(String[] args){
		int[] arr=new int[]{4,3,2,1,7,8,9};
		
		mergesort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	
	}
	public static void swap(int[] arr, int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static int partition(int[] arr,int low, int high){
		int pivot=arr[high];
		int index=low;
		for(int i=low;i<high;i++){
			if(arr[i]<pivot){
				swap(arr,i, index);
				index+=1;
			}
		}
		swap(arr,index,high);
		return index;
	}
	public static void quicksort(int[] arr, int low, int high){
		if(low>=high){
			return;
		}
		int q=partition(arr,low,high);
		quicksort(arr,low,q-1);
		quicksort(arr,q+1,high);
	}
	public static void selectionsort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){
					index=j;
				}
			}
			int temp=arr[index];
			arr[index]=arr[i];
			arr[i]=temp;
		}
	}
	public static void bubblesort(int[] arr){
		boolean flag=true;
		int temp=0;
		while(flag){
			flag=false;
			for(int i=0;i<arr.length-1;i++){
				if(arr[i]>arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					flag=true;
				}
			}
		}
	}
	public static void heapsort(int[] arr){
		PriorityQueue<Integer> pq=new PriorityQueue<>(arr.length);
		for(int a:arr){
			pq.add(a);
		}
		for(int i=0;i<arr.length;i++){
			arr[i]=pq.poll();
		}
	}
	public static void insertionsort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int val=arr[i];
			int j=i-1;
				while(j>=0&&arr[j]>val){
					arr[j+1]=arr[j];
					j--;
				}
				arr[j+1]=val;
		}
	}
	public static void countingsort1(int[] arr){
		int[] count=new int[10];
		for(int a:arr){
			count[a]++;
		}
		int index=0;
		for(int i=0;i<count.length;i++){
			for(int j=0;j<count[i];j++){
				arr[index++]=i;
			}
		}
	}
	public static void countingsort2(int[] arr){
		int[] count=new int[10];
		int[] b=new int[arr.length];
		for(int a:arr){
			count[a]++;
		}
		System.out.println(Arrays.toString(count));
		for(int i=1;i<count.length;i++){
			count[i]=count[i]+count[i-1];
		}
		System.out.println(Arrays.toString(count));
		for(int j=arr.length-1;j>=0;j--){
			count[arr[j]]=count[arr[j]]-1;
			b[count[arr[j]]]=arr[j];	
		}
		System.arraycopy(b, 0, arr, 0, arr.length);
	}
	public static void merge(int[] arr, int low, int mid, int high){
		int[] tmp=new int[arr.length];
		System.arraycopy(arr,0,tmp,0,arr.length);
		int i=low;
		int j=mid+1;
		int index=low;
		while(i<=mid&&j<=high){
			if(tmp[i]<tmp[j]){
				arr[index++]=tmp[i++];
			}
			else{
				arr[index++]=tmp[j++];
			}
		}
		while(i<=mid){
			arr[index++]=tmp[i++];
		}
	}
	public static void mergesort(int[] arr, int low, int high){
		if(low>=high) return;
		int mid=low+(high-low)/2;
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,low, mid, high);
	}
	// public static int search(int[] arr){
// 		for(int )
// 	}
}