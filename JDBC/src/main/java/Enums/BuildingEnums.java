package Enums;

public enum BuildingEnums {
	tang_tret ("tầng trệt"),
	nguyen_can("nguyên căn"),
	noi_that ("nội thất");
	
	private  String typeName;
	
	private BuildingEnums (String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

}
