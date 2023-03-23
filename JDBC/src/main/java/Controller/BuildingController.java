package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.BuildingModel;
import Service.BuildingService;
import Service.impl.BuildingServiceimpl;

public class BuildingController {
	BuildingService buildingService;

	public BuildingController() {
		buildingService = new BuildingServiceimpl();
	}
	
	public List< BuildingModel> findAll() {
		List<BuildingModel> buildingModels = buildingService.findAll();
		return buildingModels;
	}
	
	public List< BuildingModel> findSearch(String name,Integer floorArea,Long districtid, 
			String street, Integer numberofbasement, String direction, Integer level,String ward) {
	
		BuildingModel building = new BuildingModel();
		building.setName(name);
		building.setFloorarea(floorArea);
		building.setDistrictid(districtid);
		building.setStreet(street);
		building.setNumberofbasement(numberofbasement);
		building.setDirection(direction);
		building.setLevel(level);
		building.setward(ward);
		//building.setTypes(types);
		List<BuildingModel> buildingModels = buildingService.findSearch(building);
		return buildingModels;
	}
}
