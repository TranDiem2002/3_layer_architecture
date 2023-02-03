package Dao;

import java.util.List;

import Dao.xulyDL.BuildingxulyDL;

public interface BuildingDao {

	List<BuildingxulyDL> findAll();
	List<BuildingxulyDL> findSearch(String names);
}
