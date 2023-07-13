package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.RegularUser;
import org.springframework.data.repository.CrudRepository;

public interface IRegularUserCrudRepository extends CrudRepository<RegularUser,Long> {
}
