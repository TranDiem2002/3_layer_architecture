package untils;

import java.util.ArrayList;
import java.util.List;

public class SplitString {

	public static List<String> sp(String st){
		String[] array = st.split(",");
		List<String> typeBuilding = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			typeBuilding.add(array[i]);
		}
		return typeBuilding;
	}
}
