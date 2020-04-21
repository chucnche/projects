/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.RequestStudent;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class Request  extends BaseRequiredAuthenticationController{

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
        request.getRequestDispatcher("Request.jsp").forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);  }

    @Override
    protected void processPost(HttpServletRequest re, HttpServletResponse response) throws ServletException, IOException {
        re.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String s = re.getParameter("requestStu");
        if(s==null || s.equalsIgnoreCase("")){
            re.getRequestDispatcher("Request.jsp").forward(re, response);
        }
        else{
        Student stu = (Student)re.getSession().getAttribute("StudentDAO");
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endDate = simpleDateFormat.format(Calendar.getInstance().getTime());
        RequestStudent r = new RequestStudent();
        r.setRequestID(1);
        r.setStuID(stu.getStuID());
        r.setDateRequest(endDate);
        r.setRequest(s);
        RequestDAO req = new RequestDAO();
        RequestDAO reDAO = new RequestDAO();
        req.insertRequest(r);
        re.getSession().setAttribute("RequestDAO", reDAO.getRequests());
        re.getRequestDispatcher("Request.jsp").forward(re, response);
        }    }

}
