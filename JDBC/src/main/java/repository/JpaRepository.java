package repository;

import java.util.List;

import Model.BuildingModel;
import repository.entity.BuildingEntity;

public interface JpaRepository<T> {

	List<T> findAll();
	
}
