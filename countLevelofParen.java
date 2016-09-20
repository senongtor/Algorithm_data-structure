import java.util.*;
public class countLevelofParen{
	public static void main(String[] args){
		int leftCount=0;
		int count=0;
		String test="(1+(2+(3)))";		
		for(char ch:test.toCharArray()){
			if(ch=='('){
				leftCount++;
			}
			if(ch==')'){
				leftCount--;
			}
			count=Math.max(leftCount,count);
		}
		System.out.println(count);
	}
}