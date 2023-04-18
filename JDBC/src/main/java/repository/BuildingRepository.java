package repository;

import java.util.List;

import Model.BuildingRequest.BuildingRequest;
import repository.entity.DistrictEntity;
import repository.entity.buildingEntity;

public interface BuildingRepository {

	List<buildingEntity> findSearch(BuildingRequest building);
	List<DistrictEntity> nameDistrict ();
}
