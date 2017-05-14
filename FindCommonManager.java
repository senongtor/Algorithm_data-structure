import java.io.*;
import java.util.*;
public class FindCommonManager {

  static void findLCA(Map<String,String> points, String em1, String em2){
      String re="";
      List<String> em1path=new ArrayList<String>();
      Set<String> em2pathset=new HashSet<String>();
      String s=em1;
      em1path.add(s);
      while(points.get(s)!=s){
          s=points.get(s);
          em1path.add(s);
      }
      s=em2;
      em2pathset.add(s);
      while(points.get(s)!=s){
          s=points.get(s);
          em2pathset.add(s);
      }
      for(int i=0;i<em1path.size();i++){
          if(em2pathset.contains(em1path.get(i))){
              re=em1path.get(i);
              break;
          }
      }
      System.out.println(re);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Set<String> elements=new HashSet<String>();
    Map<String,String> points=new HashMap<String,String>();
    String em1="";
    String em2="";
    while ((s = in.readLine()) != null) {
        
      String[] str=s.split(",");
      for(int i=0;i< str.length;i++){
          if(i==str.length-2){
              em1=str[i];
          }else if(i==str.length-1){
              em2=str[i];
          }else{
              String[] relation=str[i].split("->");
              if(!elements.contains(relation[0])){
                  elements.add(relation[0]);
              }
              if(!elements.contains(relation[1])){
                  elements.add(relation[1]);
              }
              points.put(relation[1],relation[0]);
          }
      }
      Iterator<String> it=elements.iterator();
      while(it.hasNext()){
          String tmp=it.next();
          if(!points.containsKey(tmp)){
              points.put(tmp,tmp);
          }
      }
      findLCA(points,em1,em2);
    }
  }
}
