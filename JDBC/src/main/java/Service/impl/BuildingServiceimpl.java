package Service.impl;

import java.util.ArrayList;
import java.util.List;

import Dao.BuildingDao;
import Dao.impl.BuildingDaoimpl;
import DaoBuildingData.BuildingData;
import Model.BuildingModel;
import Service.BuildingService;
import untils.buildingTypes;

public class BuildingServiceimpl implements BuildingService {
	private BuildingDao buildingDao;

	public BuildingServiceimpl() {
		buildingDao = new BuildingDaoimpl();
	}

	@Override
	public List<BuildingModel> findAll() {
		List<BuildingData> buildingDatas = buildingDao.findAll();
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingData buildingData : buildingDatas) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(buildingData.getName());
			buildingModel.setNumberofbasement(buildingData.getNumberofbasement());
			buildingModel.setFloorerea(buildingData.getFloorerea());
			buildingModel.setStreet(buildingData.getStreet());
			buildingModel.setTypes(buildingTypes.checkTypes(buildingData.getTypes()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

	@Override
	public List<BuildingModel> findSearch(String name) {
		List<BuildingData> buildingDatas = buildingDao.findSearch(name);
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingData buildingData : buildingDatas) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(buildingData.getName());
			buildingModel.setNumberofbasement(buildingData.getNumberofbasement());
			buildingModel.setFloorerea(buildingData.getFloorerea());
			buildingModel.setStreet(buildingData.getStreet());
			buildingModel.setTypes(buildingTypes.checkTypes(buildingData.getTypes()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

}
