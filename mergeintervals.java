import java.util.*;
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
	  @Override
	  public String toString(){
		  return "["+Integer.toString(start)+","+Integer.toString(end)+"]";
	  }
  }
 
public class mergeintervals{
public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> re=new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0){
            return re;
        }
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        Interval prev=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval curr=intervals.get(i);
            if(prev.end>=curr.start){
                Interval merged=new Interval(prev.start,Math.max(prev.end,curr.end));
                prev=merged;
            }
            else{
                re.add(prev);
                prev=curr;
            }
        }
        re.add(prev);
        return re;
    }
	public static void main(String[] args){
		List<Interval> l=new ArrayList<Interval>();
		Interval a=new Interval(1,3);
		l.add(a);
		Interval b=new Interval(2,6);
		l.add(b);
		Interval c=new Interval(8,10);
		l.add(c);
		Interval d=new Interval(15,18);
		l.add(d);
		List<Interval> re=new ArrayList<Interval>(merge(l));
		System.out.println(re.toString());
	}
}	