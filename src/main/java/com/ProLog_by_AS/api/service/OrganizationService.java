package com.ProLog_by_AS.api.service;

import com.ProLog_by_AS.api.exception.NotFoundException;
import com.ProLog_by_AS.api.model.Organization;
import com.ProLog_by_AS.api.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization create(String name) {
        Organization organization = new Organization(UUID.randomUUID(), name);
        return organizationRepository.save(organization);
    }

    public Organization getById(UUID id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Organization " + id + " not found"));
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }
}