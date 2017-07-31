package com.ep.proj.repository;

import com.ep.proj.model.Process;
import java.util.List;

public interface ProcessRepository {
    Process save(Process process);

    boolean delete(int id);

    Process get(int id);

    List<Process> getAll();
}
