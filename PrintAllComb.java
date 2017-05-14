import java.util.*;
public class PrintAllComb{
  public static void backtrack(String s,List<String> re,String building,int start){
    if(start==s.length()){
      re.add(building);
      return;
    }
    char curr=s.charAt(start);
    String tmp=building;
    for(char ch:generate(curr)){
      building+=ch;
      backtrack(s,re,building,start+1);
      building=tmp;
    }
  }
  private static List<Character> generate(char s){
    List<Character> re=new ArrayList<Character>();
    re.add(s);
    if(Character.isDigit(s)){
      return re;
    }
    if('a'<=s && s<='z'){
      re.add((char)(s-32));
    }else{
      re.add((char)(s+32));
    }
    return re;
  }
  public static List<String> gene(String s){
    List<String> re=new ArrayList<String>();
    backtrack(s,re,"",0);
    return re;
  }
  public static void backtracking(List<String> re,String curr,String ss,boolean[] visited){
    if(ss.length()==curr.length()){
      List<String> generated=gene(curr);
      for(String g:generated){
        re.add(g);
      }
      return;
    }
    for(int i=0;i<ss.length();i++){
      if(visited[i]){
        continue;
      }
      visited[i]=true;
      curr+=ss.charAt(i);
      backtracking(re,curr,ss,visited);
      visited[i]=false;
      curr=curr.substring(0,curr.length()-1);
    }
  }
  public static void main(String[] args){
    String s="hr3a";
    String ss="abc";
    List<String> re=new ArrayList<String>();
    boolean[] visited=new boolean[ss.length()];
    backtracking(re,"",ss,visited);
    System.out.println(re);
  }
}
