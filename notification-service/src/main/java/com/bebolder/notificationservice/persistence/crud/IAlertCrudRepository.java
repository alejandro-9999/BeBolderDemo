package com.bebolder.notificationservice.persistence.crud;

import com.bebolder.notificationservice.persistence.entity.Alert;
import org.springframework.data.repository.CrudRepository;

public interface IAlertCrudRepository extends CrudRepository <Alert,Long> {
}
