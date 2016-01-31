import java.util.*;
	 public class stringop{
		 //remove duplicate in a string of alphabets
		 public static int countwords(String s){
			 int count=0;
			 if(Character.isLetter(s.charAt(0))){
				 count=1;
			 }
			 for(int i=1;i<s.length();i++){
				 if(!Character.isLetter(s.charAt(i-1))&& Character.isLetter(s.charAt(i))){
					 count++;
				 }
			 }
			 return count;
		 }
		 public static LinkedList<String> findneighbor(String s, Set<String> word){
		         LinkedList<String> re=new LinkedList<String>();
		         Iterator<String> it=word.iterator();
		         while(it.hasNext()){
					 String t=it.next();
		             if(t.length()==s.length()&&s.replaceAll("["+t+"]","").length()==1){
		                 re.add(t);
				     }
		         }
		         return re;
		     }
			 public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
				 wordList.add(endWord);
			         Queue<String> q=new LinkedList<String>();
			         HashSet<String> visited=new HashSet<String>();
			         int len=0;
			         q.offer(beginWord);
			         visited.add(beginWord);
			         while(!q.isEmpty()){
			             int currsize=q.size();
			             for(int i=0;i<currsize;i++){
			             String curr=q.poll();
			             if(curr.equals(endWord)){
			                 return len+1;
			             }
			             LinkedList<String> tmp=findneighbor(curr, wordList);
			             while(!tmp.isEmpty()){
			                 String t=tmp.removeLast();
			                 if(!visited.contains(t)){
			                     q.add(t);
			                     visited.add(t);
			                 }
			             }
			             }
			             len++;
			         }
			         return 0;
			     }
				 
				 
				 
				 public static void ana(String s, String t, List<String> re){
					 if(t.length()==s.length()){
						 re.add(t);
						 return;
					 }
					 for(int i=0;i<s.length();i++){
						 if(t.contains(Character.toString(s.charAt(i)))){
							 continue;
						 }
						 t=t+s.charAt(i);
						 ana(s, t, re);
						 t=t.substring(0,t.length()-1);
					 }
				 }
				 public static List<String> allanagram(String s){
					 List<String> re=new LinkedList<String>();
					 if(s==null||s.length()==0){
						 return re;
					 }
					 String t="";
					 ana(s, t, re);
					 return re;
				 }
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
			}
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
			String b1="d";
			System.out.println(a1.replaceAll("[^"+b1+"]",""));
			String v="A man, a plan, a canal: Panama";
			Set<String> word=new HashSet<String>();
			word.add("hot");
			word.add("dot");
			word.add("dog");
			word.add("log");
			word.add("lot");
			
			
			// System.out.println(ladderLength("hit","cog",word));
			System.out.println(allanagram("asf"));
			// System.out.println(countwords(v));
			// System.out.println(isAnagram(a1,b1));
			// System.out.println(removeDuplicateLetters(a));
// 			System.out.println(reverseString(a));
		}
	}