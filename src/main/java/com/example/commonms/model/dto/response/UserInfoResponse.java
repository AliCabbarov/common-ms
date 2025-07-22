package com.example.commonms.model.dto.response;

import com.example.commonms.model.enums.SecurityRole;
import lombok.Data;

@Data
public class UserInfoResponse {

    private String id;
    private String name;
    private String surname;
    private String middleName;
    private String username;
    private String email;
    private String phoneNUmber;
    private SecurityRole role;

}
