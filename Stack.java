import java.util.*;
public class Stack<T>{
  @SuppressWarnings("unchecked")
  private T[] arr;
  private int size=10;
  private int head=-1;
  public Stack(){
    arr=(T[])new Object[size];
  }
  public Stack(int val){
    arr=(T[])new Object[val];
    size=val;
  }
  public void push(T val){
    if(this.size()==size){
      T[] tmp=(T[])new Object[2*size];
      for(int i=0;i<this.size();i++){
        tmp[i]=arr[i];
      }
      this.arr=tmp;
      size=20;
    }
    head++;
    arr[head]=val;
  }
  public T poll(){
    if(this.isEmpty()){
      throw new EmptyStackException();
    }
    T p=arr[head];
    head--;
    return p;
  }
  public T peek(){
    if(this.isEmpty()){
      throw new EmptyStackException();
    }
    return arr[head];
  }
  public int size(){
    return head+1;
  }
  public boolean isEmpty(){
    return head==-1;
  }
  public static void main(String[] args){
    Stack<Integer> s=new Stack<Integer>();
    for(int i=0;i<10;i++){
      s.push(i);
    }
    // s.push(1);
    System.out.println(s.peek());
    s.push(10);
    System.out.println(s.size);
    // //s.poll();
    // Single s=Single.getInstance();
    // s.showMessage();
    int[] arr=new int[]{1,2,3,1,12,20,4,35,14};
    quicksort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
}
