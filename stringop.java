	 public class stringop{
		 //remove duplicate in a string of alphabets
	    public static String removeDuplicateLetters(String s) {
	        int[] arr=new int[26];
	        for(int i=0;i<s.length();i++){
	            arr[s.charAt(i)-97]+=1;
	        }
	        StringBuilder n = new StringBuilder("");
	        for(int j=0;j<arr.length;j++){
	            if(arr[j]>0){
	                n.append((char)(j+97));
	            }
	        }
	        return n.toString();
	    }
		//reverse string recursive I.
		public static String reverseString(String str){
			String reverse="";
		        if(str.length() == 1){
		            return str;
		        } else {
		            reverse += str.charAt(str.length()-1)
		                    +reverseString(str.substring(0,str.length()-1));
		            return reverse;
		        }
		    }
		public static boolean ispalindrome(String str){
			String result="";
			if(str.length()==0 || str.length()==1){
				return true;
			}
			if(str.charAt(0)==str.charAt(str.length()-1)){
				return palindrome(str.substring(1,str.length()-1));
			}
			return false;
		}	
		public static void main(String[] args){
			String a="bbssqa";
			System.out.println(removeDuplicateLetters(a));
			System.out.println(ispalindrome(a));
		}
	}