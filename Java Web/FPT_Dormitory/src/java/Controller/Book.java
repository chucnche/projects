/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
import modal.HistoryBook;
import modal.HistoryPayment;
import modal.Room;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class Book extends  BaseRequiredAuthenticationController {

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
        request.setAttribute("floor","0");
        RoomDAO rD = new RoomDAO();
        ArrayList<Room> r = rD.getRooms();
        request.setAttribute("room",r);
        request.setAttribute("roomName",r.get(0));
        request.getRequestDispatcher("Book.jsp").forward(request, response);
    }
      public void roomBedUpdate(HttpServletRequest request, HttpServletResponse response,String room,int bed,String newRoom,int newbed){
          ArrayList<Room> roomLists = (ArrayList<Room>)request.getSession().getAttribute("RoomDAO");
          RoomDAO roomDAO = new RoomDAO();
          for (Room r:roomLists) {
              if(r.getRoomName().trim().equalsIgnoreCase(room) && bed>=1 && bed<=8){
                  if(bed==1){
                      r.setBed1(0);
                  }
                  if(bed==2){
                      r.setBed2(0);
                  }
                  if(bed==3){
                      r.setBed3(0);
                  }
                  if(bed==4){
                      r.setBed4(0);
                  }
                  if(bed==5){
                      r.setBed5(0);
                  }
                  if(bed==6){
                      r.setBed6(0);
                  }
                  if(bed==7){
                      r.setBed7(0);
                  }
                  if(bed==8){
                      r.setBed8(0);
                  }
                  roomDAO.updateRoom(r);
              }
          }
        for (Room r:roomLists) {
              if(r.getRoomName().trim().equalsIgnoreCase(newRoom.trim())){
                  if(newbed==1){
                      r.setBed1(1);
                  }
                  if(newbed==2){
                      r.setBed2(1);
                  }
                  if(newbed==3){
                      r.setBed3(1);
                  }
                  if(newbed==4){
                      r.setBed4(1);
                  }
                  if(newbed==5){
                      r.setBed5(1);
                  }
                  if(newbed==6){
                      r.setBed6(1);
                  }
                  if(newbed==7){
                      r.setBed7(1);
                  }
                  if(newbed==8){
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

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               processRequest(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String floor = request.getParameter("floor");
        String room = request.getParameter("room");
        String bed = request.getParameter("bed");
        if(!floor.equalsIgnoreCase("0") && room.equalsIgnoreCase("0") && bed.equalsIgnoreCase("0")){
            ArrayList<Room> r = (ArrayList<Room>)request.getSession().getAttribute("RoomDAO");
            ArrayList<Room> r1 = new ArrayList();
            for(Room ro:r){
                if(ro.getRoomName().trim().charAt(1)==floor.charAt(0)){
                    r1.add(ro);
                }
            }
            request.setAttribute("room", r1);
            request.setAttribute("floor",floor);
            request.getRequestDispatcher("Book.jsp").forward(request, response);
        }
        if(!floor.equalsIgnoreCase("0") && !room.equalsIgnoreCase("0") && bed.equalsIgnoreCase("0")){
            ArrayList<Room> r = (ArrayList<Room>)request.getSession().getAttribute("RoomDAO");
            ArrayList<Room> r1 = new ArrayList();
            Room n=new Room();
            for(Room ro:r){
                if(ro.getRoomName().trim().charAt(1)==floor.charAt(0)){
                    r1.add(ro);
                }
                if(ro.getRoomName().trim().equalsIgnoreCase(room.trim())) n=ro;
            }
            request.setAttribute("floor",floor);
            request.setAttribute("room", r1);
            request.setAttribute("roomName",n);
            request.getRequestDispatcher("Book.jsp").forward(request, response);
        }
        StudentDAO s = new StudentDAO();
        HistoryBookDAO hb = new HistoryBookDAO();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateBook = simpleDateFormat.format(Calendar.getInstance().getTime());
        HistoryPaymentDAO hp = new HistoryPaymentDAO();
        if(!floor.equalsIgnoreCase("0") && !room.equalsIgnoreCase("0") && !bed.equalsIgnoreCase("0")){
            DBContext context = new DBContext();
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
            ArrayList<HistoryBook> bookList =hb.getHistoryBook(stu.getStuID());
             HistoryBook h =bookList.get(bookList.size()-1);

            if(context.getDistance(String.valueOf(bookList.get(bookList.size()-1).getDateEx()))<0){
                roomBedUpdate(request, response,stu.getRoomName().trim(),stu.getBedNo(), room,Integer.parseInt(bed));
                stu.setRoomName(room);
                stu.setBedNo(Integer.parseInt(bed));
                s.updateStudent(stu);
                h.setBedNo(Integer.parseInt(bed));
                h.setRoomName(room);
                h.setDateBook(Date.valueOf(dateBook));
                hb.insertHistoryBook(h);
                request.getSession().setAttribute("StudentDAO",stu);
                request.getSession().setAttribute("HistoryBookDAO", hb.getHistoryBooks());
            }
            else{
                stu.setBookingDate(Date.valueOf(dateBook));
                stu.setRoomName(room);
                stu.setBedNo(Integer.parseInt(bed));
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH, 5);
                String da = simpleDateFormat.format(cal.getTime());
                if(dateBook.substring(0,4).equalsIgnoreCase(da.substring(0,4))){
                    da=dateBook.substring(0,4)+"-06-01";
                }
                else{
                    int i = Integer.parseInt(dateBook.substring(0,4))+1;
                    da=String.valueOf(i)+"-01-01";
                }
                long d=0-context.getDistance(da);
                long b=d%30;
                long a = d/30;
                int moneyPay=0;
                if(b>10 &&b<=20){
                    moneyPay =(int)(450000*(a+0.5));
                }
                if(b>0 && b<=10){
                    moneyPay =(int)(450000*(a));
                }
                if(b>20 && b<=31){
                    moneyPay =(int)(450000*(a+1));
                }
                if(stu.getMoneyAccount()>=moneyPay){
                    stu.setMoneyAccount(stu.getMoneyAccount()-moneyPay);
                    s.updateStudent(stu);
                    h.setBedNo(Integer.parseInt(bed));
                    h.setRoomName(room);
                    h.setDateBook(Date.valueOf(dateBook));
                    h.setDateEx(Date.valueOf(da));
                    hb.insertHistoryBook(h);
                    HistoryPayment hi = new HistoryPayment(stu.getStuID(),Date.valueOf(dateBook),"tiền phòng",moneyPay,room);
                    hp.insertHistoryPayment(hi);
                    roomBedUpdate(request, response,stu.getRoomName().trim(),stu.getBedNo(), room,Integer.parseInt(bed));
                    request.getSession().setAttribute("StudentDAO",stu);
                    request.getSession().setAttribute("HistoryBookDAO", hb.getHistoryBooks());
                    request.getSession().setAttribute("HistoryPaymentDAO", hp.getHistoryPayments());
                    RoomDAO ro = new RoomDAO();
                    request.getSession().setAttribute("RoomDAO", ro.getRooms());
                }
                else{
                    request.getRequestDispatcher("Recharge.jsp").forward(request, response);
                }
            }
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }
        if(floor.equalsIgnoreCase("0") && room.equalsIgnoreCase("0") && bed.equalsIgnoreCase("0")){
        request.setAttribute("floor","0");
        ArrayList<Room> r = (ArrayList<Room>)request.getSession().getAttribute("RoomDAO");
        request.setAttribute("room",r);
        request.setAttribute("roomName",r.get(0));
        request.getRequestDispatcher("Book.jsp").forward(request, response);
        }
    }

}
