/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.QuestionDAO;
import modal.UserDAO;

/**
 *
 */
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("Account");
            //check login
            //if don't login=>go to login page
            if (user == null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                //login first time
                if (username == null || password == null) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
//                 check wrong pass or user
                    UserDAO u =new UserDAO();
                    User us= u.getUserbyUsername(username);
                    //username wrong=> comeback Login page
                    if(us==null){
                        request.setAttribute("notify","*Wrong username*");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                    else{
                        //password correct=> go to index (welcome)
                        if(us.getPassword().equals(password)){
                            request.getSession().setAttribute("Account", us);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
//                        wrong pass=>comback login
                        else{
                            request.setAttribute("notify","*Wrong password*");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
