public class <T> mystack{
    protected Object[] arr;
	protected size;
	protected top;
	public mystack(){
		this.arr=new Object[10];
		this.top=-1;
	}
	public mystack(int size){
		this.size=size;
		this.arr=new Object[size];
		this.top=-1;
	}
    public void push(Object o){
    	if(this.top>size){
    		System.out.println("Stack Overflow!");
    	}
		else{
			this.top+=1;
			this.arr[this.top]=o;
		}
    }
	public void pop(){
		if(isEmpty() == true){
				System.out.println("Stack Underflow!");
		}
		else{
			this.top-=1;
			return this.array[this.top+1];
		}
	}
	public Object peek(){
		if(isEmpty() == true){
				System.out.println("Stack Empty.");
				return null;
		}
		else{
		return this.arr[this.top];
    	}
	}
	public boolean isEmpty(){
		return this.top=-1;
	}
	public static void main(String[] args){
		mystack s=new mystack();
		s.push()
	}			
}