package com.ProLog_by_AS.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateOrganizationRequest(@NotBlank String name) {}