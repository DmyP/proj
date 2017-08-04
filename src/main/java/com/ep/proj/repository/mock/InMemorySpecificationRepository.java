package com.ep.proj.repository.mock;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Specification;
import com.ep.proj.repository.SpecificationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemorySpecificationRepository implements SpecificationRepository{
    private Map<Integer, Specification> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    {
        MockDB.SPECIFICATION_LIST.forEach(this::save);
        counter.set(repository.size());
    }

    @Override
    public Specification save(Specification specification) {
        if (specification.isNew()) {
            specification.setId(counter.incrementAndGet());
        }
        repository.put(specification.getId(), specification);
        return specification;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Specification get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Specification> getAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Specification getForName(String name) {
        for (Map.Entry<Integer, Specification> entry: repository.entrySet()){
        }
        return null;
    }
}