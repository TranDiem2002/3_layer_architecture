package Service.impl;

import java.util.ArrayList;
import java.util.List;

import Model.BuildingModel;
import Service.BuildingService;
import repository.BuildingRepository;
import repository.DistrictRepository;
import repository.renttype;
import repository.entity.BuildingEntity;
import repository.impl.BuildingRepositoryimpl;
import repository.impl.DistrictRepositoryImpl;
import repository.impl.renttypeImpl;
import untils.buildingTypes;
import untils.isNullorEmpty;


public class BuildingServiceimpl implements BuildingService {
	private BuildingRepository buildingReposiroty;
	private DistrictRepository districtRepository;
	private renttype renttype;
	
	public BuildingServiceimpl() {
		buildingReposiroty = new BuildingRepositoryimpl();
		districtRepository= new DistrictRepositoryImpl();
		renttype = new renttypeImpl();
	}

	@Override
	public List<BuildingModel> findAll() {
		List<BuildingEntity> buildingDatas =buildingReposiroty.findAll();
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingEntity buildingData : buildingDatas) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(buildingData.getName());
			buildingModel.setNumberofbasement(buildingData.getNumberofbasement());
			buildingModel.setFloorarea(buildingData.getFloorarea());
			buildingModel.setStreet(buildingData.getStreet());
		//	buildingModel.setTypes(buildingTypes.checkTypebuilding(buildingData.getTypes()));
			buildingModels.add(buildingModel);
		}
		return buildingModels;
	}
	
	public List<Long> findIdBuilding(String types){
		List<Long> idTypes = renttype.findIdTypes(types);
		List<Long> idBuilding = new ArrayList<>();
		if(idTypes.size()>0) {
			 idBuilding = renttype.findIdBuilding(idTypes);
		}
		return idBuilding;
	}
	
	@Override
	public List<BuildingModel> findSearch(BuildingModel buildingModel) {
		List<BuildingEntity> buildingEntities = new ArrayList<>();

	  buildingEntities = buildingReposiroty.findSearch(buildingModel);

		List<BuildingModel> buildingModels = new ArrayList<>();
		for(BuildingEntity buildingEntity: buildingEntities) {
			BuildingModel buildingModel2 = new BuildingModel();
			buildingModel2.setName(buildingEntity.getName());
			buildingModel2.setFloorarea(buildingEntity.getFloorarea());
			buildingModel2.setDistrict(districtRepository.findName(buildingEntity.getDistrictid()));
			buildingModel2.setStreet(buildingEntity.getStreet());
			buildingModel2.setNumberofbasement(buildingEntity.getNumberofbasement());
			buildingModel2.setDirection(buildingEntity.getDirection());
			buildingModel2.setLevel(buildingEntity.getLevel());
			buildingModel2.setward(buildingEntity.getward());
			//buildingModel2.setTypes(buildingTypes.checkTypebuilding(types));
			buildingModels.add(buildingModel2);
		}

		return buildingModels;
	}
	


}
