package com.ep.proj.controller;

import com.ep.proj.model.BaseEntity;
import com.ep.proj.model.User;
import com.ep.proj.repository.UserRepository;
import com.ep.proj.repository.mock.InMemoryUserRepository;
import com.ep.proj.utils.NotFoundException;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class UserControllerImpl implements Controller {
    private final UserRepository repository;
    private static final Logger log = getLogger(UserRepository.class);

    public UserControllerImpl() {
        this.repository = new InMemoryUserRepository();
    }

    public UserControllerImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll()  throws NotFoundException {
        log.debug("GET ALL USER");

        List<User> users = repository.getAll();
        if (users == null) {
            throw new NotFoundException("Error getting users");
        } else {
            return users;
        }
    }

    @Override
    public User get(int id) throws NotFoundException {
        log.debug("GET USER BY ID");

        User returnUser = repository.get(id);
        if (returnUser == null) {
            throw new NotFoundException("Error getting user");
        } else {
            return returnUser;
        }
    }

    @Override
    public boolean delete(int id) throws NotFoundException {
        log.debug("DELETE USER BY ID");

        if (!repository.delete(id)) {
            throw new NotFoundException("User id not found");
        } else {
            return true;
        }
    }

    @Override
    public User update(BaseEntity user, int id) throws NotFoundException {
        log.debug("UPDATE USER BY ID");
        User returnedUser;
        if (user.getId() == id){
            returnedUser = repository.save((User) user);
        } else {
            throw new NotFoundException("User id incorrect");
        }
        if (returnedUser == null) {
            throw new NotFoundException("User id incorrect");
        } else {
            return returnedUser;
        }
    }

    @Override
    public User create(BaseEntity user) throws NotFoundException {
        log.debug("CREATE USER");

        User returnUser = repository.save((User) user);
        if (returnUser == null) {
            throw new NotFoundException("Error creation user");
        } else {
            return returnUser;
        }
    }
}