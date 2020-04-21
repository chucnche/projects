<%-- 
    Document   : Admenu
    Created on : Nov 4, 2019, 5:56:50 PM
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
                    <a class="navbar-brand" href="ADPage.jsp"><span style="color: red">Quản lí KTX THPT Lê Hồng Phong</span></a>
                </div>
                <ul class="nav navbar-nav">
                <li><a href="ADstudent">Học sinh</a></li>
                <li><a href="ADElectricityWater">Mức Điện/Nước</a></li>
                <li><a href="ADHistoryBook">Lịch sử đặt phòng</a></li>
                <li><a href="ADHistoryPay">Hóa đơn thanh toán</a></li>
                <li><a href="ADRequest">Yêu cầu</a></li>
                <li><a href="ADRoom">Thông tin phòng</a></li>
                <li><a href="Logout">Đăng xuất</a></li>
            </ul>
            </div>
        </nav>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
