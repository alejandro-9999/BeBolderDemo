package com.bebolder.userservice.persistence.mappers;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.persistence.entity.Admin;
import com.bebolder.userservice.persistence.entity.RegularUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRegularUserMapper{

    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    RegularUserDTO regularUserToRegularUserDTO(RegularUser regularUser);

    List<RegularUserDTO> toRegularUsersDTO(List<RegularUser> regularUsers);

    @Mappings({
            @Mapping(source = "userId", target = "id")
    })
    RegularUser regularUserDTOToRegularUser(RegularUserDTO regularUserDTO);
}
