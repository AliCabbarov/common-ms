package com.example.commonms.exception;

import jakarta.validation.constraints.NotNull;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @NotNull
    private String message;
    @NotNull
    private Integer status;
    @NotNull
    private String path;
    Map<String, Object> data;
}
