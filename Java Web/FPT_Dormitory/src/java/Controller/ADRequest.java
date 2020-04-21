/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Manager;
import modal.RequestStudent;

/**
 *
 * @author Chucnc
 */
public class ADRequest extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Manager ma = (Manager) request.getSession().getAttribute("ManagerDAO");
        if (ma != null) {
            String id1 = request.getParameter("sID1");
            String type = request.getParameter("type");
            String dobFrom = request.getParameter("from1");
            String dobTo = request.getParameter("to1");
            if (dobFrom == null || dobFrom.equalsIgnoreCase("")) {
                dobFrom = null;
            }
            if (dobTo == null || dobTo.equalsIgnoreCase("")) {
                dobTo = null;
            }
            if (id1 == null || id1.equalsIgnoreCase("")) {
                id1 = "";
            }
            int gt = 2;
            if (type == null) {
                type = "2";
            } else {
                if (type.equalsIgnoreCase("1")) {
                    gt = 1;
                }
                if (type.equalsIgnoreCase("0")) {
                    gt = 0;
                }
            }
            RequestDAO deptDB = new RequestDAO();
            ArrayList<RequestStudent> depts = deptDB.searchRequests(id1, dobFrom, dobTo);
            ArrayList<RequestStudent> dept = new ArrayList();
            for (RequestStudent re : depts) {
                if (gt == 1) {
                    if (re.getMaID() != null && !re.getMaID().isEmpty()) {
                        dept.add(re);
                    }
                } else {
                    if (gt == 0) {
                        if (re.getMaID() == null || re.getMaID().isEmpty()) {
                            dept.add(re);
                        }
                    }
                }
            }
            if (gt == 2) {
                dept = depts;
            }
            String raw_pageindex = request.getParameter("page");
            int check = 0;
            if (raw_pageindex == null) {
                raw_pageindex = "1";
                check = 1;
            }
            int pageindex = Integer.parseInt(raw_pageindex);

            int pagesize = 5;
            int count = dept.size();
            int pagecount = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
            if (check == 1) {
                request.getSession().setAttribute("RequestDAO", dept);
                 request.getSession().setAttribute("pagecountRe", pagecount);
            }
           
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("pagesize", pagesize);
            request.getRequestDispatcher("ADRequest.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/Login").forward(request, response);
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
