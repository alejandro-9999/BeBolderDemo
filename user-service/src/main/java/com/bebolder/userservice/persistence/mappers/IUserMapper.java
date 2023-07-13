package com.bebolder.userservice.persistence.mappers;

import com.bebolder.userservice.domain.dto.UserDTO;
import com.bebolder.userservice.persistence.entity.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper( IUserMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    UserDTO userToUserDTO(User user);
    List<UserDTO> toUsersDTO(List<User> users);
    @Mappings({
            @Mapping(source = "userId", target = "id")
    })
    User userDTOToUser(UserDTO userDTO);
}
