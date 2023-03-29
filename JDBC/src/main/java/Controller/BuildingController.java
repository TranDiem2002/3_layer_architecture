package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;
import Service.BuildingService;
import Service.impl.BuildingServiceimpl;

public class BuildingController {
	BuildingService buildingService;

	public BuildingController() {
		buildingService = new BuildingServiceimpl();
	}
	
	public List< BuildingReponse> findSearch(String name,Integer floorArea,Long districtid, 
			String street, Integer numberofbasement, String direction, String level,String ward, String types, String rentArea,
			String manager, Integer staff ) {
	
	BuildingRequest building = new BuildingRequest();
		building.setName(name);
		building.setFloorarea(floorArea);
		building.setDistrictid(districtid);
		building.setWard(ward);
		building.setStreet(street);
		building.setNumberofbasement(numberofbasement);
		building.setDirection(direction);
		building.setTypes(types);
		building.setStaff(staff);
		building.setLevel(level);
		building.setRentarea(rentArea);
		building.setManager(manager);
		List<BuildingReponse> buildingModels = buildingService.findSearch(building);
		return buildingModels;
	}
}
