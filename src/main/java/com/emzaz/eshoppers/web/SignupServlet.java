package com.emzaz.eshoppers.web;

import com.emzaz.eshoppers.dtos.UserDTO;
import com.emzaz.eshoppers.repository.UserRepositoryImpl;
import com.emzaz.eshoppers.service.UserService;
import com.emzaz.eshoppers.service.UserServiceImpl;
import com.emzaz.eshoppers.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        Map<String, String> errors = ValidationUtil.getInstance().validate(userDTO);

        if(!errors.isEmpty()){
            req.setAttribute("userDto", userDTO);
            req.setAttribute("errors", errors);
            LOGGER.info("User sent invalid data: {}", userDTO);
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        } else if(userService.isNotUniqueUsername(userDTO)) {
            LOGGER.info("Username: {} is already exist.", userDTO.getUsername());

            errors.put("username", "The username already exists. Please use a different username.");
            req.setAttribute("userDto", userDTO);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        } else if(userService.isNotUniqueEmail(userDTO)) {
            LOGGER.info("Email : {} is already exist.", userDTO.getEmail());

            errors.put("email", "The email is already exist. Please enter a different email.");
            req.setAttribute("userDto", userDTO);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else if(userService.isNotUniqueFirstName(userDTO)) {
            LOGGER.info("FirstName : {} is already exist.", userDTO.getFirstName());

            errors.put("firstName", "The firstName is already exists. Please enter a different firstName.");
            req.setAttribute("userDto", userDTO);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else if(userService.isNotUniqueLastName(userDTO)) {
            LOGGER.info("LastName : {} is already exist.", userDTO.getLastName());

            errors.put("lastName", "The lastName already exists. Please enter a different lastName.");
            req.setAttribute("userDto", userDTO);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/signup.jsp")
                    .forward(req, resp);
        } else {
            LOGGER.info("User is valid, creating a new user with: {}", userDTO);
            userService.saveUser(userDTO);
            resp.sendRedirect("/login");
        }
    }

    private UserDTO copyParametersTo(HttpServletRequest req) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(req.getParameter("username"));
        userDTO.setFirstName(req.getParameter("firstName"));
        userDTO.setLastName(req.getParameter("lastName"));
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setPasswordConfirmed(req.getParameter("passwordConfirmed"));

        return userDTO;
    }
}
