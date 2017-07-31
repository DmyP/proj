package com.ep.proj.model;


public class Specification extends BaseEntity{
    private Job[] jobs;

    public Specification(Integer id, String name, Job[] jobs) {
        super(id, name);
        this.jobs = jobs;
    }

    public Job[] getJobs() {
        return jobs;
    }

    public void setJobs(Job[] jobs) {
        this.jobs = jobs;
    }
}
