package repository;

import repository.entity.districtEntity;

public interface DistrictRepository {
	districtEntity findDistrictID(Long id);
}
