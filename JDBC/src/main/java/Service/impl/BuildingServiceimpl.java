package Service.impl;

import java.util.ArrayList;
import java.util.List;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;
import Service.BuildingService;
import repository.BuildingRepository;
import repository.entity.Building_entity;
import repository.impl.BuildingRepositoryimpl;



public class BuildingServiceimpl implements BuildingService {
	private BuildingRepository buildingReposiroty;
	
	
	public BuildingServiceimpl() {
		buildingReposiroty = new BuildingRepositoryimpl();
		
	}
	
	@Override
	public List<BuildingReponse> findSearch(BuildingRequest building) {
		List<BuildingReponse> buildingReponses = new ArrayList<>();
		List<Building_entity> building_entities = buildingReposiroty.findSearch(building);
		for(Building_entity building_entity: building_entities) {
			BuildingReponse buildingReponse2 = new BuildingReponse();
			buildingReponse2.setId(building_entity.getId());
			buildingReponse2.setName(building_entity.getName());
			buildingReponse2.setAddress(building_entity.getStreet()+", "+building_entity.getWard() +", "+building_entity.getDistrictName());
			buildingReponse2.setRentprice(building_entity.getRentprice());
			buildingReponse2.setServicefree(building_entity.getServicefee());
			buildingReponse2.setBrokeragefree(building_entity.getBrokeragefee());
			buildingReponse2.setNumberofbasement(building_entity.getNumberofbasement());
			buildingReponses.add(buildingReponse2);
		}

		return buildingReponses;
	}
	
	


}
