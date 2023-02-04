package Dao;

import java.util.List;

import DaoBuildingData.BuildingData;
import Model.BuildingModel;

public interface BuildingDao {

	List<BuildingData> findAll();
	List<BuildingData> findSearch(String names);
}
