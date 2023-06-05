package com.jasinski.atipera.dto.github;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RepositoryDTO {
    private String name;
    private String ownerLogin;
    private List<BranchDTO> branches;
}
