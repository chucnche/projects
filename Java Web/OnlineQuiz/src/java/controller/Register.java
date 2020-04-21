/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.UserDAO;

/**
 *
 */
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("Account");
//            check logined or not
//            if not =>register
            if (user == null) {
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } // if logined => comback Home
            else {
                request.getRequestDispatcher("Home").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            String email = request.getParameter("email");
            UserDAO uDAO = new UserDAO();
            // check if username already exist or email existed or email invalid
            if (uDAO.getUserbyUsername(username) != null || uDAO.getUserbyEmail(email) != null || checkEmail(email) == false || username.isEmpty() || password.isEmpty()) {
//                email invalid => notify
                if (checkEmail(email) == false) {
                    request.setAttribute("notify", "***Email invalid(example@mail.com)***");
                }
//                email exsited => notify
                if (uDAO.getUserbyEmail(email) != null) {
                    request.setAttribute("notify", "***Email already exist***");
                }
//               username exsited => notify                
                if (uDAO.getUserbyUsername(username) != null) {
                    request.setAttribute("notify", "***Username already exist***");
                }
//                resend filled infor
                request.setAttribute("username", username);
                request.setAttribute(role, "selected");
                request.setAttribute("email", email);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } //            Correct all requirements
            else {
                // add new user to database
                User user = new User(username, password, email, role);
                uDAO.addNewUser(user);
                request.getRequestDispatcher("Home").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    //check email format
    private boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9+_-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$";
//        if matched, return true
        return email.matches(regex);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
