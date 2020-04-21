<%-- 
    Document   : header
    Created on : Oct 31, 2019, 9:22:13 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </head>

    <body>
        <nav class="navbar navbar-expand-lg  text-warning bg-dark static-top">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home" style="padding-left: 10%">
                    <img src="image/logo.png" alt="" style="width: 80%"/>
                </a>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="nav-item active" style="padding: 0 15px 0 15px">
                            <a class="nav-link" href="${pageContext.request.contextPath}/home">Trang chủ
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item" style="padding: 0 15px 0 15px">
                            <a class="nav-link" href="${pageContext.request.contextPath}/about">Giới Thiệu</a>
                        </li>
                        <li class="nav-item" style="padding: 0 15px 0 15px">
                            <a class="nav-link" href="${pageContext.request.contextPath}/kind">Loại Phòng</a>
                        </li>
                        <li class="nav-item" style="padding: 0 15px 0 15px">
                            <a class="nav-link" href="${pageContext.request.contextPath}/service">Dịch Vụ</a>
                        </li>
                        <li class="nav-item" style="padding: 0 15px 0 15px">
                            <a class="nav-link" href="${pageContext.request.contextPath}/invoice">Hóa Đơn</a>
                        </li>
                        <!--                        <li class="nav-item" style="padding: 0 15px 0 15px">
                                                    <a class="nav-link" href="#" style="color: black;">Liên Hệ</a>
                                                </li>-->
                        <li class="nav-item" style="padding: 0 15px 0 15px">
                            <a class="nav-link" href="${pageContext.request.contextPath}/book" >Đặt Phòng</a>
                        </li>
                    </ul>
                            <c:if test="${requestScope.a==null}">
                    <ul class="nav navbar-nav navbar-right " style="padding-left: 50px">
                        <li style="padding: 0 10px 0 10px" class="nav-item" ><a href="${pageContext.request.contextPath}/signup" class="nav-link"><span class="glyphicon glyphicon-user"></span> Đăng Ký</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/login" class="nav-link"><span class="glyphicon glyphicon-log-in"></span> Đăng Nhập</a></li>
                    </ul></c:if>
                            <c:if test="${requestScope.a!=null}">
                    <ul class="nav navbar-nav navbar-right " style="padding-left: 50px">
                        <li style="padding: 0 10px 0 10px" class="nav-item" ><a href="#" class="nav-link"><span class="glyphicon glyphicon-user"></span>${requestScope.nick}</a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/logout" class="nav-link"><span class="glyphicon glyphicon-log-in"></span> Đăng Xuất</a></li>
                    </ul></c:if>
                </div>
        </nav>

                    
    </body>

</html>
