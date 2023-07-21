package com.bebolder.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class SupervisorDTO extends UserDTO {

    public SupervisorDTO() {
    }

    public SupervisorDTO(long userId) {
        super(userId);
    }

    public SupervisorDTO(String username, String password, String email) {
        super(username, password, email);
    }
}
