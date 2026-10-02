package com.ProLog_by_AS.api.repository;

import com.ProLog_by_AS.api.model.Flag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlagRepository {

    Flag save(Flag flag);

    Optional<Flag> findById(UUID id);

    List<Flag> findByProjectId(UUID projectId);

    boolean existsByProjectIdAndKey(UUID projectId, String key);

    void deleteById(UUID id);
}