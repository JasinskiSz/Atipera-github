package com.jasinski.atipera.model.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Repository {
    private String name;
    private Owner owner;
    @JsonProperty("fork")
    private Boolean isFork;
    private List<Branch> branches;
}
