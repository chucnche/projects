<%-- 
    Document   : login
    Created on : Nov 3, 2019, 3:22:48 PM
    Author     : dell
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            background: url(image/bgdangky.PNG) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
            -o-background-size: cover;
        }
    </style>
    <body>
        <div>
                    
                        <jsp:include page="header.jsp"></jsp:include>
        </div>
        <div class="container" style="padding-top: 100px;"> 

            <div class="cotainer">
                <div class="row justify-content-center">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="card-header">Đăng Ký</div>
                            <div class="card-body">
                                <form action="login" method="post" id="login">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="form-group row">
                                                    <label for="usernam" class="col-md-4 col-form-label text-md-right">Tên đăng nhập</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="username" class="form-control" name="username" required autofocus>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="password" class="col-md-4 col-form-label text-md-right">Mật khẩu</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="password" class="form-control" name="password" required>
                                                    </div>
                                                </div>


                                            </div>
                                            <div class="col-sm-12">
                                                <div class="form-group row justify-content-center">
                                                    <div class="col-md-6 offset-md-4">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" name="remember"> Remember Me
                                                            </label>
                                                        </div>
                                                    </div>


                                                    <div class="col-md-6 offset-md-4">
                                                        <button type="submit" class="btn btn-primary">
                                                            Đăng nhập
                                                        </button>
                                                        <a href="${pageContext.request.contextPath}/view/signup.jsp" class="btn btn-primary">
                                                            Đăng ký
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
