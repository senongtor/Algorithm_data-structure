import java.util.*;
public class ArrangeMovies{
  public static boolean backtracking(List<List<String>> re, Map<String,List<Integer>> schedule, List<String> curr, int start, List<String> movies){
      if(start==movies.size()){
        re.add(new ArrayList<>(curr));
        return true;
      }

      List<Integer> currschedule=schedule.get(movies.get(start));

      for(int n: currschedule){
        String s=String.valueOf(n);
        if(curr.contains(s)){
          continue;
        }
        curr.add(s);
        boolean result=backtracking(re,schedule,curr,start+1,movies);
        if(result){
          return true;
        }
        curr.remove(curr.size()-1);
      }
      return false;
  }
  private static boolean ba(List<Integer> re,int i,List<String> movies,Map<String,List<Integer>> schedule){
    if(i==movies.size()){
      return true;
    }
    String movie=movies.get(i);
    for(int sch:schedule.get(movie)){
      if(!re.contains(sch)){
        re.add(sch);
        boolean res=ba(re,i+1,movies,schedule);
        if(res){
          return true;
        }
        re.remove(re.size()-1);
      }
    }
    return false;
  }

  public static void main(String[] args){
    // A: 14, 15, 16, 17;
    // B: 14, 15, 16;
    // C: 14, 15;
    // D: 14, 15, 17;
    Map<String,List<Integer>> schedule=new HashMap<String,List<Integer>>();
    schedule.put("A",Arrays.asList(14,15,16,17));
    schedule.put("B",Arrays.asList(14,15,16));
    schedule.put("C",Arrays.asList(14,15));
    schedule.put("D",Arrays.asList(14,15,17));
    List<String> movies=new ArrayList<>(Arrays.asList("A","B","C","D"));
    List<List<String>> re=new ArrayList<List<String>>();
    List<Integer> r=new ArrayList<Integer>();
    ba(r,0,movies,schedule);
    System.out.println(r);

    // backtracking(re, schedule, r, 0, movies);
    // System.out.println(r);

  }
}
