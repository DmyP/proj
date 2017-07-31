package com.ep.proj.repository;

import com.ep.proj.model.User;
import java.util.List;

public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();
}
