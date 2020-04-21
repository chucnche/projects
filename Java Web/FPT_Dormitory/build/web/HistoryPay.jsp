<%-- 
    Document   : HistoryPay
    Created on : Oct 28, 2019, 9:39:56 PM
    Author     : Chucnc
--%>

<%@page import="modal.Student"%>
<%@page import="modal.HistoryPayment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="Login/css/main.css"%></style>
        <style><%@include file="Login/css/bootstrap.css"%></style>
       <%
            ArrayList<HistoryPayment> payLists = (ArrayList<HistoryPayment>) request.getSession().getAttribute("HistoryPaymentDAO");
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;">Xem lịch sử hóa đơn đã thanh toán</span>
                    <div style="margin-top: 30px">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th style="width:160px;">Phòng</th>
                                <th style="width:160px; " >Mã học Sinh</th>
                                <th style="width:160px;">Ngày tạo</th>
                                <th style="width:160px;color:red">Loại</th>
                                <th style="width:160px;">Tổng tiền thanh toán</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (HistoryPayment s : payLists) {
                                    if (stu.getStuID().equalsIgnoreCase(s.getStuID())) {
                            %>
                            <tr>
                                <td><%=s.getRoom()%></td>
                                <td><%=s.getStuID()%></td>
                                <td><%=s.getDatePay()%></td>                               
                                <td style="color:red "><%=s.getType()%></td>
                                <td><%=s.getMoneyPay()%></td>
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
