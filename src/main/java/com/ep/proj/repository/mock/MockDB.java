package com.ep.proj.repository.mock;

import com.ep.proj.model.*;
import com.ep.proj.model.Process;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class MockDB {
    static final List<User> USER_LIST = Arrays.asList(
        new User(1, "admin", "admin", "admin@projep.com", Role.ADMIN, Position.ADMIN, true, LocalDate.now()),
        new User(2, "client1", "client1", "client1@google.com", Role.CLIENT, Position.CLIENT, true, LocalDate.now()),
        new User(3, "client2", "client2", "client2@google.com", Role.CLIENT, Position.CLIENT, true, LocalDate.now()),
        new User(4, "pm", "pm", "pm@projep.com", Role.DEVELOPER, Position.PM, true, LocalDate.now()),
        new User(5, "junior_1", "junior_1", "junior_1@projep.com", Role.DEVELOPER, Position.JUNIOR, true, LocalDate.now()),
        new User(6, "junior_2", "junior_2", "junior_2@projep.com", Role.DEVELOPER, Position.JUNIOR, false, LocalDate.now()),
        new User(7, "middle_1", "middle_1", "middle_1@projep.com", Role.DEVELOPER, Position.MIDDLE, true, LocalDate.now()),
        new User(8, "middle_2", "middle_2", "middle_2@projep.com", Role.DEVELOPER, Position.MIDDLE, false, LocalDate.now()),
        new User(9, "senior_1", "senior_1", "senior_1@projep.com", Role.DEVELOPER, Position.SENIOR, true, LocalDate.now()),
        new User(10, "senior_2", "senior_2", "senior_2@projep.com", Role.DEVELOPER, Position.SENIOR, false, LocalDate.now()),
        new User(11, "qa", "qa", "qa@projep.com", Role.QA, Position.QA, false, LocalDate.now())
    );

    static final List<Process> PROCESS_LIST = Arrays.asList(
        new Process(1, "Requirements Analysis", new Position[]{Position.PM}),
        new Process(2, "Architecture design", new Position[]{Position.SENIOR}),
        new Process(3, "DB development", new Position[]{Position.SENIOR, Position.JUNIOR}),
        new Process(4, "Backend development", new Position[]{Position.SENIOR, Position.MIDDLE, Position.JUNIOR}),
        new Process(5, "Frontend development", new Position[]{Position.MIDDLE, Position.JUNIOR}),
        new Process(6, "Testing", new Position[]{Position.QA})
    );

    static final List<Specification> SPECIFICATION_LIST = Arrays.asList(
        new Specification(1, "Users DB", new Process[]{PROCESS_LIST.get(0), PROCESS_LIST.get(2), PROCESS_LIST.get(5)}),
        new Specification(2, "Corporate site", new Process[]{PROCESS_LIST.get(0), PROCESS_LIST.get(1), PROCESS_LIST.get(4), PROCESS_LIST.get(5)}),
        new Specification(3, "Internet shop", new Process[]{PROCESS_LIST.get(0), PROCESS_LIST.get(1), PROCESS_LIST.get(2), PROCESS_LIST.get(4), PROCESS_LIST.get(5)}),
        new Specification(4, "Billing system", new Process[]{PROCESS_LIST.get(0), PROCESS_LIST.get(1), PROCESS_LIST.get(2), PROCESS_LIST.get(3), PROCESS_LIST.get(4), PROCESS_LIST.get(5)})
    );

    static final List<Project> PROJECT_LIST= Arrays.asList(
        new Project(1, "Project1" , SPECIFICATION_LIST.get(0), new User[]{USER_LIST.get(3), USER_LIST.get(8), USER_LIST.get(10)}, 0, USER_LIST.get(3))
    );

    static final List<Invoice> INVOICE_LIST = Arrays.asList(
        new Invoice(1, "Client X invoice1", PROJECT_LIST.get(0), PROJECT_LIST.get(0).getProjectPrice() * 2,USER_LIST.get(1),PROJECT_LIST.get(0).getProjectManager())
    );
}


