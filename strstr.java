public class strstr{
 public static int strStr(String haystack, String needle) {
        int len=haystack.length();
        int lenn=needle.length();
		for(int i=0;i<len;i++){
		            for(int j=i;j<len;j++){
		                if(haystack.substring(i,j+1).equals(needle)){
		                    return i;
		                }
		            }
		        }
        return -1;
    }
	public static int strStr2(String haystack, String needle) {
	        if(needle.length()==0){
	            return 0;
	        }
	        int len=haystack.length();
	        int lenn=needle.length();
	        for(int i=0;i<=len-lenn;i++){
	           if(haystack.substring(i,i+lenn).equals(needle)){
	               return i;
	           }
	        }
	        return -1;
	    }
		
	public static void main(String[] args){
		String haystack="tutopointssss";
		String needle="points";
		System.out.println(strStr(haystack,needle));
		
	}
}