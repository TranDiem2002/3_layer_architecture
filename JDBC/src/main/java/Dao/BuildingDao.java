package Dao;

import java.util.List;

import Dao.BuildingEntity.BuildingEntity;
import Model.BuildingModel;

public interface BuildingDao {

	List<BuildingEntity> findAll();
	List<BuildingEntity> findSearch(BuildingModel building);
}
