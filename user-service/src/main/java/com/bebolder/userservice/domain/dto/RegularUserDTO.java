package com.bebolder.userservice.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegularUserDTO extends UserDTO {
    private String role = "regular_user";
}
