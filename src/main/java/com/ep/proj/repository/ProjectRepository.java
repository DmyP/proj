package com.ep.proj.repository;

import com.ep.proj.model.Project;
import java.util.List;

public interface ProjectRepository {
    Project save(Project project);

    boolean delete(int id);

    Project get(int id);

    List<Project> getAll();
}
