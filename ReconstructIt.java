import java.util.*;
public class ReconstructIt{
  public static List<String> findItinerary(String[][] tickets) {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route=new ArrayList<String>();
    for (String[] ticket : tickets)
        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
    visit(route,"JFK",targets);
    return route;
  }
  public static void visit(List<String> route ,String airport,Map<String, PriorityQueue<String>> targets) {
    while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
        visit(route,targets.get(airport).poll(),targets);
    route.add(0, airport);
  }


  public static boolean topo(List<String> re,Map<String,PriorityQueue<String>> map,String place,Stack<String> stack){
    if(!map.containsKey(place)){
      re.add(stack.pop());
      return false;
    }
    PriorityQueue<String> pq=map.get(place);
    while(!pq.isEmpty()){
      String next=pq.poll();
      if(!topo(re,map,next,stack)){
        return false;
      }
    }
    stack.push(place);
    return true;
  }


  public static List<String> findItinerary1(String[][] tickets) {
    LinkedList<String> ret = new LinkedList<String>();
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    Stack<String> stack = new Stack<String>();
    for(String[] t : tickets) {
        if(!map.containsKey(t[0])) map.put(t[0], new PriorityQueue<String>());
        map.get(t[0]).offer(t[1]);
    }
    stack.push("JFK");
    while(!stack.isEmpty()) {
      System.out.println(stack);
        String next = stack.peek();
        if(map.containsKey(next) && map.get(next).size() > 0) {
          stack.push(map.get(next).poll());
        }else {
          ret.addFirst(stack.pop());
        }
    }
    return ret;
  }


  private void dfs(Map<String,List<String>> m,String src,List<String> res,int len){

        List<String> dests = m.get(src);
        if(dests != null && dests.size() >0) {
            for(int i=0;i<dests.size();i++) {
                String des = dests.remove(i);
                res.add(des);
                dfs(m, des, res, len);
                if(res.size() ==len) {
                    System.out.println(res);
                    return;
                }
                dests.add(i, des);
                res.remove(res.size()-1);
            }
        }
    }
    public List<String> findItinerary(String[][] tickets) {
        List<String> res=new ArrayList<String>();
        Map<String, List<String>> m=new HashMap<String,List<String>>();
        for (String[] a : tickets) {
            if(!m.containsKey(a[0])){
                m.put(a[0],new ArrayList<String>());
            }
            m.get(a[0]).add(a[1]);
        }
        for(String s:m.keySet()){
            Collections.sort(m.get(s));
        }
        res.add("JFK");
        dfs(m, "JFK", res,tickets.length+1);
        return res;
    }

  public static void main(String[] args){
  // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
    String[][] tickets=new String[][]
    {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};

    //{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

    // System.out.println(findItinerary(tickets));
    List<String> re=new ArrayList<String>();
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    for(String[] t : tickets) {
        if(!map.containsKey(t[0])) map.put(t[0], new PriorityQueue<String>());
        map.get(t[0]).offer(t[1]);
    }
    Stack<String> stack = new Stack<String>();
    stack.push("JFK");
    // topo(re,map,"JFK",stack);
    // System.out.println(re);
    System.out.println(findItinerary(tickets));
  }
}
