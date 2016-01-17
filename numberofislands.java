import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class numberofislands{
	//2-d
	public void bfs(char[][] grid, int i, int j){
	        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1){
	            return;
	        }
        
	        if(grid[i][j]=='0'){
	            return;
	        }
	        grid[i][j]='0';
	        bfs(grid,i,j-1);
	        bfs(grid,i-1,j);
	        bfs(grid,i+1,j);
	        bfs(grid,i,j+1);
	    }
	    public int numIslands(char[][] grid) {
	        if(grid.length==0||grid[0].length==0||grid==null){
	            return 0;
	        }
	        int count=0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]=='1'){
	                    bfs(grid,i,j);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
		
		//1-d "00101001"
		public static int nofi1(String s){
			s=s.replaceAll("(0+)",",");
			String[] r=s.split(",");
			int count=0;
			for(int i=0;i<r.length;i++){
				if(r[i].equals("1"))
				count++;
			}
			return count;
		}
		public static int nofi2(String s){
		    String pattern="(1+)";
		    Pattern p=Pattern.compile(pattern);
		    Matcher m=p.matcher(s);
		    int count=0;
		    if(m.find()){
			    count++;
		    }
		    return count;
	    }
	public static int nofi3(String s){
		int count=0;
		if(s.charAt(0)=='1'){
			count=1;
		}
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)=='1'){
				if(s.charAt(i-1)=='0'){
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args){
		String s="00101001";
		System.out.println(nofi3(s));
	}
}