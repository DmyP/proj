package com.ep.proj.controller;

import com.ep.proj.model.Process;
import com.ep.proj.repository.ProcessRepository;
import com.ep.proj.repository.mock.InMemoryProcessRepository;
import com.ep.proj.utils.NotFoundException;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ProcessController {
    private final ProcessRepository repository;
    private static final Logger log = getLogger(ProcessRepository.class);

    public ProcessController() {
        this.repository = new InMemoryProcessRepository();
    }

    public ProcessController(ProcessRepository repository) {
        this.repository = repository;
    }

    public List<Process> getAll()  throws NotFoundException {
        log.debug("GET ALL PROCESS");

        List<Process> processs = repository.getAll();
        if (processs == null) {
            throw new NotFoundException("Error getting processs");
        } else {
            return processs;
        }
    }

    public Process get(int id) throws NotFoundException {
        log.debug("GET PROCESS BY ID");

        Process u = repository.get(id);
        if (u == null) {
            throw new NotFoundException("Error getting process");
        } else {
            return u;
        }
    }

    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE PROCESS BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("Process id not found");
        } else {
            return true;
        }
    }

    public void update(Process process, int id) throws NotFoundException {
        log.debug("UPDATE PROCESS BY ID");

        if (process.getId() == id){
            repository.save(process);
        } else {
            throw new NotFoundException("Process id incorrect");
        }
    }

    public Process create(Process process) throws NotFoundException {
        log.debug("CREATE PROCESS");

        Process u = repository.save(process);
        if (u == null) {
            throw new NotFoundException("Error creation process");
        } else {
            return u;
        }
    }
}