import java.util.*;
public class zigzagiterator{
	private LinkedList<Iterator<Integer>> l;
	private int pos;
	public zigzagiterator(Iterator<Integer> a, Iterator<Integer> b){
		pos=0;
		l=new LinkedList<Iterator<Integer>>();
		l.add(a);
		l.add(b);
	}
	public int next() {
		Iterator<Integer> tmp=l.get(pos);
		int re=tmp.next();
		pos=(pos+1)%l.size();
		return re;
	}
	public boolean hasNext() {
		return !l.isEmpty();
	}	
	
	public static void main(String[] args){
		LinkedList<Integer> a= new LinkedList<Integer>();
		LinkedList<Integer> b= new LinkedList<Integer>();
		a.add(1);
		a.add(3);
		b.add(2);
		b.add(4);
		
		zigzagiterator it=new zigzagiterator(a.iterator(),b.iterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}