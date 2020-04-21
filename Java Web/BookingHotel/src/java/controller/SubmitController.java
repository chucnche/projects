/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import dal.CustomerDAO;
import dal.FormorDAO;
import dal.KindorDAO;
import dal.PriceofDAO;
import dal.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Customer;
import model.FormOfRent;
import model.KindOfRoom;
import model.PriceOfForm;
import model.Room;

/**
 *
 * @author dell
 */
public class SubmitController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        Date from = Date.valueOf(request.getParameter("subfrom"));
        Date to = Date.valueOf(request.getParameter("subto"));
        String rid = request.getParameter("subrid");
        String roomnum = request.getParameter("subroomnum");
        String kid = request.getParameter("subkid");
        String kind = request.getParameter("subkind");
        String fid = request.getParameter("subfid");
        String form = request.getParameter("subform");
        String error = request.getParameter("error");
        HttpSession session = request.getSession();
        Account acc = (Account)session.getAttribute("account");
        PriceofDAO pdao = new PriceofDAO();
        int price = pdao.getPrice(kid, fid).getPrice();
        Room rooms = new Room();
        RoomDAO rdao = new RoomDAO();
        rooms = rdao.getRoomByRid(rid);
        roomnum = rooms.getRoomnum();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(from);
        c2.setTime(to);
        // Công thức tính số ngày giữa 2 mốc thời gian:
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        int priceday = Integer.parseInt(String.valueOf(price*noDay));
        if(acc.getMoney()<priceday) error = "Số tiền trong tài khoản của bạn không đủ";
        else error = "";
        request.setAttribute("accounts", acc);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("kid", kid);
        request.setAttribute("rid", rid);
        request.setAttribute("roomnum", roomnum);
        request.setAttribute("kind", kind);
        request.setAttribute("fid", fid);
        request.setAttribute("form", form);
        request.setAttribute("price", price);
        request.setAttribute("error", error);
        response.getWriter().print(kid);
        
        response.getWriter().print(error);
        
        request.getRequestDispatcher("/view/submit.jsp").forward(request, response);

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
        request.setCharacterEncoding("UTF-8");
        Date from = Date.valueOf(request.getParameter("subfrom"));
        Date to = Date.valueOf(request.getParameter("subto"));
        String kid = request.getParameter("subkid");
        String rid = request.getParameter("subrid");
        String kind = request.getParameter("subkind");
        String fid = request.getParameter("subfid");
        String form = request.getParameter("subform");
        HttpSession session = request.getSession();
        Account acc = (Account)session.getAttribute("account");
        PriceofDAO pdao = new PriceofDAO();
        int price = pdao.getPrice(kid, fid).getPrice();
        Account accup = new Account();
        accup = acc;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(from);
        c2.setTime(to);
        // Công thức tính số ngày giữa 2 mốc thời gian:
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        int priceday = Integer.parseInt(String.valueOf(price*noDay));
        accup.setMoney(acc.getMoney()-priceday);
        KindorDAO kdao = new KindorDAO();
        RoomDAO rdao = new RoomDAO();
        AccountDAO adao = new AccountDAO();
        FormorDAO fdao = new FormorDAO();
        KindOfRoom kindor = kdao.getKindByKid(kid);
        FormOfRent formor = fdao.getFormByFid(fid);
        Room rooms = rdao.getRoomByRid(rid);
        CustomerDAO cdao = new CustomerDAO();
        Customer customer = new Customer(acc, rooms, from, to, formor);
        cdao.insertCustomer(customer);
        adao.updateAccount(accup);
        rooms.setStatus(true);
        rdao.updateRoom(rooms);
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
