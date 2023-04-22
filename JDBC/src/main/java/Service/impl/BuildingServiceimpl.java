package Service.impl;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;
import Service.BuildingService;
import repository.BuildingRepository;
import repository.DistrictRepository;
import repository.entity.districtEntity;
import repository.entity.buildingEntity;
import repository.impl.BuildingRepositoryimpl;
import repository.impl.DistrictRepositoryimpl;
import untils.isNullorEmpty;

public class BuildingServiceimpl implements BuildingService {
	private BuildingRepository buildingReposiroty;
	private DistrictRepository districtRepository;

	public BuildingServiceimpl() {
		buildingReposiroty = new BuildingRepositoryimpl();
		districtRepository = new DistrictRepositoryimpl();
	}
	

	@Override
	public List<BuildingReponse> findSearch(Map<String, Object> map, List<String> types) {
		List<buildingEntity> building = new ArrayList<>();
		List<BuildingReponse> buildings = new ArrayList<>();
		building = buildingReposiroty.findSearch(map, types);
		for (buildingEntity b : building) {
			BuildingReponse buildingReponse = new BuildingReponse();
			buildingReponse.setId(b.getId());
			buildingReponse.setName(b.getName());
			districtEntity district = districtRepository.findDistrictID(b.getDistrictid());
			buildingReponse.setAddress(b.getStreet() +", "+b.getWard()+", "+district.getNameDistrict());
			buildingReponse.setFloorarea(b.getFloorarea());
			buildingReponse.setRentprice(b.getRentprice());
			buildingReponse.setServicefree(b.getServicefee());
			buildingReponse.setBrokeragefree(b.getBrokeragefee());
			buildingReponse.setNumberofbasement(b.getNumberofbasement());
			buildings.add(buildingReponse);
		}

		return buildings;
	}

}
