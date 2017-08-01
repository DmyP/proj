package com.ep.proj.controller;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Project;
import com.ep.proj.repository.ProjectRepository;
import com.ep.proj.repository.mock.InMemoryProjectRepository;
import com.ep.proj.utils.NotFoundException;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ProjectControllerImpl implements Controller{
    private final ProjectRepository repository;
    private static final Logger log = getLogger(ProjectRepository.class);

    public ProjectControllerImpl() {
        this.repository = new InMemoryProjectRepository();
    }

    public ProjectControllerImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAll()  throws NotFoundException {
        log.debug("GET ALL PROJECT");

        List<Project> projects = repository.getAll();
        if (projects == null) {
            throw new NotFoundException("Error getting projects");
        } else {
            return projects;
        }
    }

    @Override
    public Project get(int id) throws NotFoundException {
        log.debug("GET PROJECT BY ID");

        Project returnProject = repository.get(id);
        if (returnProject == null) {
            throw new NotFoundException("Error getting project");
        } else {
            return returnProject;
        }
    }

    @Override
    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE PROJECT BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("Project id not found");
        } else {
            return true;
        }
    }

    @Override
    public Project update(BaseEntity project, int id) throws NotFoundException {
        log.debug("UPDATE PROJECT BY ID");
        Project returnedProject;
        if (project.getId() == id){
            returnedProject = repository.save((Project) project);
        } else {
            throw new NotFoundException("Project id incorrect");
        }
        if (returnedProject == null) {
            throw new NotFoundException("Project id incorrect");
        } else {
            return returnedProject;
        }
    }

    @Override
    public Project create(BaseEntity project) throws NotFoundException {
        log.debug("CREATE PROJECT");

        Project returnProject = repository.save((Project) project);
        if (returnProject == null) {
            throw new NotFoundException("Error creation project");
        } else {
            return returnProject;
        }
    }
}