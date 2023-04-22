package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.BuildingRequest.BuildingRequest;
import repository.entity.districtEntity;
import repository.entity.buildingEntity;

public interface BuildingRepository {
	List<buildingEntity> findSearch(Map<String, Object> map, List<String> types);
}
