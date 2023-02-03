package Service;

import java.util.List;

import Model.BuildingModel;


public interface BuildingService {

	List<BuildingModel> findAll();
	List<BuildingModel> findSearch(String name);
}
