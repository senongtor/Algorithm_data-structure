import java.util.*;
public class QuickSelect{
  public static void swap(int[] arr,int i, int j){
    int tmp=arr[i];
    arr[i]=arr[j];
    arr[j]=tmp;
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
  public static int quickselect(int[] arr,int l, int r, int k){
    //if(k>=0 && k<=r-l+1){
      int pos=partition(arr,l,r);
      
    // }
    // return -1;
  }
  public static int findKthLargest(int[] nums, int k) {
                PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

                for(int el : nums) {
                    largeK.add(el);
                    if (largeK.size() > k) {
                        largeK.poll();
                    }
                }

                return largeK.poll();
            }
  public static List<String> letterCombinations(String digits) {
              LinkedList<String> ans = new LinkedList<String>();
              String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
              ans.add("");
              for(int i =0; i<digits.length();i++){
                  int x = digits.charAt(i)-'0';
                  System.out.printf("%d,%s\n",i,ans.peek());
                  while(ans.peek().length()==i){
                      String t = ans.remove();
                      for(char s : mapping[x].toCharArray())
                          ans.add(t+s);
                  }
              }
              return ans;
  }
  public static void main(String[] args){
    // int[] arr=new int[]{3,1,2,4,5};
    // System.out.println(quickselect(arr,0,arr.length-1,3));
    // System.out.println(findKthLargest(new int[]{10,9,8,7,6,5,4},3));
    // System.out.println(0xf);
    // System.out.println(5 & 7);
    System.out.println(letterCombinations("23"));
  }
}
