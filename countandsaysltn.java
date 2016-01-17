import java.util.*;
public class countandsaysltn{
	public static String countAndSay(int n) {
	        StringBuilder re = new StringBuilder();
	        String num=Integer.toString(n);
	        int count =1;
	        char tmp=num.charAt(0);
	        for(int i=1;i<num.length();i++){
	            if(num.charAt(i)==tmp){
	                count++;
	            }
	            else{
	                re.append(count).append(tmp);
	                tmp=num.charAt(i);
	                count=1;
	            }
	        }
	        re.append(count).append(num.charAt(num.length()-1));
	        return re.toString();
	    }
        
		public static void main(String[] args){
			System.out.println(countAndSay(2));
			
		}
}