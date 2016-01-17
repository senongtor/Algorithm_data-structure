// cc150 check a string is a rotation of another eg:“waterbottle” is a rotation of “erbottlewat” using the given method isSubstring once;
public class stringrotation{
	public boolean check(String s1, String s2){
		s1=s1+s1;
		if(s2.isSubstring(s1)){
			return true;
		}
		return false;
	}
}