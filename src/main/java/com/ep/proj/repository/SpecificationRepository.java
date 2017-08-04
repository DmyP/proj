package com.ep.proj.repository;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Specification;
import java.util.List;

public interface SpecificationRepository <T extends BaseEntity> {
    Specification save(Specification specification);

    boolean delete(int id);

    Specification get(int id);

    List<Specification> getAll();

    T getForName(String name);
}
