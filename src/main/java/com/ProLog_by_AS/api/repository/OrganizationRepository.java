package com.ProLog_by_AS.api.repository;

import com.ProLog_by_AS.api.model.Organization;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository {

    Organization save(Organization organization);

    Optional<Organization> findById(UUID id);

    List<Organization> findAll();
}