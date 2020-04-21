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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.QuestionDAO;

/**
 *
 */
public class ManageQuiz extends HttpServlet {

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
            if (user!= null) {

//            check student teacher
//            if student cannot use and notify
                if (user.getRole().equalsIgnoreCase("student")) {
                    request.setAttribute("warning", true);
                } //teacher can use
                else {
                    QuestionDAO qDAO = new QuestionDAO();
//                Get the ID of the question wants to delete
                    int id = 0;
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException e) {
                        id = -1;
                    }
                    qDAO.deleteQuestion(id);
                    int pageSize = 2;
//                get page current
                    int page = 0;
                    try {
                        page = Integer.parseInt(request.getParameter("page"));
                    } catch (NumberFormatException ex) {
                        page = 1;
                    }
                    if (page <= 0) {
                        page = 1;
                    }
//                get numberofQuestion
                    request.setAttribute("numberQuestions", qDAO.getQuestionsByUser(user.getUsername()).size());

//                get list question in page
                    ArrayList<Question> list = qDAO.getQuestionPaging(pageSize, page, user.getUsername());
                    request.setAttribute("listQuestions", list);

                    if (list.size() != 0) {
//                    get number page
                        int numberPage = qDAO.getNumberPages(pageSize, user.getUsername());
                        request.setAttribute("numberPage", numberPage);
                        request.setAttribute("page", page);
                    }
                }
                request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("Home").forward(request, response);
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
