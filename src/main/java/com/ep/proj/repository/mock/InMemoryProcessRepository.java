package com.ep.proj.repository.mock;

import com.ep.proj.model.Process;
import com.ep.proj.repository.ProcessRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProcessRepository implements ProcessRepository {
    private Map<Integer, Process> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    {
        MockDB.PROCESS_LIST.forEach(this::save);
        counter.set(repository.size());
    }

    @Override
    public Process save(Process process) {
        if (process.isNew()) {
            process.setId(counter.incrementAndGet());
        }
        repository.put(process.getId(), process);
        return process;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Process get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Process> getAll() {
        return new ArrayList<>(repository.values());
    }
}