package com.jasinski.atipera.config.converter;

import com.jasinski.atipera.dto.github.RepositoryDTO;
import com.jasinski.atipera.model.github.Repository;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class RepositoryToResponseDTOConverter implements Converter<Repository, RepositoryDTO> {
    @Override
    public RepositoryDTO convert(MappingContext<Repository, RepositoryDTO> context) {
        Repository repo = context.getSource();
        RepositoryDTO repositoryDTO = context.getDestination();
        if (repositoryDTO == null) {
            repositoryDTO = new RepositoryDTO();
        }
        repositoryDTO.setName(repo.getName());
        repositoryDTO.setOwnerLogin(repo.getOwner().getLogin());
        return repositoryDTO;
    }
}
