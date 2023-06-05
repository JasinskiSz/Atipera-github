package com.jasinski.atipera.service;

import com.jasinski.atipera.dto.github.BranchDTO;
import com.jasinski.atipera.dto.github.RepositoryDTO;
import com.jasinski.atipera.exception.UserNotFoundException;
import com.jasinski.atipera.model.github.Branch;
import com.jasinski.atipera.model.github.Repository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubService {
    @Value("${github.api}")
    private String GITHUB_API_BASE_URI;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public List<RepositoryDTO> getUserRepositoriesDTO(String username) {
        String uri = GITHUB_API_BASE_URI + "users/" + username + "/repos";

        ResponseEntity<Repository[]> response;
        try {
            response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()),
                    Repository[].class);
        } catch (RestClientException e) {
            throw new UserNotFoundException();
        }

        Repository[] reposArr = response.getBody();
        if (reposArr == null) {
            return List.of();
        }

        // mapping to DTO and adding branchesDTO to each repo
        RepositoryDTO[] repositoryDTOS = modelMapper.map(
                Arrays.stream(reposArr).filter(repo -> !repo.getIsFork()).toList(),
                RepositoryDTO[].class);
        Arrays.stream(repositoryDTOS)
                .forEach(repo -> repo.setBranches(
                        getUserRepositoryBranchesDTO(username, repo.getName()))
                );

        return Arrays.asList(repositoryDTOS);
    }

    private List<BranchDTO> getUserRepositoryBranchesDTO(String username, String repositoryName) {
        String uri = GITHUB_API_BASE_URI + "repos/" + username + "/" + repositoryName + "/branches";
        ResponseEntity<Branch[]> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                Branch[].class
        );

        Branch[] branchArr = response.getBody();
        if (branchArr == null) {
            return List.of();
        }

        BranchDTO[] branchDTOArr = modelMapper.map(branchArr, BranchDTO[].class);

        return Arrays.asList(branchDTOArr);
    }
}
