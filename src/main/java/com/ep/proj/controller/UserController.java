package com.ep.proj.controller;

import com.ep.proj.model.User;
import com.ep.proj.repository.UserRepository;
import com.ep.proj.repository.mock.InMemoryUserRepository;
import com.ep.proj.utils.NotFoundException;

import java.util.List;

public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll()  throws NotFoundException {
        List<User> users = repository.getAll();
        if (users == null) {
            throw new NotFoundException("Error getting users");
        } else {
            return users;
        }
    }

    public User get(int id) throws NotFoundException {
        User u = repository.get(id);
        if (u == null) {
            throw new NotFoundException("Error getting user");
        } else {
            return u;
        }
    }

    public boolean delete(int id) throws NotFoundException {
        if (!repository.delete(id)) {
            throw new NotFoundException("User id not found");
        } else {
            return true;
        }
    }

    public void update(User user, int id) throws NotFoundException {
        if (user.getId() == id){
            repository.save(user);
        } else {
            throw new NotFoundException("User id incorrect");
        }
    }

    public User create(User user) throws NotFoundException {
        User u = repository.save(user);
        if (u == null) {
            throw new NotFoundException("Error creation user");
        } else {
            return u;
        }
    }
}