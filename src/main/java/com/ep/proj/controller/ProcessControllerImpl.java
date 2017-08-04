package com.ep.proj.controller;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Process;
import com.ep.proj.repository.ProcessRepository;
import com.ep.proj.repository.mock.InMemoryProcessRepository;
import com.ep.proj.utils.NotFoundException;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ProcessControllerImpl implements Controller{
    private final ProcessRepository repository;
    private static final Logger log = getLogger(ProcessRepository.class);

    public ProcessControllerImpl() {
        this.repository = new InMemoryProcessRepository();
    }

    public ProcessControllerImpl(ProcessRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Process> getAll()  throws NotFoundException {
        log.debug("GET ALL PROCESS");

        List<Process> processs = repository.getAll();
        if (processs == null) {
            throw new NotFoundException("Error getting processs");
        } else {
            return processs;
        }
    }

    @Override
    public Process get(int id) throws NotFoundException {
        log.debug("GET PROCESS BY ID");

        Process returnProcess = repository.get(id);
        if (returnProcess == null) {
            throw new NotFoundException("Error getting process");
        } else {
            return returnProcess;
        }
    }

    @Override
    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE PROCESS BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("Process id not found");
        } else {
            return true;
        }
    }

    @Override
    public Process update(BaseEntity process, int id) throws NotFoundException {
        log.debug("UPDATE PROCESS BY ID");
        Process returnedProcess;
        if (process.getId() == id){
            returnedProcess = repository.save((Process) process);
        } else {
            throw new NotFoundException("Process id incorrect");
        }
        if (returnedProcess == null) {
            throw new NotFoundException("Process id incorrect");
        } else {
            return returnedProcess;
        }
    }

    @Override
    public Process create(BaseEntity process) throws NotFoundException {
        log.debug("CREATE PROCESS");

        Process returnProcess = repository.save((Process) process);
        if (returnProcess == null) {
            throw new NotFoundException("Error creation process");
        } else {
            return returnProcess;
        }
    }

    @Override
    public Process getForName(String name) {
         repository

        return null;
    }
}