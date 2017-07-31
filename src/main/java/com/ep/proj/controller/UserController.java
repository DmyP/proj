package com.ep.proj.controller;

import com.ep.proj.model.User;
import com.ep.proj.repository.UserRepository;
import com.ep.proj.repository.mock.InMemoryUserRepository;
import com.ep.proj.utils.NotFoundException;
import com.ep.proj.web.UserServlet;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class UserController {
    private final UserRepository repository;
    private static final Logger log = getLogger(UserRepository.class);

    public UserController() {
        this.repository = new InMemoryUserRepository();
    }

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll()  throws NotFoundException {
        log.debug("GET ALL USERS");

        List<User> users = repository.getAll();
        if (users == null) {
            throw new NotFoundException("Error getting users");
        } else {
            return users;
        }
    }

    public User get(int id) throws NotFoundException {
        log.debug("GET USER BY ID");

        User u = repository.get(id);
        if (u == null) {
            throw new NotFoundException("Error getting user");
        } else {
            return u;
        }
    }

    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE USER BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("User id not found");
        } else {
            return true;
        }
    }

    public void update(User user, int id) throws NotFoundException {
        log.debug("UPDATE USER BY ID");

        if (user.getId() == id){
            repository.save(user);
        } else {
            throw new NotFoundException("User id incorrect");
        }
    }

    public User create(User user) throws NotFoundException {
        log.debug("CREATE USER");

        User u = repository.save(user);
        if (u == null) {
            throw new NotFoundException("Error creation user");
        } else {
            return u;
        }
    }
}