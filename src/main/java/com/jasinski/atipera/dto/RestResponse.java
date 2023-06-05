package com.jasinski.atipera.dto;

import com.jasinski.atipera.dto.github.RepositoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RestResponse {
    private List<RepositoryDTO> repositories;
}
