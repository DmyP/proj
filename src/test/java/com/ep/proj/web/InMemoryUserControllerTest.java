package com.ep.proj.web;

import com.ep.proj.controller.UserController;
import com.ep.proj.repository.mock.InMemoryUserRepository;
import com.ep.proj.model.Position;
import com.ep.proj.model.Role;
import com.ep.proj.model.User;
import com.ep.proj.utils.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;


public class InMemoryUserControllerTest {
    private static UserController controller;

    @Before
    public void setUp() throws Exception {
        controller = new UserController(new InMemoryUserRepository());
    }

    @Test
    public void testGet() throws Exception {
        User user1 = controller.get(1);
        User user2 = controller.get(1);
        Assert.assertEquals(user1.getId(), user2.getId());
        Assert.assertEquals(user1.getName(), user2.getName());
        Assert.assertEquals(user1.getRole(), user2.getRole());
        Assert.assertEquals(user1.getPosition(), user2.getPosition());
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        controller.get(100);
    }

    @Test
    public void testGetAll() throws Exception {
        List<User> users1 = controller.getAll();
        List<User> users2 = controller.getAll();
        Assert.assertEquals(users1.size(), users2.size());
        Assert.assertEquals(users1.get(1), users2.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        int sizeBefore = controller.getAll().size();
        controller.delete(1);
        Assert.assertEquals(controller.getAll().size(), sizeBefore - 1);
        Assert.assertEquals(controller.getAll().iterator().next().getId(), new Integer(2));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(100);
    }

    @Test
    public void testCreate() throws Exception {
        User user = new User(100,"ADMIN","ADMIN", "ADMIN", Role.ADMIN, Position.ADMIN, false,  LocalDate.now());
        int sizeBefore = controller.getAll().size();
        controller.create(user);
        Assert.assertEquals(controller.getAll().size(), sizeBefore + 1);
        Assert.assertEquals(controller.get(100).getId(), user.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = controller.get(1);
        int userId = user.getId();
        user.setName("abc");
        controller.update(user, userId);
        Assert.assertEquals(controller.get(userId).getName(), "abc");
    }
}