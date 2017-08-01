package com.ep.proj.controller;

import com.ep.proj.controller.SpecificationControllerImpl;
import com.ep.proj.model.Position;
import com.ep.proj.model.Process;
import com.ep.proj.model.Specification;
import com.ep.proj.repository.mock.InMemorySpecificationRepository;
import com.ep.proj.utils.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class InMemorySpecificationControllerImplTest {
    private static SpecificationControllerImpl specificationControllerImpl;

    @Before
    public void setUp() throws Exception {
        specificationControllerImpl = new SpecificationControllerImpl(new InMemorySpecificationRepository());
    }

    @Test
    public void testGet() throws Exception {
        Specification specification1 = specificationControllerImpl.get(1);
        Specification specification2 = specificationControllerImpl.get(1);
        Assert.assertEquals(specification1.getId(), specification2.getId());
        Assert.assertEquals(specification1.getName(), specification2.getName());
        Assert.assertEquals(specification1.getProcesses(), specification2.getProcesses());
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        specificationControllerImpl.get(100);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Specification> specifications1 = specificationControllerImpl.getAll();
        List<Specification> specifications2 = specificationControllerImpl.getAll();
        Assert.assertEquals(specifications1.size(), specifications2.size());
        Assert.assertEquals(specifications1.get(1), specifications2.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        int sizeBefore = specificationControllerImpl.getAll().size();
        specificationControllerImpl.delete(1);
        Assert.assertEquals(specificationControllerImpl.getAll().size(), sizeBefore - 1);
        Assert.assertEquals(specificationControllerImpl.getAll().iterator().next().getId(), new Integer(2));
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        specificationControllerImpl.delete(100);
    }

    @Test
    public void testCreate() throws Exception {
        Specification specification = new Specification(100, "Test specification", new Process[]{new Process(44, "Test process", new Position[]{Position.CLIENT})});
        int sizeBefore = specificationControllerImpl.getAll().size();
        specificationControllerImpl.create(specification);
        Assert.assertEquals(specificationControllerImpl.getAll().size(), sizeBefore + 1);
        Assert.assertEquals(specificationControllerImpl.get(100).getId(), specification.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        Specification specification = specificationControllerImpl.get(1);
        int specificationId = specification.getId();
        specification.setName("abc");
        specificationControllerImpl.update(specification, specificationId);
        Assert.assertEquals(specificationControllerImpl.get(specificationId).getName(), "abc");
    }
}