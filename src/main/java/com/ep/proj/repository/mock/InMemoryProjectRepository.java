package com.ep.proj.repository.mock;

import com.ep.proj.model.Project;
import com.ep.proj.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProjectRepository implements ProjectRepository{
    private Map<Integer, Project> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    {
        MockDB.PROJECT_LIST.forEach(this::save);
        counter.set(repository.size());
    }

    @Override
    public Project save(Project project) {
        if (project.isNew()) {
            project.setId(counter.incrementAndGet());
        }
        repository.put(project.getId(), project);
        return project;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Project get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(repository.values());
    }
}