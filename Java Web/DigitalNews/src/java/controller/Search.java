/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.ArticleDAO;

/**
 *
 * @author Chucnc
 */
public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageSize = 3;

//            get page current
            int page = 0;
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException ex) {
                page = 1;
            }
            if (page <= 0) {
                page = 1;
            }
            ArticleDAO arDAO = new ArticleDAO();
//            get keyword search
            String search = (String) request.getParameter("search");
            if (search == null || search.isEmpty()) {
                request.setAttribute("found", false);
            } else {
//                  get list search in page current
                ArrayList<Article> listSearch = arDAO.getListSearch(pageSize, page, search);
                request.setAttribute("listSearch", listSearch);
//                  check to find anything or not
                if (listSearch.size() != 0) {
                    request.setAttribute("found", true);
                } else {
                    request.setAttribute("found", false);
                }
//                  Count how many pages in total
                int numberPage = arDAO.getNumberPages(pageSize, search);
                request.setAttribute("numberPage", numberPage);

                request.setAttribute("page", page);
                request.setAttribute("search", search);
            }
//                  get top 1 recent Article
            Article article = arDAO.recentArticle(1).get(0);
            request.setAttribute("mostArticle", article);
//                  get top 5 recent Article
            ArrayList<Article> fiveRecentArticle = arDAO.recentArticle(5);
            request.setAttribute("fiveRecentArticle", fiveRecentArticle);

            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

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
