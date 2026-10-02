package com.ProLog_by_AS.api.service;

import com.ProLog_by_AS.api.exception.ConflictException;
import com.ProLog_by_AS.api.exception.NotFoundException;
import com.ProLog_by_AS.api.model.Flag;
import com.ProLog_by_AS.api.model.Project;
import com.ProLog_by_AS.api.repository.FlagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlagService {

    private final ProjectService projectService;
    private final FlagRepository flagRepository;

    public FlagService(ProjectService projectService,
                       FlagRepository flagRepository) {
        this.projectService = projectService;
        this.flagRepository = flagRepository;
    }

    public Flag create(UUID projectId, String key, String name) {
        Project project = projectService.getById(projectId);

        if (flagRepository.existsByProjectIdAndKey(projectId, key)) {
            throw new ConflictException(
                    "A flag with key '" + key + "' already exists in this project");
        }

        Flag flag = new Flag(
                UUID.randomUUID(),
                project.getOrganizationId(),
                project.getId(),
                key,
                name,
                false
        );

        return flagRepository.save(flag);
    }

    public Flag getById(UUID id) {
        return flagRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Flag " + id + " not found"));
    }

    public List<Flag> getAllForProject(UUID projectId) {
        projectService.getById(projectId);
        return flagRepository.findByProjectId(projectId);
    }

    public Flag setEnabled(UUID flagId, boolean enabled) {
        Flag flag = getById(flagId);
        flag.setEnabled(enabled);
        return flagRepository.save(flag);
    }
}