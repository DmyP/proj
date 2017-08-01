package com.ep.proj.web;

import com.ep.proj.controller.UserControllerImpl;
import com.ep.proj.model.Position;
import com.ep.proj.model.Role;
import com.ep.proj.model.User;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserControllerImpl userControllerImpl;
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        userControllerImpl = new UserControllerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("GET redirect to users");

        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                userControllerImpl.delete(Integer.valueOf(request.getParameter("id")));
                response.sendRedirect("users");
                break;
            case "create":
            case "update":
                final User user = action.equals("create") ?
                        new User(null,"", "", "", null, null, false, LocalDate.now()) :
                        userControllerImpl.get(Integer.valueOf(request.getParameter("id")));
                request.setAttribute("user", user);
                request.setAttribute("roles", Role.values());
                request.setAttribute("positions", Position.values());
                request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("users", userControllerImpl.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("POST redirect to users");

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        User user = new User(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                request.getParameter("password"),
                request.getParameter("email"),
                Role.valueOf(request.getParameter("role")),
                Position.valueOf(request.getParameter("position")),
                request.getParameter("enabled") != null,
                LocalDate.parse(request.getParameter("date")));

        if (id.isEmpty()) {
            userControllerImpl.create(user);
        } else {
            userControllerImpl.update(user, Integer.parseInt(id));
        }
        response.sendRedirect("users");
    }
}
