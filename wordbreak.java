import java.util.*;
public class wordbreak{
	public static boolean bbreak(String s, Set<String> wordDict) {
	    Iterator<String> it=wordDict.iterator();
	           String t="";
	           while(it.hasNext()){
	               t+=it.next();
				   
	           }
			   
	           return s.replaceAll(t,"").isEmpty();
	}
	public static void main(String[] args){
		Set<String> word=new HashSet<String>();
		word.add("aaa");
		word.add("aaa");
		
		String s="aaaaaa";
		String num="A man, a plan, a canal: Panama";
		num=num.replaceAll("[^a-zA-Z]","").toLowerCase();
		System.out.println(num);
		// System.out.println(bbreak(s,word));
// 		String a="fit";
// 		String b="bit";
// 		System.out.println(a.replaceAll("["+b+"]",""));
	}
}