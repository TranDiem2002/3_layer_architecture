package Service.impl;

import Dao.BuildingDao;
import Dao.impl.BuildingDaoimpl;
import Dao.xulyDL.BuildingxulyDL;
import Service.BuildingService;
import Service.filter.BuildingFilter;

public class BuildingServiceimpl implements BuildingService{
	private BuildingDao buildingDao;
	
	
	public BuildingServiceimpl() {
		buildingDao = new BuildingDaoimpl();
	}


	public BuildingFilter[] findAll(String name) {
		BuildingxulyDL[] buildingxulyDLs = buildingDao.findAll(name);
		BuildingFilter[] buildingFilters = new BuildingFilter[] {};
		int i = 0;
		for(BuildingxulyDL building : buildingxulyDLs) {
			BuildingFilter buildingFilter = new BuildingFilter();
			buildingFilter.setName(building.getName());
			buildingFilters[i]= buildingFilter;
			i++;
		}
		return buildingFilters;
	}
	
}
