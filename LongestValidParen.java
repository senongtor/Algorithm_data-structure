import java.util.*;
class Entry{
    int idx;
    int side;
    public Entry(){}
    public Entry(int idx,int side){
        this.idx=idx;
        this.side=side;
    }
    public String toString(){
        return String.format("Idx:%d,Side:%d",idx,side);
    }
}
public class LongestValidParen {
    public static int longestValidParentheses(String s) {
        Stack<Entry> stk=new Stack<Entry>();   // first: index, second: 0:'(', 1:')'
        int maxLen = 0, curLen = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(')   // left parenthesis
                stk.push(new Entry(i,0));
            else {          // right parenthesis
                if(stk.isEmpty() || stk.peek().side==1)
                    stk.push(new Entry(i,1));
                else {
                    stk.pop();
                    if(stk.isEmpty())
                        curLen = i+1;
                    else
                        curLen = i-stk.peek().idx;
                    maxLen = Math.max(maxLen, curLen);
                }
            }
            System.out.println(stk);
        }
        return maxLen;
    }
    public static void main(String[] args){
        String s=")()())()()(";
        System.out.println(longestValidParentheses(s));
    }
}
