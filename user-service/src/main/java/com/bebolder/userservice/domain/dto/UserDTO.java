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

    public UserDTO(long userId){
        this.userId = userId;
    }

    public UserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
