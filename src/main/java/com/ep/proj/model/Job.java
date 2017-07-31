package com.ep.proj.model;

public class Job extends BaseEntity{
    private Position[] positions;

    public Job(Integer id, String name, Position[] positions) {
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
