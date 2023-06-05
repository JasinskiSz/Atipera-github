package com.jasinski.atipera.model.github;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {
    private String name;
    private Commit commit;
}
