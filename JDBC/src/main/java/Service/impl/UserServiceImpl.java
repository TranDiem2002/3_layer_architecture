package Service.impl;

import java.util.List;

import Service.UserService;
import repository.UserRepository;
import repository.entity.UserEntity;
import repository.impl.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository = new UserRepositoryImpl();
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> userEntities = userRepository.findAll();
		return userEntities;
	}

}
