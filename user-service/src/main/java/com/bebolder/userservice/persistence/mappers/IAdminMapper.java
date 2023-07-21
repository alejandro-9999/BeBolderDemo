package com.bebolder.userservice.persistence.mappers;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.persistence.entity.Admin;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAdminMapper{
    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    AdminDTO adminToAdminDTO(Admin admin);
    List<AdminDTO> toAdminsDTO(List<Admin> admins);

    @Mappings({
            @Mapping(source = "userId", target = "id")
    })
    Admin adminDTOToAdmin(AdminDTO adminDTO);
}
