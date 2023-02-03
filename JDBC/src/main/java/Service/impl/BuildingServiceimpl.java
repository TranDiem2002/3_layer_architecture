package Service.impl;

import java.util.ArrayList;
import java.util.List;

import Dao.BuildingDao;
import Dao.impl.BuildingDaoimpl;
import Model.BuildingModel;
import Service.BuildingService;

public class BuildingServiceimpl implements BuildingService {
	private BuildingDao buildingDao;

	public BuildingServiceimpl() {
		buildingDao = new BuildingDaoimpl();
	}

	public List<BuildingModel> findAll() {
		return buildingDao.findAll();
	}

	@Override
	public List<BuildingModel> findSearch(String name) {
		return buildingDao.findSearch(name);
	}

}
