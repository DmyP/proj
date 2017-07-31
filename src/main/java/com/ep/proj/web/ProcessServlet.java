package com.ep.proj.web;

import com.ep.proj.controller.ProcessController;
import com.ep.proj.model.Position;
import com.ep.proj.model.Role;
import com.ep.proj.model.Process;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static org.slf4j.LoggerFactory.getLogger;

public class ProcessServlet extends HttpServlet {
    private ProcessController processController;
    private static final Logger log = getLogger(ProcessServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        processController = new ProcessController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("GET redirect to process");

        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                processController.delete(Integer.valueOf(request.getParameter("id")));
                response.sendRedirect("process");
                break;
            case "create":
            case "update":
                final Process process = action.equals("create") ?
                        new Process(null,"", new Position[0]) :
                        processController.get(Integer.valueOf(request.getParameter("id")));
                request.setAttribute("process", process);
                request.setAttribute("positions", Position.values());
                request.getRequestDispatcher("/process.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("processes", processController.getAll());
                request.getRequestDispatcher("/processes.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("POST redirect to process");

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Process process = new Process(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                (Position[]) request.getAttribute("positions"));

        if (id.isEmpty()) {
            processController.create(process);
        } else {
            processController.update(process, Integer.parseInt(id));
        }
        response.sendRedirect("processes");
    }
}
