package com.example.commonms.model.dto;

import com.example.commonms.model.enums.DataStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private T data;
    private DataStatus status;

    public ApiResponse(T data) {
        this.data = data;
        this.status = DataStatus.SUCCESS;
    }

}
