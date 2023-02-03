package Dao;

import java.util.List;

import Model.BuildingModel;

public interface BuildingDao {

	List<BuildingModel> findAll();
	List<BuildingModel> findSearch(String names);
}
