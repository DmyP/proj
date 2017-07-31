package com.ep.proj.repository;

import com.ep.proj.model.Specification;
import java.util.List;

public interface SpecificationRepository {
    Specification save(Specification specification);

    boolean delete(int id);

    Specification get(int id);

    List<Specification> getAll();
}
