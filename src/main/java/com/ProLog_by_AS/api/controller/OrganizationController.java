package com.ProLog_by_AS.api.controller;

import com.ProLog_by_AS.api.dto.CreateOrganizationRequest;
import com.ProLog_by_AS.api.model.Organization;
import com.ProLog_by_AS.api.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orgs")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization create(
            @Valid @RequestBody CreateOrganizationRequest request) {
        return organizationService.create(request.name());
    }

    @GetMapping
    public List<Organization> getAll() {
        return organizationService.getAll();
    }

    @GetMapping("/{orgId}")
    public Organization getById(@PathVariable UUID orgId) {
        return organizationService.getById(orgId);
    }
}