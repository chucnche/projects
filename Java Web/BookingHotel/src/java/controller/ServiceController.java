/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CustomerDAO;
import dal.RoomDAO;
import dal.ServiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Customer;
import model.Invoice;
import model.Room;
import model.Service;

/**
 *
 * @author dell
 */
public class ServiceController extends HttpServlet {

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
        String id = request.getParameter("rid");
        Account a = new Account();
        a = (Account) request.getSession().getAttribute("account");
        if (a != null) {
            CustomerDAO cdao = new CustomerDAO();
            RoomDAO rdao = new RoomDAO();
            ArrayList<Customer> customers = new ArrayList<>();
            customers = cdao.getCusByUser(a.getUser());
            ServiceDAO sdao = new ServiceDAO();
            String error = null;
            if (customers.isEmpty()) {
                error = "Quý khách làm ơn đặt phòng trước khi đặt dịch vụ";
            }
            ArrayList<Service> services = new ArrayList<>();
            ArrayList<Room> rooms = new ArrayList<>();
            services = sdao.getServices();
            int size = customers.size();
            for (int i = 0; i < customers.size(); i++) {
                String rid = customers.get(i).getRoom().getRid();
                Room r = new Room();
                r = rdao.getRoomByRid(rid);
                rooms.add(r);
            }

            String nick = a.getNick();
            request.setAttribute("nick", nick);
            request.setAttribute("a", a);
            request.setAttribute("services", services);
            request.setAttribute("rooms", rooms);
            request.setAttribute("rid", id);
            request.setAttribute("a", a);
            request.setAttribute("size", size);
            request.setAttribute("customers", customers);
            request.setAttribute("error", error);
            request.getRequestDispatcher("/view/service.jsp").forward(request, response);
            response.getWriter().print(rooms.size());
        } else {
            ServiceDAO sdao = new ServiceDAO();
            ArrayList<Service> services = new ArrayList<>();
            services = sdao.getServices();
            if (a != null) {
                String nick = a.getNick();
                request.setAttribute("nick", nick);
            }
            request.setAttribute("services", services);
            request.setAttribute("a", a);
            request.getRequestDispatcher("/view/service.jsp").forward(request, response);
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
        String rid = request.getParameter("rid");
        String sid = request.getParameter("sid");
        Account a = new Account();
        a = (Account) request.getSession().getAttribute("account");
        CustomerDAO cdao = new CustomerDAO();
        RoomDAO rdao = new RoomDAO();
        ServiceDAO sdao = new ServiceDAO();
        ArrayList<Customer> customers = new ArrayList<>();
        Room rooms = new Room();
        customers = cdao.getCusByUser(a.getUser());
        rooms = rdao.getRoomByRid(rid);
        Service s = sdao.getServiceBySid(sid);
        Invoice invoice = new Invoice(a, s, rooms, null);
        response.getWriter().print(rid);
        sdao.insertInvoice(invoice);
        if (a != null) {
            String nick = a.getNick();
            request.setAttribute("nick", nick);
            request.setAttribute("a", a);
        }
        response.sendRedirect("home");
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
