package com.ep.proj.model;

import java.util.Arrays;

public class Project extends BaseEntity{
    private Specification specification;
    private User[] projectDevelopers;
    private Integer[] projectDevelopersTime;
    private Integer projectPrice;
    private User projectManager;

    public Project(Integer id, String name, Specification specification, User[] projectDevelopers, Integer projectPrice, User projectManager) {
        super(id, name);
        this.specification = specification;
        this.projectDevelopers = projectDevelopers;
        this.projectDevelopersTime = new Integer[projectDevelopers.length];
        Arrays.fill(this.projectDevelopersTime, 0);
        this.projectPrice = projectPrice;
        this.projectManager = projectManager;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public User[] getProjectDevelopers() {
        return projectDevelopers;
    }

    public void setProjectDevelopers(User[] projectDevelopers) {
        this.projectDevelopers = projectDevelopers;
    }

    public Integer[] getProjectDevelopersTime() {
        return projectDevelopersTime;
    }

    public void setProjectDevelopersTime(Integer[] projectDevelopersTime) {
        this.projectDevelopersTime = projectDevelopersTime;
    }

    public Integer getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(Integer projectPrice) {
        this.projectPrice = projectPrice;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }
}
