package com.bebolder.notificationservice.persistence.mappers;

import com.bebolder.notificationservice.domain.dto.AlertDTO;
import com.bebolder.notificationservice.persistence.entity.Alert;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAlertMapper {
    @Mappings({
        @Mapping(target = "alertId", source = "id")
    })
    AlertDTO toDto(Alert alert);
    List<AlertDTO> toArrayDto(List<Alert> alerts);

    @Mappings({
        @Mapping(target = "id", source = "alertId")
    })
    @InheritConfiguration
    Alert toEntity(AlertDTO alertDTO);


}
