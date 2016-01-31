import java.util.*;
public class frog{
	public static int solution(int[] A,int N, int X, int D){
		if(D>=X||D>=X+A[0]){
			return 0;
		}
		LinkedList<Integer> deque = new LinkedList<Integer>();
		        int[] pos = new int[X + 1];
				Arrays.fill(pos,-1);
		        pos[0] = 0;
		        pos[X] = 0;

		        for (int i = 0; i < A.length; i++) {
		            if (pos[A[i]] == -1) {
		                pos[A[i]] = i;
		            }
		        }
                System.out.println(Arrays.toString(pos));
		        int[] DP = new int[X + 1];
		        DP[0] = 0;
		        deque.add(0);
		        for (int i = 1; i <= X; i++) {
		            while (!deque.isEmpty() && deque.getFirst() + D < i) {
		                deque.removeFirst();
		            }
		            if (pos[i] == -1 || deque.isEmpty()) {
		                DP[i] = -1;
		                continue;
		            }
		            DP[i] = Math.max(pos[i], DP[deque.getFirst()]);

		            while (!deque.isEmpty() && DP[deque.getLast()] >= DP[i])
		            {
		                deque.removeLast();
		            }
		            deque.addLast(i);
					
					System.out.println(Integer.toString(i)+Integer.toString(DP[i])+deque.toString());
		        }
		        return DP[X];
	}
	public static void main(String[] args){
		int[] A=new int[]{1,3,1,4,2,5};
		int X=7;
		int D=3;
		
		System.out.println(solution(A,A.length,X,D));
			
	}
 
}