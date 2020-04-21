/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.HistoryPaymentDAO;
import dal.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.HistoryPayment;
import modal.Manager;
import modal.Room;

/**
 *
 * @author Chucnc
 */
public class ADRoom extends HttpServlet {

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
            RoomDAO deptDB = new RoomDAO();
            ArrayList<Room> depts = deptDB.getRooms();
            String raw_pageindex = request.getParameter("page");
            int check = 0;
            if (raw_pageindex == null) {
                raw_pageindex = "1";
                check = 1;
            }
            int pageindex = Integer.parseInt(raw_pageindex);

            int pagesize = 10;
            int count = depts.size();
            int pagecount = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
            if (check == 1) {
                request.getSession().setAttribute("RoomDAO", depts);
            }
            request.setAttribute("pagecount", pagecount);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("pagesize", pagesize);
            request.getRequestDispatcher("ADRoom.jsp").forward(request, response);
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
