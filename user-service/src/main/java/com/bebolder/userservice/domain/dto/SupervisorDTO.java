package com.bebolder.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SupervisorDTO extends UserDTO {
    private String role = "supervisor";
    public SupervisorDTO() {
    }

    public SupervisorDTO(long userId) {
        super(userId);
    }

    public SupervisorDTO(String username, String password, String email) {
        super(username, password, email);
    }
}
