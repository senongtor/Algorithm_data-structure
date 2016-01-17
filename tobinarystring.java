import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class tobinarystring{
	
	public static void main(String[] args){
		int r=11;
		String binary="";
		while(r!=0){
			binary=r%2+binary;
			r/=2;
		}
		System.out.println(binary);
	}
}