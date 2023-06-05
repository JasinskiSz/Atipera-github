package com.jasinski.atipera.config.converter;

import com.jasinski.atipera.dto.github.BranchDTO;
import com.jasinski.atipera.model.github.Branch;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class BranchToBranchDTOConverter implements Converter<Branch, BranchDTO> {
    @Override
    public BranchDTO convert(MappingContext<Branch, BranchDTO> context) {
        Branch source = context.getSource();
        BranchDTO destination = context.getDestination();
        if (destination == null) {
            destination = new BranchDTO();
        }
        destination.setName(source.getName());
        destination.setLatestCommitSha(source.getCommit().getSha());
        return destination;
    }
}
