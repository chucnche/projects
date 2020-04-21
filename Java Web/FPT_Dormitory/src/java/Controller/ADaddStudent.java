/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.AccountDAO;
import dal.DBContext;
import dal.HistoryBookDAO;
import dal.HistoryPaymentDAO;
import dal.RoomDAO;
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
import modal.Account;
import modal.HistoryBook;
import modal.HistoryPayment;
import modal.Manager;
import modal.Room;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class ADaddStudent extends HttpServlet {

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
            request.setAttribute("floor", "0");
            RoomDAO rD = new RoomDAO();
            ArrayList<Room> r = rD.getRooms();
            request.setAttribute("room", r);
            request.setAttribute("roomName", r.get(0));
            request.getRequestDispatcher("ADaddStudent.jsp").forward(request, response);
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String sID = request.getParameter("sID");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String money = request.getParameter("money");
        String floor = request.getParameter("floor");
        String room = request.getParameter("room");
        String bed = request.getParameter("bed");
        if (!floor.equalsIgnoreCase("0") && room.equalsIgnoreCase("0") && bed.equalsIgnoreCase("0")) {
            ArrayList<Room> r = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
            ArrayList<Room> r1 = new ArrayList();
            for (Room ro : r) {
                if (ro.getRoomName().trim().charAt(1) == floor.charAt(0)) {
                    r1.add(ro);
                }
            }
            request.setAttribute("user", user);
            request.setAttribute("pass", pass);
            request.setAttribute("sID", sID);
            request.setAttribute("name", name);
            request.setAttribute("dob", dob);
            request.setAttribute("gender", gender);
            request.setAttribute("money", money);
            request.setAttribute("room", r1);
            request.setAttribute("floor", floor);
            request.getRequestDispatcher("ADaddStudent.jsp").forward(request, response);
        }
        if (!floor.equalsIgnoreCase("0") && !room.equalsIgnoreCase("0") && bed.equalsIgnoreCase("0")) {
            ArrayList<Room> r = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
            ArrayList<Room> r1 = new ArrayList();
            Room n = new Room();
            for (Room ro : r) {
                if (ro.getRoomName().trim().charAt(1) == floor.charAt(0)) {
                    r1.add(ro);
                }
                if (ro.getRoomName().trim().equalsIgnoreCase(room)) {
                    n = ro;
                }
            }
            request.setAttribute("floor", floor);
            request.setAttribute("room", r1);
            request.setAttribute("roomName", n);
            request.getRequestDispatcher("ADaddStudent.jsp").forward(request, response);
        }
        HistoryBookDAO hb = new HistoryBookDAO();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateBook = simpleDateFormat.format(Calendar.getInstance().getTime());
        HistoryPaymentDAO hp = new HistoryPaymentDAO();
        if (!floor.equalsIgnoreCase("0") && !room.equalsIgnoreCase("0") && !bed.equalsIgnoreCase("0")) {
            if (user != null && pass != null && sID != null && name != null && dob != null && gender != null && money != null) {
                DBContext context = new DBContext();
                AccountDAO ac = new AccountDAO();
                StudentDAO students = new StudentDAO();
                Account account = ac.getAccount(user);
                Student student = students.getStudentById(sID);
                Student stu = new Student();
                Account acNew = new Account();
                HistoryBook his = new HistoryBook();
                if (account == null && student == null) {
                    stu.setStuID(sID);
                    stu.setUsername(user);
                    stu.setName(name);
                    stu.setDob(Date.valueOf(dob));
                    stu.setGender(Integer.parseInt(gender));
                    stu.setBookingDate(Date.valueOf(dateBook));
                    stu.setRoomName(room);
                    stu.setBedNo(Integer.parseInt(bed));
                    stu.setMoneyAccount(Integer.parseInt(money));
                    stu.setDebt(0);
                    acNew.setUsername(user);
                    acNew.setPassword(pass);
                    ac.insertAccount(acNew);
                    students.insertStudent(stu);
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.MONTH, 5);
                    String da = simpleDateFormat.format(cal.getTime());
                    if (dateBook.substring(0, 4).equalsIgnoreCase(da.substring(0, 4))) {
                        da = dateBook.substring(0, 4) + "-06-01";
                    } else {
                        int i = Integer.parseInt(dateBook.substring(0, 4)) + 1;
                        da = String.valueOf(i) + "-01-01";
                    }
                    long d = 0 - context.getDistance(da);
                    long b = d % 30;
                    long a = d / 30;
                    int moneyPay = 0;
                    if (b > 10 && b <= 20) {
                        moneyPay = (int) (450000 * (a + 0.5));
                    }
                    if (b > 0 && b <= 10) {
                        moneyPay = (int) (450000 * (a));
                    }
                    if (b > 20 && b <= 31) {
                        moneyPay = (int) (450000 * (a + 1));
                    }
                    his.setStuID(sID);
                    his.setBookID(0);
                    his.setDateBook(Date.valueOf(dateBook));
                    his.setRoomName(room);
                    his.setBedNo(Integer.parseInt(bed));
                    his.setDateEx(Date.valueOf(da));
                    hb.insertHistoryBook(his);
                    HistoryPayment hi = new HistoryPayment(sID, Date.valueOf(dateBook), "tiền phòng", moneyPay, room);
                    hp.insertHistoryPayment(hi);
                    roomBedUpdate(request, response, room, Integer.parseInt(bed));
                    request.getSession().setAttribute("StudentDAOs", students.getStudents());
                    request.getSession().setAttribute("HistoryBookDAO", hb.getHistoryBooks());
                    request.getSession().setAttribute("HistoryPaymentDAO", hp.getHistoryPayments());
                    RoomDAO ro = new RoomDAO();
                    request.getSession().setAttribute("RoomDAO", ro.getRooms());
                    request.getRequestDispatcher("/ADstudent").forward(request, response);
                } else {
                    fail(request, response, user, pass, sID, name, dob, gender, money);
                }
            } else {
                fail(request, response, user, pass, sID, name, dob, gender, money);
            }
        }
        if (floor.equalsIgnoreCase("0") && room.equalsIgnoreCase("0") && bed.equalsIgnoreCase("0")) {
            fail(request, response, user, pass, sID, name, dob, gender, money);
        }
    }

    public void fail(HttpServletRequest request, HttpServletResponse response, String user, String pass, String sID, String name, String dob, String gender, String money) throws ServletException, IOException {
        request.setAttribute("user", user);
        request.setAttribute("pass", pass);
        request.setAttribute("sID", sID);
        request.setAttribute("name", name);
        request.setAttribute("dob", dob);
        request.setAttribute("gender", gender);
        request.setAttribute("money", money);
        request.setAttribute("floor", "0");
        ArrayList<Room> r = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
        request.setAttribute("room", r);
        request.setAttribute("roomName", r.get(0));
        request.getRequestDispatcher("ADaddStudent.jsp").forward(request, response);
    }

    public void roomBedUpdate(HttpServletRequest request, HttpServletResponse response, String newRoom, int newbed) {
        ArrayList<Room> roomLists = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
        RoomDAO roomDAO = new RoomDAO();
        for (Room r : roomLists) {
            if (r.getRoomName().trim().equalsIgnoreCase(newRoom)) {
                if (newbed == 1) {
                    r.setBed1(1);
                }
                if (newbed == 2) {
                    r.setBed2(1);
                }
                if (newbed == 3) {
                    r.setBed3(1);
                }
                if (newbed == 4) {
                    r.setBed4(1);
                }
                if (newbed == 5) {
                    r.setBed5(1);
                }
                if (newbed == 6) {
                    r.setBed6(1);
                }
                if (newbed == 7) {
                    r.setBed7(1);
                }
                if (newbed == 8) {
                    r.setBed8(1);
                }
                roomDAO.updateRoom(r);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
