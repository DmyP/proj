package com.ep.proj.controller;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Specification;
import com.ep.proj.repository.SpecificationRepository;
import com.ep.proj.repository.mock.InMemorySpecificationRepository;
import com.ep.proj.utils.NotFoundException;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class SpecificationControllerImpl implements Controller {
    private final SpecificationRepository repository;
    private static final Logger log = getLogger(SpecificationRepository.class);

    public SpecificationControllerImpl() {
        this.repository = new InMemorySpecificationRepository();
    }

    public SpecificationControllerImpl(SpecificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Specification> getAll()  throws NotFoundException {
        log.debug("GET ALL SPECIFICATION");

        List<Specification> specifications = repository.getAll();
        if (specifications == null) {
            throw new NotFoundException("Error getting specifications");
        } else {
            return specifications;
        }
    }

    @Override
    public Specification get(int id) throws NotFoundException {
        log.debug("GET SPECIFICATION BY ID");

        Specification returnSpecification = repository.get(id);
        if (returnSpecification == null) {
            throw new NotFoundException("Error getting specification");
        } else {
            return returnSpecification;
        }
    }

    @Override
    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE SPECIFICATION BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("Specification id not found");
        } else {
            return true;
        }
    }

    @Override
    public Specification update(BaseEntity specification, int id) throws NotFoundException {
        log.debug("UPDATE SPECIFICATION BY ID");
        Specification returnedSpecification;
        if (specification.getId() == id){
            returnedSpecification = repository.save((Specification) specification);
        } else {
            throw new NotFoundException("Specification id incorrect");
        }
        if (returnedSpecification == null) {
            throw new NotFoundException("Specification id incorrect");
        } else {
            return returnedSpecification;
        }
    }

    @Override
    public Specification create(BaseEntity specification) throws NotFoundException {
        log.debug("CREATE SPECIFICATION");

        Specification returnSpecification = repository.save((Specification) specification);
        if (returnSpecification == null) {
            throw new NotFoundException("Error creation specification");
        } else {
            return returnSpecification;
        }
    }
}