import java.util.*;
public class MineSweeper {
    public static int countMines(int x,int y,char[][] board){
        int count=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(x+i>=0 && x+i<board.length && y+j>=0 && y+j<board[0].length){
                    if(board[x+i][y+j]=='M'){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void dfs(int i,int j,char[][] board,boolean[][] visited){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return;
        }
        if(visited[i][j]){
          return;
        }
        visited[i][j]=true;
        int minesCount=countMines(i,j,board);
        if(minesCount>0){
            board[i][j]=(char)(minesCount + '0');
            return;
        }

        board[i][j]='B';
        dfs(i-1,j,board,visited);
        dfs(i-1,j-1,board,visited);
        dfs(i-1,j+1,board,visited);
        dfs(i,j-1,board,visited);
        dfs(i,j+1,board,visited);
        dfs(i+1,j-1,board,visited);
        dfs(i+1,j+1,board,visited);
        dfs(i+1,j,board,visited);
    }
    public static char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0 || board[0].length==0){
            return board;
        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        dfs(click[0],click[1],board,visited);
        return board;
    }
    public static void main(String[] args){
        // char[][] m=new char[][]{{'E', 'E', 'E', 'E', 'E'},
        //                     {'E', 'E', 'M', 'E', 'E'},
        //                     {'E', 'E', 'E', 'E', 'E'},
        //                     {'E', 'E', 'E', 'E', 'E'}};
        char[][] m=new char[][]{{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
                                {'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'},
                                {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                                {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'}};
        int[] click=new int[]{0,0};
        System.out.println(Arrays.deepToString(updateBoard(m,click)));
    }
}
