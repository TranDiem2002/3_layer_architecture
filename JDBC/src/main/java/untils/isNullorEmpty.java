package untils;

public class isNullorEmpty {
	
	public static boolean check(String value) {
		if(value == null || value.isEmpty() ) {
			return false;
		}
		return true;
	}
	
	public static boolean checkInt(Integer value) {
		if(value == null) {
			return false;
		}
		return true;
	}
}
