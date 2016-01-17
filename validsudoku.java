public class validsudoku{
	public boolean isValidSudoku(char[][] board) {
	        Set<Character> set = new HashSet<Character>();
	        for(int i=0;i<board.length;i++){
	            set.clear();
	            for(char t:board[i]){
	                if(t=='.') continue;
	                if(!set.add(t)) return false;
	            }
	        }
	        for(int i=0;i<board[0].length;i++){
	            set.clear();
	            for(int j=0;j<board.length;j++){
	                if(board[j][i]=='.') continue;
	                if(!set.add(board[j][i])) return false;
	            }
	        }
	        for(int i=0;i<board.length;i+=3){
	            for(int j=0;j<board[0].length;j+=3){
	                set.clear();
	                for(int a=i;a<=i+2;a++){
	                    for(int b=j;b<=j+2;b++){
	                        if(board[a][b]=='.') continue;
	                        if(!set.add(board[a][b])) return false;
	                    }
	                }
	            }
	        }
	        return true;
		}
}