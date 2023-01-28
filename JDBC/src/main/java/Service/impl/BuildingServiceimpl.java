package Service.impl;

import java.util.ArrayList;
import java.util.List;

import Dao.BuildingDao;
import Dao.impl.BuildingDaoimpl;
import Dao.xulyDL.BuildingxulyDL;
import Model.BuildingModel;
import Service.BuildingService;


public class BuildingServiceimpl implements BuildingService{
	private BuildingDao buildingDao;
	
	
	public BuildingServiceimpl() {
		buildingDao = new BuildingDaoimpl();
	}


	public List<BuildingModel> findAll(String name) {
		List<BuildingxulyDL> buildingxulyDLs = buildingDao.findAll(name);
		List<BuildingModel> buildingModels = new ArrayList<>();
		for(BuildingxulyDL building : buildingxulyDLs) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(building.getName());
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}
	
}
