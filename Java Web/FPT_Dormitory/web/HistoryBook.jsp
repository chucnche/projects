<%-- 
    Document   : HistoryBook.jsp
    Created on : Oct 28, 2019, 10:16:28 PM
    Author     : Chucnc
--%>

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
            ArrayList<HistoryBook> bookLists = (ArrayList<HistoryBook>) request.getSession().getAttribute("HistoryBookDAO");
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;">Xem lịch sử đặt phòng</span>
                    <div style="margin-top: 30px">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th style="width:160px;color:red">Ngày đặt</th>
                                <th style="width:160px;color:red">Ngày hết hạn</th>
                                <th style="width:160px; " >Phòng</th>
                                <th style="width:160px;">Giường</th>
                                <th style="width:160px;">Loại Phòng</th>
                                <th style="width:160px;color:red">Trạng thái</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (HistoryBook s : bookLists) {
                                    if (stu.getStuID().equalsIgnoreCase(s.getStuID())) {
                            %>
                            <tr>
                                <td style="color:red"><%=s.getDateBook()%></td>
                                <td style="color:red"><%=s.getDateEx()%></td>
                                <td><%=s.getRoomName().trim()%></td>
                                <td><%=s.getBedNo()%></td>                                                              
                                <td>8 giường</td>
                                <td style="color:red" >Được chấp nhận</td>
                            </tr>
                            <%}
                                }%>
                        </tbody>
                    </table>
                    </div>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
