package Service;

import java.util.List;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;


public interface BuildingService {

	List<BuildingReponse> findSearch(BuildingRequest building);
}
