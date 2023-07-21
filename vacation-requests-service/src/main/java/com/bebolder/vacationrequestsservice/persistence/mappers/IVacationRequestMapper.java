package com.bebolder.vacationrequestsservice.persistence.mappers;

import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import com.bebolder.vacationrequestsservice.persistence.entity.VacationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVacationRequestMapper {
    @Mappings({
        @Mapping(source="id", target = "vacationRequestId"),
    })
    VacationRequestDTO  toDto(VacationRequest vacationRequest);
    List<VacationRequestDTO> toArrayDto(List<VacationRequest> vacationRequests);
    @Mappings({
        @Mapping(source="vacationRequestId", target = "id")
    })
    VacationRequest toEntity(VacationRequestDTO vacationRequestDTO);
}

