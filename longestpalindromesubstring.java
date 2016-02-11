public class longestpalindromesubstring{
	public static int length(String str){
		if(str.length()==0||str==null){
			return 0;
		}
		int len=str.length();
		int[][] dp=new int[len][len];
		for(int i=0;i<str.length();i++){
			dp[i][i]=1;
		}
		for(int l=2;l<=len;l++){
			for(int i=0;i<len-l+1;i++){
				int j=i+l-1;
				if(str.charAt(i)==str.charAt(j)&&l==2){
					dp[i][j]=2;
				}
				else if(str.charAt(i)==str.charAt(j)){
					dp[i][j]=dp[i+1][j-1]+2;
				}
				else{
					dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
				}
			}
		}
		return dp[0][len-1];
	}
	public static int length2(String str){
		if(str==null||str.length()==0){
			return 0;
		}
		int dp[][]=new int[str.length()][str.length()];
		for(int i=0;i<str.length();i++){
			dp[i][i]=1;
		}
		for(int i=1;i<str.length();i++){
			for(int j=i-1;j>=0;j--){
				if(str.charAt(i)==str.charAt(j)&&i-j+1==2){
					dp[j][i]=2;
				}
				else if(str.charAt(i)==str.charAt(j)){
					dp[j][i]=dp[j+1][i-1]+2;
				}
				else{
					dp[j][i]=Math.max(dp[j][i-1],dp[j+1][i]);
				}
			}
			
		}
		return dp[0][str.length()-1];
	}
	public String expand(String s, int l, int r){
	        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
	            l--;
	            r++;
	        }
	        return s.substring(l+1,r);
	    }
	    public String longestPalindromelc(String s) {
	        if(s.length()==0||s==null){
	            return s;
	        }
	        int maxlen=0;
	        String t="";
	        for(int i=0;i<s.length();i++){
	            if(expand(s,i,i+1).length()>maxlen){
	                maxlen=expand(s,i,i+1).length();
	                t=expand(s,i,i+1);
	            }
	        }
	        for(int i=0;i<s.length();i++){
	            if(expand(s,i-1,i+1).length()>maxlen){
	               maxlen=expand(s,i-1,i+1).length();
	                t=expand(s,i-1,i+1); 
	            }
	        }
	        return t;
		}
		public String lpsdp(String s){
			if(s.length()==0||s==null){
			            return s;
			        }
			        boolean[][] dp=new boolean[s.length()][s.length()];
			        int maxlen=0;
			        int start=0;
			        int end=0;
			        String t="";
			        for(int i=0;i<s.length();i++){
			           for(int j=i;j>=0;j--){
			               if((s.charAt(i)==s.charAt(j))&&(i-j<=2||dp[j+1][i-1]==true)){
			                   dp[j][i]=true;
			                   if(maxlen<i-j+1){
			                       maxlen=i-j+1;
			                       start=j;
			                       end=i;
			                   }
			               }
			           }
			        }
			        return s.substring(start,end+1);
		}	
	public static void main(String[] args){
		String str="adpxxda";
		System.out.println(length2(str));
		String a="aasas";
		String b="abc";
		String c=a.replaceAll("[^"+b+"]","");
		System.out.println(c);
	}
}