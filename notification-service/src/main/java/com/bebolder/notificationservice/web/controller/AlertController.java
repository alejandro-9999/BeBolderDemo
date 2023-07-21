package com.bebolder.notificationservice.web.controller;


import com.bebolder.notificationservice.domain.dto.AlertDTO;
import com.bebolder.notificationservice.domain.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alert")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping("/all")
    public List<AlertDTO> getAll() {
        return  alertService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AlertDTO> getAlert(@PathVariable("id") Long aletId){
        return alertService.getAlert(aletId);
    }

    @PostMapping("/save")
    public AlertDTO save(@RequestBody AlertDTO alertDTO){
        return alertService.save(alertDTO);
    }


}
