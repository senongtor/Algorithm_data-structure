import java.util.*;
public class search{
	public static int binaryrec(int[] arr, int target, int low, int high){
		if(low<=high){
			int mid=low+(high-low)/2;
			if(arr[mid]==target){
				return mid;
			}
			else if(arr[mid]<target){
				return binaryrec(arr, target, mid+1, high);
			}
			else{
				return binaryrec(arr, target, low, mid-1);
			}
		}
		return -1;
	}
	public static int binaryit(int[] arr, int target){
		int low=0;
		int high=arr.length;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(arr[mid]==target){
				return mid;
			}
			else if(arr[mid]<target){
				low=mid+1;
			}
			else{
				high=mid-1;
			}
		}
		return -1;
	}
	public static rotated1(int[] arr, int target, int low, int high){
		if(low<=high){
			
		}
		
	}
	
	public static void main(String[] args){
		int[] arr=new int[]{4,3,2,1,7,8,9};
		int[] arr2=new int[]{7,8,9,1,2,3,4};
		int[] a=new int[]{1,2,3,4,0,0,0};
		int[] b=new int[]{9,8,7};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binaryit(arr, 3));
	}
}