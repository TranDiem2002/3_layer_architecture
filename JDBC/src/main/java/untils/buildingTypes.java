package untils;

import java.util.ArrayList;

import constant.SystemConstant;

public class buildingTypes {

	//C1: 
	public static String checkTypes(String types) {
		StringBuilder buildingTypes = new StringBuilder();
		String[] type = types.split(",");
		int n = type.length;
		for (int i = 0; i < n; i++) {
			if (type[i].equalsIgnoreCase(SystemConstant.nguyencanCode)) {
				type[i] = SystemConstant.nguyencanName;
			}
			if (type[i].equalsIgnoreCase(SystemConstant.noithatCode)) {
				type[i] = SystemConstant.noithatName;
			}
			if (type[i].equalsIgnoreCase(SystemConstant.tangtretCode)) {
				type[i] = SystemConstant.tangtretName;
			}
			if (i >= 0 && i < n - 1) {
				buildingTypes.append(type[i] + ",");
			} else {
				buildingTypes.append(type[i]);
			}
		}
		return buildingTypes.toString();
	}

	//C2: check sử dụng Map
	public static String checkTypebuilding(String types) {

		StringBuilder buildingTypes = new StringBuilder();
		String[] type = types.split(",");
		int n = type.length;
		for (int i = 0; i < n; i++) {
			type[i] = SystemConstant.building_types.get(type[i]);
			if (i >= 0 && i < n - 1) {
				buildingTypes.append(type[i] + ",");
			} else {
				buildingTypes.append(type[i]);
			}
		}
		return buildingTypes.toString();
	}

}



//C3: 
/*
 * List<String> typesBuilding = new ArrayList<> ();
 * String[] types = type.split(",");
 * int n = types.length();
 * for(int i=0; i< n ; i++){
 *  String name = SystemConstrant.building_types.get(types[i])
 *  typesBuilding.add(name);
	 // su dung enum:
	  * typesBuilding.add(BuildingEnum.valueOf(types[i].getTypesName()));
 * }
 * return String.join(",",typesBuilding)
 * 
 */
