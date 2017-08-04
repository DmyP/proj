package com.ep.proj.model;


public class Specification extends BaseEntity{
    private Process[] processes;

    public Specification(Integer id, String name, Process[] processes) {
        super(id, name);
        this.processes = processes;
    }

    public Process[] getProcesses() {
        return processes;
    }

    public void setProcesses(Process[] processes) {
        this.processes = processes;
    }

}
