/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.AccountDAO;
import dal.DBContext;
import dal.ElectricityWaterBillsDAO;
import dal.HistoryBookDAO;
import dal.HistoryPaymentDAO;
import dal.ManagerDAO;
import dal.RequestDAO;
import dal.RoomDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Account;
import modal.ElectricityWaterBills;
import modal.HistoryBook;
import modal.HistoryPayment;
import modal.Room;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class Login extends HttpServlet {

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
        updateFull();
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        String username ="chucnc";
        String password ="chucnc";
        String type = "0";
        AccountDAO account = new AccountDAO();
        ElectricityWaterBillsDAO elb = new ElectricityWaterBillsDAO();
        HistoryBookDAO hb = new HistoryBookDAO();
        HistoryPaymentDAO hp = new HistoryPaymentDAO();
        RequestDAO re = new RequestDAO();
        RoomDAO ro = new RoomDAO();
        StudentDAO st = new StudentDAO();
        ManagerDAO ma = new ManagerDAO();
        Account acc = account.getAccount(username);
        if (acc == null || !acc.getPassword().equals(password) || acc.getType() != Integer.parseInt(type)) {
            request.setAttribute("check", "ac");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {

            request.getSession().setAttribute("account", acc);
            request.getSession().setAttribute("ElectricityWaterBills", elb.getElectricityWaterBills());
            request.getSession().setAttribute("HistoryBookDAO", hb.getHistoryBooks());
            request.getSession().setAttribute("HistoryPaymentDAO", hp.getHistoryPayments());
            request.getSession().setAttribute("RequestDAO", re.getRequests());
            request.getSession().setAttribute("RoomDAO", ro.getRooms());
            if(type.equalsIgnoreCase("1")){
            request.getSession().setAttribute("StudentDAO", st.getStudent(username));
            request.getRequestDispatcher("/HomePage").forward(request, response);
            }
            else{
                request.getSession().setAttribute("ManagerDAO",ma.getManager(username));
                request.getSession().setAttribute("StudentDAOs", st.getStudents());
                request.getRequestDispatcher("/ADPage").forward(request, response);
            }
        }

    }

    public void updateFull() {
        HistoryBookDAO hb = new HistoryBookDAO();
        RoomDAO ro = new RoomDAO();
        StudentDAO st = new StudentDAO();
        DBContext context = new DBContext();
        ArrayList<Room> roomLists = ro.getRooms();
        ArrayList<Student> s = st.getStudents();
        for (Student ss : s) {
            ArrayList<HistoryBook> h = hb.getHistoryBook(ss.getStuID());
            if (context.getDistance(String.valueOf(h.get(h.size() - 1).getDateEx())) >= 0) {
                for (Room r : roomLists) {
                    if (r.getRoomName().trim().equalsIgnoreCase(ss.getRoomName().trim()) && ss.getBedNo()>=1 && ss.getBedNo()<=8) {
                        if (ss.getBedNo() == 1) {
                            r.setBed1(0);
                        }
                        if (ss.getBedNo() == 2) {
                            r.setBed2(0);
                        }
                        if (ss.getBedNo() == 3) {
                            r.setBed3(0);
                        }
                        if (ss.getBedNo() == 4) {
                            r.setBed4(0);
                        }
                        if (ss.getBedNo() == 5) {
                            r.setBed5(0);
                        }
                        if (ss.getBedNo() == 6) {
                            r.setBed6(0);
                        }
                        if (ss.getBedNo() == 7) {
                            r.setBed7(0);
                        }
                        if (ss.getBedNo() == 8) {
                            r.setBed8(0);
                        }
                        ro.updateRoom(r);
                        ss.setBedNo(0);
                        st.updateStudent(ss);
                    }
                }
            }

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
        request.setAttribute("check", "no");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
