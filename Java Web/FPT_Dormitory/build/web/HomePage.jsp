<%-- 
    Document   : HomePage
    Created on : Oct 23, 2019, 8:56:57 PM
    Author     : Chucnc
--%>

<%@page import="dal.DBContext"%>
<%@page import="modal.HistoryBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modal.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="Login/css/main.css"%></style>
        <style><%@include file="Login/css/bootstrap.css"%></style>
        <%
            Student s = (Student) request.getSession().getAttribute("StudentDAO");
            ArrayList<HistoryBook> h =(ArrayList<HistoryBook>)request.getSession().getAttribute("HistoryBookofStudent");
            DBContext context = new DBContext();
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 100px;margin-left: 200px;">
                    <span style="color:red;font-size: 30px;font-family:'Times New Roman'">Thông tin học sinh</span>
                    </br>
                    <font color="green">(nếu thông tin của bạn không chính xác,bạn hãy yêu cầu sửa lại tại phòng quản lí ktx hoặc sử dụng chức năng yêu cầu online)</font>
                    <table class="table table-bordered table-striped table-hover">
                        <tbody>
                            <tr>
                                <th style="width: 160px;">Mã học sinh</th>
                                <td><%=s.getStuID()%></td>
                            </tr>
                            <tr>
                                <th>Tên đăng nhập</th>
                                <td><%=s.getUsername()%></td>                                
                            </tr>
                            <tr>
                                <th>Họ và Tên</th>
                                <td><%=s.getName()%></td>                                
                            </tr>
                            <tr>
                                <th>Ngày sinh</th>
                                <td><%=s.getDob()%></td>                                
                            </tr>
                            <tr>
                                <th>Giới tính</th>
                                <%
                                String g="";
                                if(s.getGender()==1) g="nam";
                                else g="nữ";
                                %>
                                <td><%=g%></td>                                
                            </tr>
                            <tr>
                                <th>Phòng hiện tại</th>
                                <td><%=s.getRoomName().trim()%></td>                                
                            </tr> 
                            <tr>
                                <th>Giường hiện tại</th>
                                <td><%=s.getBedNo()%></td>                                
                            </tr>
                            <tr>
                                <th>Ngày đặt</th>
                                <td><%=s.getBookingDate()%></td>                                
                            </tr>   
                            <tr>
                                <th>Số dư tài khoản</th>
                                <td><%=s.getMoneyAccount()%></td>                                
                            </tr>  
                            <tr>
                                <th>Số nợ chưa thanh toán</th>
                                <td><%=s.getDebt()%></td>                            
                            </tr> 
                            <tr>
                                <th>Hạn phòng</th>
                                <%
                                 if (context.getDistance(String.valueOf(h.get(h.size() - 1).getDateEx())) >= 0) {
                                %>
                                <td style="color:red;">Đã hết hạn</td>   
                                <%}else{
                                 %>    
                                 <td style="color:red;">Còn hạn</td>
                                 <%}%>
                            </tr> 
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
