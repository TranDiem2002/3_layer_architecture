package Model.BuildingReponse;

import java.sql.Date;

public class BuildingReponse {

	private Long id;
	private String name;
	private String address;
	private Integer floorarea;
	private Integer rentprice;
	private String servicefree;
	private String brokeragefree;
	private Integer numberofbasement;
	private Date createddate;
	private Date modifieddate;
	private String createdby;
	private String modifiedby;
	private String rentarea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public Integer getRentprice() {
		return rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	public String getServicefree() {
		return servicefree;
	}

	public void setServicefree(String servicefree) {
		this.servicefree = servicefree;
	}

	public String getBrokeragefree() {
		return brokeragefree;
	}

	public void setBrokeragefree(String brokeragefree) {
		this.brokeragefree = brokeragefree;
	}

	public Integer getNumberofbasement() {
		return numberofbasement;
	}

	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getRentarea() {
		return rentarea;
	}

	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
	}
}
