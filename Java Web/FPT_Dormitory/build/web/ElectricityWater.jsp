<%-- 
    Document   : ElectricityWater
    Created on : Oct 29, 2019, 8:32:11 AM
    Author     : Chucnc
--%>

<%@page import="modal.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modal.ElectricityWaterBills"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="Login/css/main.css"%></style>
        <style><%@include file="Login/css/bootstrap.css"%></style>
       <%
            ArrayList<ElectricityWaterBills> billsLists = (ArrayList<ElectricityWaterBills>) request.getSession().getAttribute("ElectricityWaterBills");
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row"  style="margin-top: 100px;margin-left: 160px;">
                    <div class="col-lg-10 col-md-10">
                    <span style="color:red;font-size: 20px;font-family:'Times New Roman'">Thông tin số điện/nước vượt mức sử dụng</span>
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Tên phòng</th>
                                <th>Tháng năm</th>
                                <th style="color:red ">Số điện vượt mức</th>
                                <th style="color:blue ">Số nước vượt mức</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (ElectricityWaterBills s : billsLists) {
                                    if (stu.getRoomName().trim().equalsIgnoreCase(s.getRoomName().trim())) {
                            %>
                            <tr>
                                <td><%=s.getRoomName().trim()%></td>
                                <td><%=s.getMonthYear()%></td>
                                <td style="color:red "><%=s.getSoDien()%></td>
                                <td style="color:blue "><%=s.getSoNuoc()%></td>
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
