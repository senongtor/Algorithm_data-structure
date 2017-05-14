import java.util.*;
class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode(){
        children=new TrieNode[26];
    }
}
class Trie{
    TrieNode root;
    public Trie(){
      root=new TrieNode();
    }
    public void insert(String s){
        TrieNode curr=root;
        for(char c:s.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isWord=true;
    }
    public boolean startsWith(String s){
        TrieNode curr=root;
        for(char c:s.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return true;
    }
    public boolean search(String s){
        TrieNode curr=root;
        for(char c:s.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return curr.isWord;
    }
}
public class WordSearchTrie {
    public static void dfs(List<String> re,char[][] board,boolean[][] visited,Trie trie,int i,int j,String s){
        if(i>=board.length || i<0 || j>=board[0].length || j<0){
            return;
        }
        if(visited[i][j]){
            return;
        }
        s=s+board[i][j];
        if(!trie.startsWith(s)){
            return;
        }
        if(trie.search(s)){
            re.add(s);
        }
        visited[i][j]=true;
        dfs(re,board,visited,trie,i+1,j,s);
        dfs(re,board,visited,trie,i-1,j,s);
        dfs(re,board,visited,trie,i,j+1,s);
        dfs(re,board,visited,trie,i,j-1,s);
        visited[i][j]=false;
    }
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> re=new ArrayList<String>();
        if(board.length==0 || board[0].length==0 || words.length==0){
            return re;
        }
        int rows=board.length;
        int cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];
        Trie trie=new Trie();
        for(String w:words){
            trie.insert(w);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(re,board,visited,trie,i,j,"");
            }
        }
        return re;
    }
    public static void main(String[] args){
      char[][] board=new char[][]{{'o','a','a','n'},
                                  {'e','t','a','e'},
                                  {'i','h','k','r'},
                                  {'i','f','l','v'}};
      String[] words=new String[]{"oath","pea","eat","rain"};
      System.out.println(findWords(board,words));
    }
}
