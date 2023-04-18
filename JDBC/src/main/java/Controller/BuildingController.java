package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;
import Service.BuildingService;
import Service.impl.BuildingServiceimpl;

public class BuildingController {
	BuildingService buildingService;

	public BuildingController() {
		buildingService = new BuildingServiceimpl();
	}
	
	public List< BuildingReponse> findSearch(Map<String, String> map, List<String> types) {
	
	BuildingRequest building = new BuildingRequest();
		building.setName(map.get("name"));
		building.setFloorarea(Integer.parseInt(map.get("floorarea")));
		building.setDistrictid(Long.parseLong(map.get("districtid")));
		building.setWard(map.get("ward"));
		building.setStreet(map.get("street"));
		building.setNumberofbasement(Integer.parseInt(map.get("numberofbasement")));
		building.setDirection(map.get("direction"));
		building.setTypes(types);
		building.setStaff(Integer.parseInt(map.get("staff")));
		building.setLevel(map.get("level"));
		building.setRentarea(map.get("rentarea"));
		building.setManager(map.get("manager"));
		List<BuildingReponse> buildingModels = buildingService.findSearch(building);
		return buildingModels;
	}
}
