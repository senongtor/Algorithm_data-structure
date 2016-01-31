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
	// public static binaryclos(int[] arr, int target, int l, int r){
// 		int cloest=0;
// 		if(left<=right){
// 			int mid=l+(r-l)/2;
// 			if(arr[mid]==target){
// 				return mid;
// 			}
// 			cloest=arr[mid];
// 			if(target<arr[mid]){
//
// 			}
// 		}
// 	}
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
	//-----------------------------
	public static int rotatedmin(int[] arr,  int low, int high){
		if(low>=high-1){
			return Math.min(arr[low],arr[high]);
		}
		if(arr[low]<arr[high]){
			return arr[low];
		}
		else{
			int mid=low+(high-low)/2;
			if(arr[mid]<arr[high]){
				return rotatedmin(arr,low, mid);
			}
			else if(arr[mid]>arr[high]){
				return rotatedmin(arr,mid,high);
			}
		}
		return -1;
	}
	public static int rotatedmin2(int[] arr){
		if(arr.length==0||arr==null){
			return -1;
		}
		for(int i=1;i<arr.length;i++){
			if(arr[i-1]>arr[i]){
				return arr[i];
			}
		}
		return -1;
	}
	public static int rotated2min(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]<arr[i+1]){
				return arr[i];
			}
		}
		return -1;
	}
	public static int rotated2min2(int[] arr){
		int l=0;
		int r=arr.length-1;
		while(l<=r){
			int m=l+(r-l)/2;
			if(m==0||arr[m-1]>arr[m]){
				if( m==arr.length-1 || arr[m]<arr[m+1]){
					return arr[m];
				}
				else{
					l=m+1;
				}
			}
			r=m-1;
		}
		return -1;
	}
	public static int findmin(int[] arr){
		int left=0;
		int right=arr.length-1;
		while(left<=right){
			int mid=left+(right-left)/2;
			if(mid==arr.length-1 || arr[mid]<arr[mid+1]){
				if(mid==0||arr[mid]<arr[mid-1]){
					return mid;
				}
				else {
					right=mid-1;
					
				}
			}
			else{
				left=mid+1;
			}
		}
		return 0;
	}
	public static int rotatedsearch1(int[] arr, int target){
		int pivot=0;
		int l=0;
		int r=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]<arr[i+1]){
				pivot=i;
				break;
			}
		}
		if(pivot==0){
			pivot=arr.length-1;
		}
		
		if(target==arr[pivot]){
			return pivot;
		}
		else{
			l=binaryrec(arr, target, 0, pivot-1);
			r=binaryrec(arr,target, pivot+1, arr.length-1);
		}

		if(l!=r){
			if(l==-1){
				return r;
			}
			if(r==-1){
				return l;
			}
			return l;
		}
		return -1;
	}
	public static void merge(int[] arr, int[] brr){
		int m=arr.length;
		int n=brr.length;
		int index=0;
		while(m>=0 && n>=0){
			
		}
	}
	public static void main(String[] args){
		int[] arr=new int[]{4,3,2,1};
	    //int[] arr2=new int[]{7,8,9,1,2,3,4};
		int[] a=new int[]{1,2,3,4,0,0,0};
		int[] b=new int[]{9,8,7};
		String s="AB";
        System.out.println(s.charAt(0)-'A'+1);
		// Arrays.sort(arr);
// 		System.out.println(Arrays.toString(arr));
// 		System.out.println(binaryit(arr, 3));
		// System.out.println(rotatedmin2(arr2));
		// System.out.println(rotatedsearch1(arr,3));
		// System.out.println(findmin(arr));
	}
}