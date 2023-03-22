package Model;

public class BuildingModel {

	private String name;
	private Integer numberofbasement;
	private String street;
	private long districtid;
	private String ward;
	private String district;
	private String direction;
	private Integer floorarea;
	private Integer level;
	private String types;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberofbasement() {
		return numberofbasement;
	}

	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}

	public Integer getfloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Long getDistrictid() {
		return districtid;
	}

	public void setDistrictid(long districtid) {
		this.districtid = districtid;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getward() {
		return ward;
	}

	public void setward (String ward) {
		this.ward =  ward;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}


	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
}
