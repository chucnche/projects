/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.RoomDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Manager;
import modal.Room;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class ADeditStudent extends HttpServlet {

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
            String name = request.getParameter("name");
            Date dob = Date.valueOf(request.getParameter("dob"));
            int gender = Integer.parseInt(request.getParameter("gender"));
            String room = request.getParameter("room");

            int bed = Integer.parseInt(request.getParameter("bed"));
            Student stu = (Student) request.getSession().getAttribute("stuEdit");
            stu.setName(name);
            stu.setDob(dob);
            stu.setGender(gender);
            RoomDAO ro = new RoomDAO();
            StudentDAO st = new StudentDAO();
            Room r = ro.getRoom(room);
            String s = "ADeditStudent.jsp?user=" + stu.getUsername();
            if (r == null || r.getGender() != gender) {
                request.getRequestDispatcher(s).forward(request, response);
            } else {
                if (bed >= 1 && bed <= 8) {
                    if ((bed == 1 && r.getBed1() == 1) || (bed == 2 && r.getBed2() == 1) || (bed == 3 && r.getBed3() == 1) || (bed == 4 && r.getBed4() == 1)
                            || (bed == 5 && r.getBed5() == 1) || (bed == 6 && r.getBed6() == 1) || (bed == 7 && r.getBed7() == 1) || (bed == 8 && r.getBed8() == 1)) {
                        stu.setRoomName(room);
                        stu.setBedNo(bed);
                        st.updateStudent(stu);
                        request.getRequestDispatcher("/ADstudent").forward(request, response);
                    } else {
                        roomBedUpdate(request, response, stu.getRoomName(), stu.getBedNo(), room, bed);
                        stu.setRoomName(room);
                        stu.setBedNo(bed);
                        st.updateStudent(stu);
                        request.getSession().setAttribute("RoomDAO", ro.getRooms());
                        request.getRequestDispatcher("/ADstudent").forward(request, response);

                    }
                } else {
                    st.updateStudent(stu);
                    request.getRequestDispatcher("/ADstudent").forward(request, response);
                }
            }
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

    public void roomBedUpdate(HttpServletRequest request, HttpServletResponse response, String room, int bed, String newRoom, int newbed) {
        ArrayList<Room> roomLists = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
        RoomDAO roomDAO = new RoomDAO();
        for (Room r : roomLists) {
            if (r.getRoomName().trim().equalsIgnoreCase(room)) {
                if (bed == 1) {
                    r.setBed1(0);
                }
                if (bed == 2) {
                    r.setBed2(0);
                }
                if (bed == 3) {
                    r.setBed3(0);
                }
                if (bed == 4) {
                    r.setBed4(0);
                }
                if (bed == 5) {
                    r.setBed5(0);
                }
                if (bed == 6) {
                    r.setBed6(0);
                }
                if (bed == 7) {
                    r.setBed7(0);
                }
                if (bed == 8) {
                    r.setBed8(0);
                }
                roomDAO.updateRoom(r);
            }
        }
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
}
