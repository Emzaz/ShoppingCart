package com.emzaz.eshoppers.web;

import com.emzaz.eshoppers.dtos.UserDTO;
import com.emzaz.eshoppers.repository.UserRepositoryImpl;
import com.emzaz.eshoppers.service.UserService;
import com.emzaz.eshoppers.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignupServlet.class);

    private UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Serving Sign Up Servlet");

        req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = copyParametersTo(req);

        if(isValid(userDTO)){
            LOGGER.info("User is valid, creating a new user with: {}", userDTO);
            userService.saveUser(userDTO);
            resp.sendRedirect("/home");
        } else {
            LOGGER.info("User sent invalid data: {}", userDTO);
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        }
    }

    private boolean isValid(UserDTO userDTO) {
        return true;
    }

    private UserDTO copyParametersTo(HttpServletRequest req) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(req.getParameter("username"));
        userDTO.setFirstName(req.getParameter("firstName"));
        userDTO.setLastName(req.getParameter("lastName"));
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setPasswordConfirmed(req.getParameter("passwordConfirmed"));

        return userDTO;
    }
}
