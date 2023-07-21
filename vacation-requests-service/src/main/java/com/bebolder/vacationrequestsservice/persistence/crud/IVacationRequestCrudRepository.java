package com.bebolder.vacationrequestsservice.persistence.crud;

import com.bebolder.vacationrequestsservice.persistence.entity.VacationRequest;
import org.springframework.data.repository.CrudRepository;

public interface IVacationRequestCrudRepository extends CrudRepository<VacationRequest,Long> {
}
