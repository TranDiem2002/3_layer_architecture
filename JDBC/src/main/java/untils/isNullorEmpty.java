package untils;

public class isNullorEmpty {

	public static boolean check(String value) {
		if( value.isEmpty() && value == null) {
			return false;
		}
		return true;
	}
}
