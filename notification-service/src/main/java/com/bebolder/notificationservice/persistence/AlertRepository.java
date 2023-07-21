package com.bebolder.notificationservice.persistence;

import com.bebolder.notificationservice.domain.dto.AlertDTO;
import com.bebolder.notificationservice.domain.repository.IAlertRepository;
import com.bebolder.notificationservice.persistence.crud.IAlertCrudRepository;
import com.bebolder.notificationservice.persistence.entity.Alert;
import com.bebolder.notificationservice.persistence.mappers.IAlertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlertRepository implements IAlertRepository {

    @Autowired
    private IAlertCrudRepository alertCrudRepository;

    @Autowired
    private IAlertMapper alertMapper;

    @Override
    public List<AlertDTO> getAll() {
        List<Alert> alerts = (List<Alert>) alertCrudRepository.findAll();
        return alertMapper.toArrayDto(alerts);
    }

    @Override
    public Optional<AlertDTO> getAlert(Long alertId) {
        return alertCrudRepository.findById(alertId).map(alert -> alertMapper.toDto(alert));
    }

    @Override
    public AlertDTO save(AlertDTO alertDTO) {
        Alert alert = alertMapper.toEntity(alertDTO);
        return alertMapper.toDto(alertCrudRepository.save(alert));
    }

    @Override
    public void delete(long adminId) {
        alertCrudRepository.deleteById(adminId);
    }
}
