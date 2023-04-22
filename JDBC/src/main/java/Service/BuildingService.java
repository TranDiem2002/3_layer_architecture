package Service;

import java.util.List;
import java.util.Map;

import Model.BuildingReponse.BuildingReponse;


public interface BuildingService {

	List<BuildingReponse> findSearch(Map<String, Object> map, List<String> types);
}
