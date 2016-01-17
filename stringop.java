import java.util.*;
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
			
		        if(str.length() == 1){
		            return str;
		        } 
		            return (str.charAt(str.length()-1)+reverseString(str.substring(0,str.length()-1)));
		    }
		public static boolean ispalindrome(String str){
			String result="";
			if(str.length()==0 || str.length()==1){
				return true;
			}
			if(str.charAt(0)==str.charAt(str.length()-1)){
				return ispalindrome(str.substring(1,str.length()-1));
			}
			return false;
		}	
		public static boolean check(String s){
		        int len=s.length();
		        if(s.length()==1 || s.length()==0){
		            return true;
		        }
		        if(s.charAt(0)==s.charAt(len-1)){
		            return check(s.substring(1,len-1));
		        }
		        return false;
		    }
		    public static boolean validPalindrome(String s) {
		        if(s.length()==0||s==null){
		            return false;
		        }
		        s=s.replaceAll("[^a-zA-Z]","").toLowerCase();
		        return check(s);
		    }
			public boolean validPalindrome2(String s) {
			        if(s.length()==0||s==null||s.length()==1){
			            return true;
			        }
        
			        int i=0;
			        int j=s.length()-1;
			        while (i < j) {
			        while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
			            i++;
			        }
			        while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
			            j--;
			        }
        
			        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)) ) {
			            return false;
			        }
			        i++;
			        j--;
			    }
			    return true;
	    public static boolean isanagram(String a, String b){
	   	 if(a.length()!=b.length()){
	   		 return false;
	   	 }
		 if(a.equals(b)){
			 return true;
		 }
	   	 int[] arr=new int[26];
	   	 for(int i=0;i<a.length();i++){
	   		arr[(int) a.charAt(i)-97]++;
	   	 }
	   	 for(int i=0;i<b.length();i++){
	   		 arr[(int) b.charAt(i)-97]--;
	   		 if(arr[(int) b.charAt(i)-97]<0){
	   			 return false;
	   		 }
	   	 }
	   	 return true;
	    } 
		public static boolean isanagramap(String a, String b){
			if((a==null&&b==null) || (a.length()==0&&b.length()==0)){
				System.out.println("What are you nongsalei?");
				return false;
			}
			Map<Character, Integer> m=new HashMap<Character, Integer>();
			for(int i=0;i<a.length();i++){
				m.put(a.charAt(i),1);
			}
			for(int i=0;i<b.length();i++){
				if(m.containsKey(b.charAt(i))){
					m.remove(b.charAt(i));
				}
			}
			return m.isEmpty();
		}
	    public static String shift(String s,int n){
	   	 String result="";
	    	 for(int i=0;i<s.length();i++){
	   		 result+=(char)(s.charAt(i)+3);
	    	 }
	   	 return result; 
	    }
		public static void main(String[] args){
			String a="bbssqa";
			String a1="afbc";
			String b1="bafbc";
			String v="A man, a plan, a canal: Panama";
			System.out.println(validPalindrome(v));
			// System.out.println(isAnagram(a1,b1));
			// System.out.println(removeDuplicateLetters(a));
// 			System.out.println(reverseString(a));
		}
	}