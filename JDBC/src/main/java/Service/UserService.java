package Service;

import java.util.List;

import repository.entity.UserEntity;

public interface UserService {
    List<UserEntity> findAll();
}
