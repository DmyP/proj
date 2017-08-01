package com.ep.proj.web;

import com.ep.proj.controller.ProcessControllerImpl;
import com.ep.proj.model.Position;
import com.ep.proj.model.Process;
import com.ep.proj.repository.mock.InMemoryProcessRepository;
import com.ep.proj.utils.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class InMemoryProcessControllerImplTest {
    private static ProcessControllerImpl processControllerImpl;

    @Before
    public void setUp() throws Exception {
        processControllerImpl = new ProcessControllerImpl(new InMemoryProcessRepository());
    }

    @Test
    public void testGet() throws Exception {
        Process process1 = processControllerImpl.get(1);
        Process process2 = processControllerImpl.get(1);
        Assert.assertEquals(process1.getId(), process2.getId());
        Assert.assertEquals(process1.getName(), process2.getName());
        Assert.assertEquals(process1.getPositions(), process2.getPositions());
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        processControllerImpl.get(100);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Process> processs1 = processControllerImpl.getAll();
        List<Process> processs2 = processControllerImpl.getAll();
        Assert.assertEquals(processs1.size(), processs2.size());
        Assert.assertEquals(processs1.get(1), processs2.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        int sizeBefore = processControllerImpl.getAll().size();
        processControllerImpl.delete(1);
        Assert.assertEquals(processControllerImpl.getAll().size(), sizeBefore - 1);
        Assert.assertEquals(processControllerImpl.getAll().iterator().next().getId(), new Integer(2));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        processControllerImpl.delete(100);
    }

    @Test
    public void testCreate() throws Exception {
        Process process = new Process(100, "Test process", new Position[]{Position.SENIOR, Position.MIDDLE});
        int sizeBefore = processControllerImpl.getAll().size();
        processControllerImpl.create(process);
        Assert.assertEquals(processControllerImpl.getAll().size(), sizeBefore + 1);
        Assert.assertEquals(processControllerImpl.get(100).getId(), process.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        Process process = processControllerImpl.get(1);
        int processId = process.getId();
        process.setName("abc");
        processControllerImpl.update(process, processId);
        Assert.assertEquals(processControllerImpl.get(processId).getName(), "abc");
    }
}