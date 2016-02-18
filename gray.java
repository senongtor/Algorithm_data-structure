import java.util.*;

public class gray{
    public static List<Integer> grayCode(int n) {
        List<Integer> re=new ArrayList<Integer>();
        re.add(0);
        for(int i=0;i<n;i++){
			int size=re.size()-1;
            for(int j=0;j<=size;j++){
                re.add((1<<i)|re.get(j));
            }
        }
        return re;
    }
	public static void main(String[] args){
		System.out.println(grayCode(3));
	}
}