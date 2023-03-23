package repository;

import java.util.List;

public interface renttype {

	List<Long> findIdTypes (String code);
	List<Long> findIdBuilding(List<Long> idTypes);
}