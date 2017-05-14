import java.util.*;
public class WordLadderPrint{
    private static List<String> getNeighbors(String currEntry,List<String> wordL){
      Set<String> wordList=new HashSet<String>(wordL);
      char[] curr=currEntry.toCharArray();
      List<String> result=new ArrayList<>();
      for(int j=0;j<curr.length;j++){
          for(char ch='a';ch <= 'z';ch++){
              char old=curr[j];
              if(curr[j]==ch){
                  continue;
              }
              curr[j]=ch;
              String currString =String.valueOf(curr);
              if(wordList.contains(currString)){
                  result.add(currString);
              }
              curr[j]=old;
          }
      }
      return result;
    }
    private static void dfs(String beginWord,String endWord, List<List<String>> re,List<String> curr,Map<String,Integer> levels,Map<String,List<String>> graph){
      curr.add(beginWord);
      if(beginWord.equals(endWord)){
         re.add(new ArrayList<String>(curr));
      }
      List<String> neighbors=graph.get(beginWord);
      for(String s:neighbors){
          if(levels.get(s)==levels.get(beginWord)+1){
              dfs(s,endWord,re,curr,levels,graph);
          }
      }
      curr.remove(curr.size()-1);
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      Map<String,Integer> levels=new HashMap<String,Integer>();
      Map<String,List<String>> graph=new HashMap<String,List<String>>();
      Queue<String> q=new LinkedList<String>();
      int level=0;
      levels.put(beginWord,level);
      for(String s:wordList){
          graph.put(s,new ArrayList<String>());
      }
      graph.put(beginWord,new ArrayList<String>());
      q.offer(beginWord);
      while(!q.isEmpty()){
          int size=q.size();
          boolean found=false;
          for(int i=0;i<size;i++){
              String curr=q.poll();
              List<String> neighbors=getNeighbors(curr,wordList);
              for(String s:neighbors){
                  if(!levels.containsKey(s)){
                      levels.put(s,level+1);
                      graph.get(curr).add(s);
                      if (endWord.equals(s))
                          found = true;
                      else
                          q.offer(s);
                  }
                  else if(levels.get(s)>level){
                      graph.get(curr).add(s);
                  }
              }
          }
          level++;
          if(found){
              break;
          }
      }
      // System.out.println(levels);
      // System.out.println(graph);
      List<List<String>> re=new ArrayList<List<String>>();
      dfs(beginWord,endWord,re,new ArrayList<String>(),levels,graph);
      return re;
    }

    public static void main(String[] args){
      String beginWord = "hit";
      String endWord = "cog";
      List<String> wordList = new ArrayList<String>();
      wordList.add("hot");
      wordList.add("dot");
      wordList.add("dog");
      wordList.add("lot");
      wordList.add("log");
      wordList.add("cog");
      // printAll(wordList, beginWord, endWord);
      System.out.println(findLadders(beginWord,endWord,wordList));
    }
  //   hit
  //   hot
  // dot lot
  // dog log
  //   cog
}
