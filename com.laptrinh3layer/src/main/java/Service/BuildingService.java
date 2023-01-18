package Service;

import Service.filter.BuildingFilter;

public interface BuildingService {

	BuildingFilter[] findAll(String name);
}
