/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CustomerDAO;
import dal.InvoiceDAO;
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
public class InvoiceController extends BaseRequiredAuthenticationController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        InvoiceDAO idao = new InvoiceDAO();
        ArrayList<Invoice> i = new ArrayList<>();
        Account a = new Account();
        HttpSession session = request.getSession();
        a = (Account) session.getAttribute("account");
        CustomerDAO cdao = new CustomerDAO();
        ArrayList<Customer> cus = new ArrayList<>();
        cus = cdao.getCusByUser(a.getUser());
        if (cus.size() == 0) {
            String nick = a.getNick();
            request.setAttribute("nick", nick);
            request.setAttribute("a", a);
            request.getRequestDispatcher("book").forward(request, response);
        } else {
            i = idao.getInvoicesByUser(a.getUser());
            if (i.size() == 0) {
                String nick = a.getNick();
                request.setAttribute("nick", nick);
                request.setAttribute("a", a);
//                request.getRequestDispatcher("service").forward(request, response);
                response.sendRedirect("service");
            } else {
                
                String name = request.getParameter("name");
                String id = request.getParameter("rid");
                RoomDAO rdao = new RoomDAO();
                ArrayList<Customer> customers = new ArrayList<>();
                customers = cdao.getCusByUser(a.getUser());
                ServiceDAO sdao = new ServiceDAO();
                ArrayList<Service> services = new ArrayList<>();
                ArrayList<Room> rooms = new ArrayList<>();
                services = sdao.getServices();
                int size = customers.size();
                for (int j = 0; j < customers.size(); j++) {
                    String rid = customers.get(j).getRoom().getRid();
                    Room r = new Room();
                    r = rdao.getRoomByRid(rid);
                    rooms.add(r);
                }
                String check=request.getParameter("check");;
                String nick = a.getNick();
                int sizeroom = rooms.size();
                request.setAttribute("nick", nick);
                request.setAttribute("size", sizeroom);
                request.setAttribute("a", a);
                request.setAttribute("user", a.getUser());
                String sname = a.getName();
                request.setAttribute("name", sname);
                request.setAttribute("rooms", rooms);
                request.setAttribute("services", services);
                request.setAttribute("rid", id);
                request.setAttribute("check", check);
                request.getRequestDispatcher("/view/invoice.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Account a = new Account();

        HttpSession session = request.getSession();
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        String rid = request.getParameter("rid");
        String ridas = request.getParameter("raw_rid");
        String raw_size = request.getParameter("size");
        int size = (raw_size == null||raw_size == "")?0:Integer.parseInt(raw_size);

        ServiceDAO sdao = new ServiceDAO();
        ArrayList<Service> services = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        services = sdao.getServices();
        InvoiceDAO idao = new InvoiceDAO();
        for (int j = 0; j < services.size(); j++) {
            int count = idao.count(services.get(j).getSid());
            int p = count * services.get(j).getPrice();
            prices.add(p);
        }
        RoomDAO rdao = new RoomDAO();
        ArrayList<Customer> customers = new ArrayList<>();
        CustomerDAO cdao = new CustomerDAO();
        customers = cdao.getCusByUser(a.getUser());
        ArrayList<Room> rooms = new ArrayList<>();
        services = sdao.getServices();
        Room r = new Room();
        String check = "co";
        r = rdao.getRoomByRid(rid);
        String num = r.getRoomnum();
        String nick = a.getNick();
        request.setAttribute("nick", nick);
        request.setAttribute("prices", prices);
        request.setAttribute("a", a);
        request.setAttribute("user", a.getUser());
        request.setAttribute("name", name);
        request.setAttribute("rooms", rooms);
        request.setAttribute("services", services);
        request.setAttribute("rid", rid);
        request.setAttribute("num", num);
        request.setAttribute("check", check);
        request.getRequestDispatcher("/view/invoice.jsp").forward(request, response);
    }

}
