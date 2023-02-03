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
	
	public List< BuildingModel> findSearch(String name) {
		List<BuildingModel> buildingModels = buildingService.findSearch(name);
		return buildingModels;
	}
}
