/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FormorDAO;
import dal.KindorDAO;
import dal.PriceofDAO;
import dal.RoomDAO;
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
import model.FormOfRent;
import model.KindOfRoom;
import model.PriceOfForm;
import model.Room;

/**
 *
 * @author dell
 */
public class BookRoomController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fid = request.getParameter("fid");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String kid = request.getParameter("kid");
        kid = (kid == null || kid.equals("") || kid.isEmpty())
                ? null : kid;
        fid = (fid == null || fid.equals("") || fid.isEmpty())
                ? null : fid;
        Date from = (raw_from == null || raw_from.equals(""))
                ? null : Date.valueOf(raw_from);
        Date to = (raw_to == null || raw_to.equals(""))
                ? null : Date.valueOf(raw_to);
        Account a = new Account();
        a = (Account) request.getSession().getAttribute("account");
        response.getWriter().print(a.getUser());
        KindorDAO kdao = new KindorDAO();
        FormorDAO fdao = new FormorDAO();
        RoomDAO rdao = new RoomDAO();
        ArrayList<KindOfRoom> kindors = new ArrayList();
        ArrayList<Room> rooms = new ArrayList();
        ArrayList<FormOfRent> formors = new ArrayList();
        int pagesize = 1;
        String raw_pageindex = request.getParameter("page");
        if (raw_pageindex == null) {
            raw_pageindex = "1";
        }
        int pageindex = Integer.parseInt(raw_pageindex);
        int count = rdao.count(from, to, kid, false);
        int pagecount = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
        rooms = rdao.paging(pageindex, pagesize, from, to, kid, false);
        kindors = kdao.getKindors();
        formors = fdao.getFormors();
        String nick = a.getNick();
        request.setAttribute("nick", nick);
        request.setAttribute("a", a);
        request.setAttribute("kindors", kindors);
        request.setAttribute("formors", formors);
        request.setAttribute("rooms", rooms);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("kid", kid);
        request.setAttribute("fid", fid);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("pagecount", pagecount);
        request.getRequestDispatcher("/view/book.jsp").forward(request, response);

    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fid = request.getParameter("fid");

        if (fid.equals("F02")) {
            String rid = request.getParameter("rid");
            String raw_from = request.getParameter("fromf01");
            String raw_to = request.getParameter("tof01");
            String kid = request.getParameter("kid");
            kid = (kid == null || kid.equals("") || kid.isEmpty())
                    ? null : kid;
            Date from = (raw_from == null || raw_from.equals(""))
                    ? null : Date.valueOf(raw_from);
            Date to = (raw_to == null || raw_to.equals(""))
                    ? null : Date.valueOf(raw_to);
            Account a = new Account();
            a = (Account) request.getSession().getAttribute("account");
            response.getWriter().print(a.getUser());
            KindorDAO kdao = new KindorDAO();
            PriceofDAO pdao = new PriceofDAO();
            FormorDAO fdao = new FormorDAO();
            RoomDAO rdao = new RoomDAO();
            ArrayList<KindOfRoom> kindors = new ArrayList();
            ArrayList<Room> rooms = new ArrayList();
            PriceOfForm pof = new PriceOfForm();
            ArrayList<FormOfRent> formors = new ArrayList();
            int pagesize = 1;
            String raw_pageindex = request.getParameter("page");
            if (raw_pageindex == null) {
                raw_pageindex = "1";
            }
            int pageindex = Integer.parseInt(raw_pageindex);
            int count = rdao.count(from, to, kid, false);
            int pagecount = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
            rooms = rdao.paging(pageindex, pagesize, from, to, kid, false);
            kindors = kdao.getKindors();
            formors = fdao.getFormors();

            String nick = a.getNick();
            request.setAttribute("nick", nick);
            request.setAttribute("a", a);
            String submit = "submit";
            request.setAttribute("submit", submit);
            request.setAttribute("kindors", kindors);
            request.setAttribute("formors", formors);
            request.setAttribute("rooms", rooms);
            request.setAttribute("from", from);
            request.setAttribute("to", to);
            request.setAttribute("kid", kid);
            request.setAttribute("fid", fid);
            request.setAttribute("rids", rid);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("pagecount", pagecount);
            request.getRequestDispatcher("/view/book.jsp").forward(request, response);
        } else if (fid.equals("F01")) {
            String rid = request.getParameter("rid");
            String raw_from = request.getParameter("fromf02");
            String kid = request.getParameter("kid");
            kid = (kid == null || kid.equals("") || kid.isEmpty())
                    ? null : kid;
            Date from = (raw_from == null || raw_from.equals(""))
                    ? null : Date.valueOf(raw_from);
            String raw_to = raw_from.substring(0, raw_from.length() - 2) + String.valueOf(Integer.parseInt(raw_from.substring(raw_from.length() - 2, raw_from.length())) + 1);
//            response.getWriter().print(raw_to);
            Date to = (raw_to == null || raw_to.equals(""))
                    ? null : Date.valueOf(raw_to);
            Account a = new Account();
            a = (Account) request.getSession().getAttribute("account");
            response.getWriter().print(a.getUser());
            KindorDAO kdao = new KindorDAO();
            PriceofDAO pdao = new PriceofDAO();
            FormorDAO fdao = new FormorDAO();
            RoomDAO rdao = new RoomDAO();
            ArrayList<KindOfRoom> kindors = new ArrayList();
            ArrayList<Room> rooms = new ArrayList();
            ArrayList<FormOfRent> formors = new ArrayList();
            int pagesize = 1;
            String raw_pageindex = request.getParameter("page");
            if (raw_pageindex == null) {
                raw_pageindex = "1";
            }
            int pageindex = Integer.parseInt(raw_pageindex);
            int count = rdao.count(from, to, kid, false);
            int pagecount = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
            rooms = rdao.paging(pageindex, pagesize, from, to, kid, false);
            kindors = kdao.getKindors();
            formors = fdao.getFormors();

            String nick = a.getNick();
            request.setAttribute("nick", nick);
            request.setAttribute("a", a);
            String submit = "submit";
            request.setAttribute("submit", submit);
            request.setAttribute("kindors", kindors);
            request.setAttribute("formors", formors);
            request.setAttribute("rooms", rooms);
            request.setAttribute("from", from);
            request.setAttribute("to", to);
            request.setAttribute("kid", kid);
            request.setAttribute("fid", fid);
            request.setAttribute("rids", rid);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("pagecount", pagecount);
            request.getRequestDispatcher("/view/book.jsp").forward(request, response);
            response.getWriter().print(rid);
        }
    }

}
