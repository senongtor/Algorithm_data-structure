import java.util.*;
public class wordbreak{
	public static boolean dfs(String s,int index,List<String> wordDict,Set<String> unbreakable){
        if(index==s.length()){
            return true;
        }
        for(int i=index;i<s.length();i++){
						boolean check=false;
						String curr=s.substring(index,i+1);
						if(unbreakable.contains(curr)){
							continue;
						}
            if(wordDict.contains(curr)){
                check|=dfs(s,i+1,wordDict,unbreakable);
            }else{
							unbreakable.add(curr);
						}
						if(check==true){
							return check;
						}
        }
        return false;
  }
  public static boolean wordBreak(String s, List<String> wordDict,Set<String> unbreakable) {
        return dfs(s,0,wordDict,unbreakable);
  }
	public static void main(String[] args){
		List<String> wordDict=new ArrayList<>();
		wordDict.add("aaaa");
		wordDict.add("aaa");

		String s="aaaaaaa";
		System.out.println(wordBreak(s,wordDict,new HashSet<String>()));
		// String num="A man, a plan, a canal: Panama";
		// num=num.replaceAll("[^a-zA-Z]","").toLowerCase();
		// System.out.println(num);
		// System.out.println(wbreak(s,word));
// 		String a="fit";
// 		String b="bit";
// 		System.out.println(a.replaceAll("["+b+"]",""));
	}
}
