package Controller;

import Model.BuildingModel;
import Service.BuildingService;
import Service.filter.BuildingFilter;
import Service.impl.BuildingServiceimpl;

public class BuildingController {
	BuildingService buildingService;

	public BuildingController() {
		buildingService = new BuildingServiceimpl();
	}
	
	public BuildingModel[] findAll(String name) {
		BuildingFilter[] buildingFilters = buildingService.findAll(name);
		BuildingModel[] buildingModels = new BuildingModel[] {};
		int i=0;
		for(BuildingFilter building : buildingFilters) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(building.getName());
			buildingModels[i] = buildingModel;
			i++;
		}
		return buildingModels;
	}
}
