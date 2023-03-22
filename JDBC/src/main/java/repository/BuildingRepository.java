package repository;

import java.util.List;

import Model.BuildingModel;
import repository.entity.BuildingEntity;

public interface BuildingRepository  extends JpaRepository<BuildingEntity>{

	List<BuildingEntity> findSearch(BuildingModel building);
}
