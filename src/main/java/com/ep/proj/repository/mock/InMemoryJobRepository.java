package com.ep.proj.repository.mock;

import com.ep.proj.model.Job;
import com.ep.proj.repository.JobRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryJobRepository implements JobRepository{
    private Map<Integer, Job> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    {
        MockDB.JOB_LIST.forEach(this::save);
        counter.set(repository.size());
    }

    @Override
    public Job save(Job job) {
        if (job.isNew()) {
            job.setId(counter.incrementAndGet());
        }
        repository.put(job.getId(), job);
        return job;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Job get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Job> getAll() {
        return new ArrayList<>(repository.values());
    }
}