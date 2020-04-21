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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ADaddBills extends HttpServlet {

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
            request.getRequestDispatcher("ADaddBills.jsp").forward(request, response);
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
        String room = request.getParameter("room");
        String dien = request.getParameter("sodien");
        String nuoc = request.getParameter("sonuoc");
        if (room == null || dien == null || nuoc == null) {
            request.getRequestDispatcher("/ADElectricityWater").forward(request, response);
        } else {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            String da = simpleDateFormat.format(Calendar.getInstance().getTime());
            da = da + "-30";
            ElectricityWaterBills e = new ElectricityWaterBills();
            int d = Integer.parseInt(dien);
            int n = Integer.parseInt(nuoc);
            e.setRoomName(room);
            e.setMonthYear(Date.valueOf(da));
            e.setSoDien(d);
            e.setSoNuoc(n);
            e.setPaid(1);
            ElectricityWaterBillsDAO elb = new ElectricityWaterBillsDAO();
            elb.insertBill(e);
            if (d > 0 || n > 0) {
                int t = d * 2000 + n * 6000;
                StudentDAO st = new StudentDAO();
                ArrayList<Student> stu = st.getStudents();
                ArrayList<Student> student = new ArrayList();
                int i = 0;
                for (Student s : stu) {

                    if (s.getRoomName().trim().equalsIgnoreCase(room.trim())) {
                        student.add(s);
                    }
                }
                int debt = t;
                if (student.size() != 0) {
                    debt = t / student.size();
                }
                for (Student s1 : student) {
                    s1.setDebt(s1.getDebt() + debt);
                    st.updateStudent(s1);
                }
                request.getSession().setAttribute("StudentDAOs", st.getStudents());
            }
            request.getSession().setAttribute("ElectricityWaterBills", elb.getElectricityWaterBills());
            request.getRequestDispatcher("/ADElectricityWater").forward(request, response);
        }
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
