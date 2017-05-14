import java.util.*;
public class Kruskal{
  public static char find(char ch,Map<Character,Character> parent){
    while(parent.get(ch)!=ch){
      ch=parent.get(ch);
    }
    return ch;
  }
  public static void main(String[] args){
    Map<Character,Character> parent=new HashMap<>();
    TreeMap<Integer,String> weights=new TreeMap<Integer,String>();
    weights.put(1,"ae");
    weights.put(2,"cd");
    weights.put(3,"ab");
    weights.put(4,"be");
    weights.put(5,"bc");
    weights.put(6,"ec");
    weights.put(7,"ed");
    for(Map.Entry<Integer,String> entry:weights.entrySet()){
      String edge=entry.getValue();
      char x=edge.charAt(0);
      char y=edge.charAt(1);
      if(!parent.containsKey(x)){
        parent.put(x,x);
      }
      if(!parent.containsKey(y)){
        parent.put(y,y);
      }
    }
    Set<Character> re=new HashSet<Character>();
    int w=0;
    for(Map.Entry<Integer,String> entry:weights.entrySet()){
      String edge=entry.getValue();
      char x=edge.charAt(0);
      char y=edge.charAt(1);
      char px=find(x,parent);
      char py=find(y,parent);
      if(px!=py){
        w+=entry.getKey();
        parent.put(px,py);
        re.add(x);
        re.add(y);
      }
    }
    System.out.println(re);
    System.out.println(w);
  }
}
