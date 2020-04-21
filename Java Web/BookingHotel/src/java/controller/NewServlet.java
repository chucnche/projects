/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CustomerDAO;
import dal.InvoiceDAO;
import dal.KindorDAO;
import dal.PriceofDAO;
import dal.RoomDAO;
import dal.ServiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Customer;
import model.Invoice;
import model.KindOfRoom;
import model.PriceOfForm;
import model.Room;
import model.Service;

/**
 *
 * @author dell
 */
public class NewServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String sfrom = "2019-11-19";
        String sto = sfrom.substring(0, sfrom.length()-2)+String.valueOf(Integer.parseInt(sfrom.substring(sfrom.length()-2, sfrom.length()))+1);
        Date from = Date.valueOf("2019-11-20");
        Date to = Date.valueOf("2019-11-21");
         RoomDAO rdao = new RoomDAO();
ArrayList<Room> roomdate = new ArrayList();
//roomdate = rdao.paging(1, 3, from, to, "K01", false);
//int count = rdao.count(from, to, null, false);
//response.getWriter().print(count);
response.setContentType("text/html;charset=UTF-8");
        ArrayList<KindOfRoom> kindors = new ArrayList();
        KindorDAO kdao = new KindorDAO();
        PriceofDAO pdao = new PriceofDAO();
        PriceOfForm p = new PriceOfForm();
        p = pdao.getPrice("K02", "F02");
        kindors = kdao.getKindors();
        request.setAttribute("kindors", kindors);
        ServiceDAO sdao = new ServiceDAO();
        ArrayList<Service> services = new ArrayList<>();
        services = sdao.getServices();
        Account a = new Account();
        a = (Account) request.getSession().getAttribute("account");
        CustomerDAO cdao = new CustomerDAO();
        ArrayList<Customer> customers = new ArrayList<>();
        customers = cdao.getCusByUser("abdd");
//        for (Service service : services) {
//            response.getWriter().print(service.getSid());
//        }
        Room r = rdao.getRoomByNum("101");
        InvoiceDAO idao = new InvoiceDAO();
        ArrayList<Invoice> i = new ArrayList<>();
        i = idao.getInvoicesByUser("chuc");
        Customer cs = cdao.getCustomerDelete("chuc", "R01", from, to);
        response.getWriter().print(cs.getAcc().getUser());
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
