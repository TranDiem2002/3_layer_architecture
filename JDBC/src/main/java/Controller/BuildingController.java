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
	
	public List< BuildingReponse> findSearch(Map<String, Object> map, List<String> types) {
		List<BuildingReponse> buildingModels = buildingService.findSearch(map,types);
		return buildingModels;
	}
}
