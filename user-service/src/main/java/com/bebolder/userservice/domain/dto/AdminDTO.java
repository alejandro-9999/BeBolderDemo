package com.bebolder.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdminDTO extends UserDTO{
    private String role = "admin";
}
