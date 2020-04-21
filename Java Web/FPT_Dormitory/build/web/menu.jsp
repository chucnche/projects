<%-- 
    Document   : menu
    Created on : Nov 4, 2019, 4:52:46 PM
    Author     : Chucnc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="Login/css/main.css"%></style>
        <style><%@include file="Login/css/bootstrap.css"%></style>
    </head>
    <body>
                <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header col-lg-3 col-md-3">
                    <a class="navbar-brand" href="HomePage.jsp"><span style="color: red">Kí Túc Xá THPT Lê Hồng Phong</span></a>
                </div>
                <ul class="nav navbar-nav">
                <li><a href="book">Đặt Phòng</a></li>
                <li><a href="ElectricityWater">Mức Điện/Nước</a></li>
                <li><a href="HistoryBook">Lịch sử đặt phòng</a></li>
                <li><a href="HistoryPay">Hóa đơn thanh toán</a></li>
                <li><a href="Request">Yêu cầu</a></li>
                <li><a href="room">Thông tin phòng</a></li>
                <li><a href="Logout">Đăng xuất</a></li>
            </ul>
            </div>
        </nav>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
