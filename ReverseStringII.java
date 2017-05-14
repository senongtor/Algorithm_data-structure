import java.util.*;
public class ReverseStringII{
    public static String reverse(String s,int k,int kk){
        if(k>kk){
            return s;
        }
        int start=0;
        int end=start+k-1;

        char[] sArr=s.toCharArray();
        while(start<end){
            char tmp=sArr[start];
            sArr[start]=sArr[end];
            sArr[end]=tmp;
            start++;
            end--;
        }
        return String.valueOf(sArr);
    }
    public static String reverseStr(String s, int k) {
        if(s.length()<k){
            return reverse(s,s.length(),s.length());
        }

        StringBuilder sb=new StringBuilder();
        int idx=0;
        while(idx<s.length()){
            if(idx+2*k-1 < s.length()){
                sb.append(reverse(s.substring(idx,idx+2*k),k,2*k));
            }else{
                sb.append(reverse(s.substring(idx,s.length()),k,s.length()-idx-1));
                break;
            }
            idx=idx+2*k;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(reverseStr("abcdefg",2));
    }
}
