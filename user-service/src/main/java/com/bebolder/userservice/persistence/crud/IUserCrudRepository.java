package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<User,Long> {

}
