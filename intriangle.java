//check if a point is in triangle
class point{
	int x;
	int y;
	point(int a,int b){
		this.x=a;
		this.y=b;
	}
	public boolean equals(point m){
		if(x==m.x&&y==m.y){
			return true;
		}
		return false;
	}
}
public class intriangle{
	public static int crossproduct(point a,point b){
		return a.x*b.y-a.y*b.x;
	}
	
	
    public static boolean intriangle(point a, point b, point c, point p){
		if(p.equals(a)||p.equals(b)||p.equals(c)){
			return false;
		}
    	point ab=new point(b.x-a.x,b.y-a.y);
		point bc=new point(c.x-b.x,c.y-b.y);
		point ca=new point(a.x-c.x,a.y-c.y);
		point ap=new point(p.x-a.x,p.y-a.y);
		point bp=new point(p.x-b.x,p.y-b.y);
		point cp=new point(p.x-c.x,p.y-c.y);
		
		int r1=crossproduct(ab,ap);
		int r2=crossproduct(bc,bp);
		if(r2/r1<0){
			return false;
		}
		int r3=crossproduct(ca,cp);
		if(r3/r1<0){
			return false;
		}
		return true;
    }
    public static void main(String[] args){
    	point a=new point(1,2);
		point b=new point(2,0);
		point c=new point(3,1);
		
		point p=new point(2,0);
		System.out.println(intriangle(a,b,c,p));
    }
}