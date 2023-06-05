package com.jasinski.atipera.dto.github;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestExceptionResponse {
    private Integer status;
    private String message;
}
