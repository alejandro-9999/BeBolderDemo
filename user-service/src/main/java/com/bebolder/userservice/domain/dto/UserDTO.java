package com.bebolder.userservice.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    protected long userId;
    protected String username;
    protected String password;
    protected String email;
}
