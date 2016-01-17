public class GenParen{
 public List<String> generateParenthesis(int n) {
        List<String> re=new LinkedList<String>();
        if(n<=0){
            return re;
        }
        String tmp="";
        helper(0,0,n,tmp,re);
        return re;
    }
    public void helper(int l, int r, int n, String tmp, List<String> re){
        if(l+r==2*n){
            re.add(tmp);
            return;
        }
        if(l<n){
            helper(l+1,r,n,tmp+"(",re);
        }
        if(l>r){
            helper(l,r+1,n,tmp+")",re);
        }
    }
}