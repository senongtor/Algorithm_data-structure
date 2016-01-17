//Factory pattern
interface Shape{
   public void draw();	
}
class Rec implements Shape{
	@Override
   public void draw(){
	   System.out.println("It's a rectangle");
   }
}
class Tri implements Shape{
	@Override
	public void draw(){
		System.out.println("It's a triangle");
	}
}

class shapefac{
	private String type;
	public shapefac(){}
	public Shape getshape(String type){
		if(type==null){
			return null;
		}
		if(type.equalsIgnoreCase("Rectangle")){
			return new Rec();
		}
		if(type.equalsIgnoreCase("Triangle")){
			return new Tri();
		}
		return null;
	}
}
//template pattern
abstract class Game{
	abstract void initialize();
	abstract void startplay();
	abstract void endplay();
	
	public final void play(){
		initialize();
		startplay();
		endplay();
	}
}
class Football extends Game{
	public Football(){}
	   @Override
	   void endplay() {
	      System.out.println("Football Game Finished!");
	   }

	   @Override
	   void initialize() {
	      System.out.println("Football Game Initialized! Start playing.");
	   }

	   @Override
	   void startplay() {
	      System.out.println("Football Game Started. Enjoy the game!");
	   }
}
public class designpatter{
	public static void main(String[] args){
    //factory call
	shapefac fac=new shapefac();
	Shape triangle=fac.getshape("Triangle");
	triangle.draw();
	
	//template call
	Game game=new Football();
	game.play();
	System.out.println();
}

}