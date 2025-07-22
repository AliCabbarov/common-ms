package com.example.commonms.model.dto.request;

import com.example.commonms.model.enums.UserFilter;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRequest {

    private String filterById;
    private Map<UserFilter, String> filter;

}
