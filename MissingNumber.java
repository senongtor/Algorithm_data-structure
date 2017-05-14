import java.util.*;
public class MissingNumber{
  public static int bs(int[] arr){
    Arrays.sort(arr);
    int l=0;
    int r=arr.length-1;
    while(l<r){
      int mid=(l+r)/2;
      if(arr[mid]>mid){
        r=mid;
      }else if(arr[mid]<=mid){
        l=mid+1;
      }
    }
    return l;
  }
  private static void swap(int[] arr,int l,int r){
    int tmp=arr[l];
    arr[l]=arr[r];
    arr[r]=tmp;
  }
  private static int swapAndCheck(int[] arr){
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=i){
        if(arr[i]<arr.length){
          swap(arr,arr[i],i);
        }
      }
    }
    System.out.println(Arrays.toString(arr));
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=i){
        return i;
      }
    }
    return 0;
  }
  private static int markAndCheck(int[] arr){
    for(int i=0;i<arr.length;i++){
      
    }
  }
  public static void main(String[] args){
    int[] arr1=new int[]{0,2,3,4};
    int[] arr2=new int[]{1,3,3,4};
    System.out.println(swapAndCheck(arr2));
  }
}
