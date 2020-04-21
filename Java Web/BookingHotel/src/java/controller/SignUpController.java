/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author dell
 */
public class SignUpController extends HttpServlet {

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
        AccountDAO adao = new AccountDAO();
        ArrayList<Account> acc = new ArrayList<>();
        boolean check = false;
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String nick = request.getParameter("nick");
        String name = request.getParameter("name");
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateBook = simpleDateFormat.format(Calendar.getInstance().getTime());
        Date dob = Date.valueOf(dateBook);
        int cmnd = Integer.parseInt(request.getParameter("cmnd"));
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String job = request.getParameter("job");
        String gender = request.getParameter("gender");
        int money = Integer.parseInt(request.getParameter("money"));
        boolean bgender;
        if (gender.equals("Nam")) {
            bgender = true;
        } else {
            bgender = false;
        }
        Account checkacc = adao.getAccountByUser(user);
        if (checkacc == null) {
            adao.insertAccount(new Account(cmnd, phone, money, 1, user, pass, nick, name, address, job, bgender, dob));
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        } else {

            String error = "Tên tài khoản đã tồn tại";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/view/signup.jsp").forward(request, response);
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
        request.getRequestDispatcher("/view/signup.jsp").forward(request, response);
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
