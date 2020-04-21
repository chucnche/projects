/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.HistoryPaymentDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.HistoryPayment;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class Payment extends BaseRequiredAuthenticationController {

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
        Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        StudentDAO s = new StudentDAO();
        HistoryPaymentDAO h = new HistoryPaymentDAO();
        if (stu.getMoneyAccount() >= stu.getDebt()) {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String endDate = simpleDateFormat.format(Calendar.getInstance().getTime());
            HistoryPayment hi = new HistoryPayment(stu.getStuID(), Date.valueOf(endDate), "phụ trội", stu.getDebt(), stu.getRoomName());
            stu.setMoneyAccount(stu.getMoneyAccount() - stu.getDebt());
            stu.setDebt(0);
            s.updateStudent(stu);
            h.insertHistoryPayment(hi);
            HistoryPaymentDAO hp = new HistoryPaymentDAO();
            request.getSession().setAttribute("StudentDAO", stu);
            request.getSession().setAttribute("HistoryPaymentDAO", hp.getHistoryPayments());
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Recharge.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
