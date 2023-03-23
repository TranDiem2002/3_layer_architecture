package repository.entity;

import repository.annotation.Column;
import repository.annotation.Entity;
import repository.annotation.Table;

@Entity  // chuyển class buildingEntity thành class đặc biệt giống như building dưới data
@Table(name = "building")  // tên tương ứng với bảng dưới database
public class BuildingEntity {
	
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "numberofbasement")
	private Integer numberofbasement;
	
	@Column(name = "floorarea")
	private Integer floorarea;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "districtid")
	private Long districtid;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "direction")
	private String direction;
	
	
	@Column(name = "level")
	private Integer level;
	
	
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

	public Integer getFloorarea() {
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

	public Long getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Long district) {
		this.districtid = district;
	}

	public String getward() {
		return ward;
	}

	public void setward(String ward) {
		this.ward = ward;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
