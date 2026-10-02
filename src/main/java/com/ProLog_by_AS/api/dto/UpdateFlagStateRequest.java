package com.ProLog_by_AS.api.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateFlagStateRequest(@NotNull Boolean enabled) {}