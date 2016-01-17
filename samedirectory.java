import java.util.*;
import java.io.*;
public class samedirectory{
	public static void getfiles(File a, List<String> re){
		File[] curr=a.listFiles();
		if(curr.length==0){
			return;
		}
		for(File s:curr){
			if(s.isFile()){
				re.add(s.getName());
			}
			else if(s.isDirectory()){
				getfiles(s,re);
			}
		}
	}
	public static boolean isSame(File a, File b){
		List<String> are=new LinkedList<String>();
		List<String> bre=new LinkedList<String>();
		getfiles(a,are);
		System.out.println(are);
		getfiles(b,bre);
		System.out.println(bre);
		return are.equals(bre)?true:false;
		
	}
	public static void main(String[] args){
		File dir1 = new File("/Users/senongtor/desktop/intern");
		File dir2 = new File("/Users/senongtor/downloads/test");
		System.out.println(isSame(dir1, dir2));
		// List<String> l=new LinkedList<String>();
// 		getfiles(dir1,l);
// 		System.out.println(l);
	}
}