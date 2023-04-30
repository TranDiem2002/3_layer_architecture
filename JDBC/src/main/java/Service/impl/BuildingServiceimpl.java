package Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.modelmapper.ModelMapper;

import Model.BuildingReponse.BuildingReponse;
import ModelMapper.baseMapper;
import Service.BuildingService;
import repository.BuildingRepository;
import repository.DistrictRepository;
import repository.entity.buildingEntity;
import repository.impl.BuildingRepositoryimpl;
import repository.impl.DistrictRepositoryimpl;

public class BuildingServiceimpl implements BuildingService {
	private BuildingRepository buildingReposiroty;
	private DistrictRepository districtRepository;
	private final ModelMapper mapper;

	public BuildingServiceimpl() {
		buildingReposiroty = new BuildingRepositoryimpl();
		districtRepository = new DistrictRepositoryimpl();
		mapper = new ModelMapper();
	}
	

	@Override
	public List<BuildingReponse> findSearch(Map<String, Object> map, List<String> types) {
		List<buildingEntity> building = buildingReposiroty.findSearch(map, types);
		List<BuildingReponse> buildings = new ArrayList<>();
		buildings = (List<BuildingReponse>) mapper.map(building, BuildingReponse.class);
		
		return buildings;
	}

}
