package com.ep.proj.repository;

import com.ep.proj.model.Job;
import java.util.List;

public interface JobRepository {
    Job save(Job job);

    boolean delete(int id);

    Job get(int id);

    List<Job> getAll();
}
