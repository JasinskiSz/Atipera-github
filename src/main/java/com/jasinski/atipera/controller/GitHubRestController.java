package com.jasinski.atipera.controller;

import com.jasinski.atipera.dto.RestResponse;
import com.jasinski.atipera.service.GitHubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class GitHubRestController {
    private final GitHubService gitHubService;

    @GetMapping(value = "/github/users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> getGitHubUserDetails(@PathVariable String username) {
        return ResponseEntity.ok(new RestResponse(gitHubService.getUserRepositoriesDTO(username)));
    }

    @GetMapping(value = "/**", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> XMLNotSupported() {
        return new ResponseEntity<>(
                "<response><status>406</status><message>Not Acceptable - XML not supported</message></response>",
                HttpStatus.NOT_ACCEPTABLE);
    }
}
