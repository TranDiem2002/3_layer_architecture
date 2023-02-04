package untils;

import java.util.ArrayList;

import constant.SystemConstant;

public class buildingTypes {

	public static String checkTypes(String types) {
		StringBuilder buildingTypes = new StringBuilder();
		String[] type = types.split(",");
		int n = type.length;
		for (int i =0; i<n; i++) {
			if(type[i].equalsIgnoreCase(SystemConstant.nguyencanCode)) {
				type[i] = SystemConstant.nguyencanName;
			}
			if(type[i].equalsIgnoreCase(SystemConstant.noithatCode)) {
				type[i] =  SystemConstant.noithatName;
			}
			if(type[i].equalsIgnoreCase(SystemConstant.tangtretCode)) {
				type[i] = SystemConstant.tangtretName;
			}
			if(i>=0 &&i<n-1 ) {
				buildingTypes.append(type[i]+ "," );
			}
			else {
				buildingTypes.append(type[i]);
			}
		}
		return buildingTypes.toString();
	}
	
}
