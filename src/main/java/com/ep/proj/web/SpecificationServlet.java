package com.ep.proj.web;

import com.ep.proj.controller.ProcessControllerImpl;
import com.ep.proj.controller.SpecificationControllerImpl;
import com.ep.proj.model.Position;
import com.ep.proj.model.Process;
import com.ep.proj.model.Specification;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/specifications")
public class SpecificationServlet extends HttpServlet {
    private SpecificationControllerImpl specificationControllerImpl;
    private ProcessControllerImpl processControllerImpl;

    private static final Logger log = getLogger(SpecificationServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        specificationControllerImpl = new SpecificationControllerImpl();
        processControllerImpl = new ProcessControllerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("GET redirect to specification");

        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                specificationControllerImpl.delete(Integer.valueOf(request.getParameter("id")));
                response.sendRedirect("specifications");
                break;
            case "create":
            case "update":
                final Specification specification = action.equals("create") ?
                        new Specification(null,"", new Process[0]) :
                        specificationControllerImpl.get(Integer.valueOf(request.getParameter("id")));
                request.setAttribute("specification", specification);
                request.setAttribute("processes", processControllerImpl.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/specification.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("specifications", specificationControllerImpl.getAll());
                request.setAttribute("processes", processControllerImpl.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/specifications.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("POST redirect to specification");

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String[] processes = request.getParameterValues("processes");
        List<Process> list = new ArrayList<>();
        for (String process : processes) {
            Process process1 = (Process) processControllerImpl.getForName(process);
            list.add(process1);
        }
        Process[] processesArray = list.toArray(new Process[list.size()]);


        Specification specification = new Specification(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"), processes);

        if (id.isEmpty()) {
            specificationControllerImpl.create(specification);
        } else {
            specificationControllerImpl.update(specification, Integer.parseInt(id));
        }
        response.sendRedirect("specifications");
    }
}
