package constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes.Name;

import untils.buildingTypes;

public class SystemConstant {

	public final static String tangtretCode = "tang-tret";
	public final static String tangtretName = "tầng trệt";
	public final static String nguyencanCode = "nguyen-can";
	public final static String nguyencanName = "nguyên căn";
	public final static String noithatCode = "noi-that";
	public final static String noithatName = "nội thất";
	
	public final static Map<String, String> building_types;
	static {
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("tang-tret","tầng trệt");
		m1.put("nguyen-can","nguyên căn");
		m1.put("noi-that","nội thất");
		building_types = Collections.unmodifiableMap(m1);
	}

}
