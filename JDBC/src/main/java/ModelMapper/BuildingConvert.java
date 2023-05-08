package ModelMapper;

import org.modelmapper.ModelMapper;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;
import repository.entity.buildingEntity;
import repository.entity.districtEntity;

public class BuildingConvert {
	ModelMapper mapper = new ModelMapper();

	public buildingEntity convertToEntity(BuildingRequest building) {
		buildingEntity b = mapper.map(building, buildingEntity.class);
		return b;
	}

	public BuildingReponse convertToReponse(buildingEntity building) {
		BuildingReponse b = mapper.map(building, BuildingReponse.class);
		return b;
	}

	public BuildingReponse convert(buildingEntity b, String nameDistrict) {
		String address = b.getStreet() +", "+ b.getWard()+", "+ nameDistrict;
		
		BuildingReponse building = mapper.map(b, BuildingReponse.class);
		building.setAddress(address);
		return building;
	}
	
}
