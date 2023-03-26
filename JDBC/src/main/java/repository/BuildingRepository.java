package repository;

import java.util.List;

import Model.BuildingRequest.BuildingRequest;
import repository.entity.Building_entity;

public interface BuildingRepository {

	List<Building_entity> findSearch(BuildingRequest building);
}
