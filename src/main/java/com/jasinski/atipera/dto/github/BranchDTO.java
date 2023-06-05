package com.jasinski.atipera.dto.github;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDTO {
    private String name;
    private String latestCommitSha;
}
