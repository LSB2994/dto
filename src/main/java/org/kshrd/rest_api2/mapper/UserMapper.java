package org.kshrd.rest_api2.mapper;
import org.kshrd.rest_api2.model.dto.UserDTO;
import org.kshrd.rest_api2.model.entity.UserApp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    @Mapping(source = "name",target = "userName")
    @Mapping(source = "email",target = "userEmail")
    @Mapping(source = "address",target = "userAddress")
    UserDTO toUserDTO(UserApp userApp);
    List<UserDTO> toUserDTO(List<UserApp> userApps);
}
