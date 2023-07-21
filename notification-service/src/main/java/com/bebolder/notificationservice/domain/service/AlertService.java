package com.bebolder.notificationservice.domain.service;

import com.bebolder.notificationservice.domain.dto.AlertDTO;
import com.bebolder.notificationservice.domain.repository.IAlertRepository;
import com.bebolder.notificationservice.persistence.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {
    @Autowired
    IAlertRepository alertRepository;

    public List<AlertDTO> getAll(){
        return alertRepository.getAll();
    }

    public Optional<AlertDTO> getAlert(long alertId){
        return alertRepository.getAlert(alertId);
    }

    public AlertDTO save (AlertDTO alert){
        return alertRepository.save(alert);
    }

    public Boolean delete(Long alertId){
        return getAlert(alertId).map(alertDTO -> {
                alertRepository.delete(alertId);
                return true;
        }).orElse(false);
    }

}
