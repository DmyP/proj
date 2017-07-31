package com.ep.proj.model;

abstract class BaseEntity {
    private Integer id;
    private String name;

    BaseEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isNew() {
        return id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
