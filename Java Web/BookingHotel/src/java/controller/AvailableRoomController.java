/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.KindorDAO;
import dal.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.KindOfRoom;
import model.Room;

/**
 *
 * @author dell
 */
public class AvailableRoomController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String kid = request.getParameter("kid");
        String fid = request.getParameter("fid");
        kid = (kid == null || kid.equals("")|| kid.isEmpty())
                ? null : kid;
        Date from = (raw_from == null || raw_from.equals(""))
                ? null : Date.valueOf(raw_from);
        Date to = (raw_to == null || raw_to.equals(""))
                ? null : Date.valueOf(raw_to); 
         KindorDAO kdao = new KindorDAO();
         RoomDAO rdao = new RoomDAO();
         ArrayList<KindOfRoom> kindors = new ArrayList();
         ArrayList<Room> rooms = new ArrayList();
        int pagesize = 1;
        String raw_pageindex = request.getParameter("page");
        if(raw_pageindex == null)
            raw_pageindex = "1";
        int pageindex = Integer.parseInt(raw_pageindex);
        int count = rdao.count(from, to, kid, false);
        int pagecount = (count%pagesize==0)?count/pagesize:count/pagesize + 1;
         rooms = rdao.paging(pageindex, pagesize, from, to, kid, false);
         kindors = kdao.getKindors();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        String nick = a.getNick();
        request.setAttribute("nick", nick);
        request.setAttribute("a", a);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("kid", kid);
        request.setAttribute("fid", fid);
        request.setAttribute("rooms", rooms);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("kindors", kindors);
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("/view/available.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String kid = request.getParameter("kid");
        String fid = request.getParameter("fid");
//        HttpSession session = request.getSession();
        kid = (kid == null || kid.equals("")|| kid.isEmpty())
                ? null : kid;
        Date from = (raw_from == null || raw_from.equals(""))
                ? null : Date.valueOf(raw_from);
        Date to = (raw_to == null || raw_to.equals(""))
                ? null : Date.valueOf(raw_to); 
         KindorDAO kdao = new KindorDAO();
         RoomDAO rdao = new RoomDAO();
         ArrayList<KindOfRoom> kindors = new ArrayList();
         ArrayList<Room> rooms = new ArrayList();
        int pagesize = 1;
        String raw_pageindex = request.getParameter("page");
        if(raw_pageindex == null)
            raw_pageindex = "1";
        int pageindex = Integer.parseInt(raw_pageindex);
        int count = rdao.count(from, to, kid, false);
        int pagecount = (count%pagesize==0)?count/pagesize:count/pagesize + 1;
         rooms = rdao.paging(pageindex, pagesize, from, to, kid, false);
         kindors = kdao.getKindors();
         HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        String nick = a.getNick();
        request.setAttribute("nick", nick);
        request.setAttribute("a", a);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("kid", kid);
        request.setAttribute("fid", fid);
        request.setAttribute("rooms", rooms);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("kindors", kindors);
        request.setAttribute("rooms", rooms);
        for (int i = 0; i < rooms.size(); i++) {
            response.getWriter().print(rooms.get(i).getRid());
        }
        response.getWriter().print(rooms.size());
//        response.getWriter().print(kid);
        
        request.getRequestDispatcher("/view/available.jsp").forward(request, response);
    }

}
