package com.bebolder.notificationservice.domain.repository;

import com.bebolder.notificationservice.domain.dto.AlertDTO;

import java.util.List;
import java.util.Optional;

public interface IAlertRepository {
    List<AlertDTO> getAll();
    Optional<AlertDTO> getAlert(Long alertId);
    AlertDTO save(AlertDTO alertDTO);
    void delete(long adminId);
}
