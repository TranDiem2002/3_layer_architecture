package Service.impl;

import java.util.ArrayList;
import java.util.List;

import Dao.BuildingEntity.BuildingEntity;
import Dao.impl.BuildingDaoimpl;
import Dao.BuildingDao;
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
		List<BuildingEntity> buildingDatas = buildingDao.findAll();
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingEntity buildingData : buildingDatas) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(buildingData.getName());
			buildingModel.setNumberofbasement(buildingData.getNumberofbasement());
			buildingModel.setFloorerea(buildingData.getFloorerea());
			buildingModel.setStreet(buildingData.getStreet());
			buildingModel.setTypes(buildingTypes.checkTypebuilding(buildingData.getTypes()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}

	@Override
	public List<BuildingModel> findSearch(BuildingModel building) {
		List<BuildingEntity> buildingDatas = buildingDao.findSearch(building);
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingEntity buildingData : buildingDatas) {
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
