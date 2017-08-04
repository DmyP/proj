package com.ep.proj.controller;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.Process;
import com.ep.proj.utils.NotFoundException;

import java.util.List;

interface Controller<T extends BaseEntity> {

    List<T> getAll()  throws NotFoundException;

    T get(int id) throws NotFoundException;

    boolean delete(int id) throws NotFoundException;

    T update(T t, int id) throws NotFoundException;

    T create(T t) throws NotFoundException;

    T getForName(String name);
}