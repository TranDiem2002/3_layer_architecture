package ModelMapper;

import Model.BuildingReponse.BuildingReponse;
import Model.BuildingRequest.BuildingRequest;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class baseMapper {
	
	 final  DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

}
