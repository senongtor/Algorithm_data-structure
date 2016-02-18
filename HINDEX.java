import java.util.*;
public class HINDEX{
    public static int hIndex(int[] citations) {
        int len=citations.length;
        int result=0;
        Arrays.sort(citations);
        for(int i=1;i<=len;i++){
            if(i<=len-1){
                if(citations[len-i]>=i){
                    result=Math.max(i,result);
                }
            }
            else{
                if(citations[0]>=i){
                    result=Math.max(i,result);
                }
            }    
        }
        return result;
    }
	public static void main(String[] args){
		int[] citations=new int[]{1,1};
		System.out.println(hIndex(citations));
	}
}