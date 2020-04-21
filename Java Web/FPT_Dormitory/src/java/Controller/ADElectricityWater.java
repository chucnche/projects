/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.ElectricityWaterBillsDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ElectricityWaterBills;
import modal.Manager;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class ADElectricityWater extends HttpServlet {

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
        Manager ma = (Manager)request.getSession().getAttribute("ManagerDAO");
        if(ma!=null){
        String room = request.getParameter("room1");
        String dobFrom = request.getParameter("from1");
        String dobTo = request.getParameter("to1");

        if(dobFrom==null ||dobFrom.equalsIgnoreCase("")) dobFrom=null;
        if(dobTo==null || dobTo.equalsIgnoreCase("")) dobTo=null;
        if(room==null) room="";
        ElectricityWaterBillsDAO deptDB = new ElectricityWaterBillsDAO();
        ArrayList<ElectricityWaterBills> depts = deptDB.searchBills(room, dobFrom, dobTo);
        String raw_pageindex = request.getParameter("page");
        int check=0;
        if(raw_pageindex == null){
            raw_pageindex = "1";
            check=1;
        }
        int pageindex = Integer.parseInt(raw_pageindex);

        int pagesize =10;     
        int count =depts.size();
        int pagecount = (count%pagesize==0)?count/pagesize:count/pagesize + 1;  
        if(check==1){
        request.getSession().setAttribute("ElectricityWaterBills",depts);  
        request.getSession().setAttribute("pagecountE", pagecount);
        }

        request.setAttribute("pageindex", pageindex);
        request.setAttribute("pagesize", pagesize);
        request.getRequestDispatcher("ADElectricityWater.jsp").forward(request, response);
        }
        else
        request.getRequestDispatcher("/Login").forward(request, response);  
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
