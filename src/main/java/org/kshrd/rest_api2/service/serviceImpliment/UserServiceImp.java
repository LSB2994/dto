package org.kshrd.rest_api2.service.serviceImpliment;

import org.kshrd.rest_api2.excepton.FieldEmptyException;
import org.kshrd.rest_api2.excepton.NotFountException;
import org.kshrd.rest_api2.mapper.UserMapper;
import org.kshrd.rest_api2.model.dto.UserDTO;
import org.kshrd.rest_api2.model.entity.UserApp;
import org.kshrd.rest_api2.model.request.UserRequest;
import org.kshrd.rest_api2.repository.UserRepository;
import org.kshrd.rest_api2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    UserDTO userDTO = new UserDTO();
    UserApp userApp =  new UserApp();

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDTO getUserById(Integer userId) {
        if (userRepository.findUserById(userId) != null) {
            userApp = userRepository.findUserById(userId);
            userDTO = userMapper.toUserDTO(userApp);
            return userDTO;
        }else throw new NotFountException("get user by id "+userId+ " is not found");
    }

    @Override
    public List<UserDTO> getAllUser() {
        // create new  object with arraylist
        List<UserApp> userApps = new ArrayList<>();
        List<UserDTO> userDTOS = new ArrayList<>();

        // mapping data between userApp and userDto
        userApps =userRepository.findAllUser();
        userDTOS = userMapper.toUserDTO(userApps);

        return userDTOS;
    }

    @Override
    public Integer addUser(UserRequest userRequest) {
        if (userRequest.getName().isBlank() || userRequest.getName().contains("string")){
            throw new FieldEmptyException("name cannot empty");
        }
        if (userRequest.getEmail().isBlank() || userRequest.getEmail().contains("string")){
            throw new FieldEmptyException("email message cannot empty");
        }
        if (userRequest.getPassword().isBlank() || userRequest.getPassword().contains("string")){
            throw new FieldEmptyException("password message cannot empty");
        }
        if (userRequest.getAddress().isBlank() || userRequest.getAddress().contains("string")){
            throw new FieldEmptyException("Address message cannot empty");
        }
            Integer userId = userRepository.saveUser(userRequest);
            if (userId != null){
                return userId;
            }
        return null;
    }
}
