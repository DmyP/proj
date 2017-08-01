package com.ep.proj.web;

import com.ep.proj.controller.ProcessController;
import com.ep.proj.model.Position;
import com.ep.proj.model.Role;
import com.ep.proj.model.Process;
import com.ep.proj.repository.mock.InMemoryProcessRepository;
import com.ep.proj.utils.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;


public class InMemoryProcessControllerTest {
    private static ProcessController processController;

    @Before
    public void setUp() throws Exception {
        processController = new ProcessController(new InMemoryProcessRepository());
    }

    @Test
    public void testGet() throws Exception {
        Process process1 = processController.get(1);
        Process process2 = processController.get(1);
        Assert.assertEquals(process1.getId(), process2.getId());
        Assert.assertEquals(process1.getName(), process2.getName());
        Assert.assertEquals(process1.getPositions(), process2.getPositions());
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        processController.get(100);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Process> processs1 = processController.getAll();
        List<Process> processs2 = processController.getAll();
        Assert.assertEquals(processs1.size(), processs2.size());
        Assert.assertEquals(processs1.get(1), processs2.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        int sizeBefore = processController.getAll().size();
        processController.delete(1);
        Assert.assertEquals(processController.getAll().size(), sizeBefore - 1);
        Assert.assertEquals(processController.getAll().iterator().next().getId(), new Integer(2));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        processController.delete(100);
    }

    @Test
    public void testCreate() throws Exception {
        Process process = new Process(100, "Test process", new Position[]{Position.SENIOR, Position.MIDDLE});
        int sizeBefore = processController.getAll().size();
        processController.create(process);
        Assert.assertEquals(processController.getAll().size(), sizeBefore + 1);
        Assert.assertEquals(processController.get(100).getId(), process.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        Process process = processController.get(1);
        int processId = process.getId();
        process.setName("abc");
        processController.update(process, processId);
        Assert.assertEquals(processController.get(processId).getName(), "abc");
    }
}