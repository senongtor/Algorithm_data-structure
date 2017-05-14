import java.util.*;
public class SentenceScreenFit {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        if(rows==0||cols==0||sentence.length==0){
            return 0;
        }
        if(sentence.length>rows*cols){
            return 0;
        }
        int idx=0;
        int total=0;
        for(int i=0;i<rows;i++){
            int len=0;
            String s="";
            while(true){
                if(len+sentence[idx].length()+1<=cols){
                    len=len+sentence[idx].length()+1;
                    s+=sentence[idx]+" ";
                    total=total+1;
                    idx=(total)%sentence.length;
                }else if(cols-len==sentence[idx].length()){
                    len=len+sentence[idx].length();
                    s+=sentence[idx];
                    total=total+1;
                    idx=(total)%sentence.length;
                }else{
                    break;
                }
            }
        }
        return (total)/sentence.length;
    }

    public static void main(String[] args){
        //rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
        String[] sentence=new String[]{"a", "bcd", "e"};
        int rows=3;
        int cols=6;
        System.out.println(wordsTyping(sentence,rows,cols));
    }
}
