package org.kshrd.rest_api2.service;
import org.kshrd.rest_api2.model.dto.UserDTO;
import org.kshrd.rest_api2.model.request.UserRequest;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUser();
    Integer addUser(UserRequest userRequest);
}
