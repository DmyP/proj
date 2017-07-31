package com.ep.proj.model;

public class Process extends BaseEntity{
    private Position[] positions;

    public Process(Integer id, String name, Position[] positions) {
        super(id, name);
        this.positions = positions;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }
}
