package com.emzaz.eshoppers.web;

import com.emzaz.eshoppers.domain.User;
import com.emzaz.eshoppers.dtos.LoginDTO;
import com.emzaz.eshoppers.exceptions.UserNotFoundException;
import com.emzaz.eshoppers.repository.UserRepositoryImpl;
import com.emzaz.eshoppers.service.UserService;
import com.emzaz.eshoppers.service.UserServiceImpl;
import com.emzaz.eshoppers.util.SecurityContext;
import com.emzaz.eshoppers.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    private UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Serving Login Page");
        String logout = req.getParameter("logout");

        if (logout != null && Boolean.parseBoolean(logout)) {
            req.setAttribute("message", "You have been successfully logged out.");
        }

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDTO loginDTO = new LoginDTO(req.getParameter("username"), req.getParameter("password"));

        LOGGER.info("Received login data: {}", loginDTO);

        Map<String, String> errors = ValidationUtil.getInstance().validate(loginDTO);

        if (!errors.isEmpty()) {
            LOGGER.info("Failed to login. Sending login page again.");

            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }

        try {
            login(loginDTO, req);

            LOGGER.info("Login successful, redirecting to the home page.");
            resp.sendRedirect("/home");
        } catch (UserNotFoundException e) {
            LOGGER.error("Incorrect username/password", e);

            errors.put("username", "Incorrect username/password");
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }

    private void login(LoginDTO loginDTO, HttpServletRequest req) throws UserNotFoundException{
        User user = userService.verifyUser(loginDTO);

        SecurityContext.login(req, user);
    }
}
