<%-- 
    Document   : signup
    Created on : Nov 1, 2019, 9:31:10 PM
    Author     : dell
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <%
            ArrayList<Account> accounts = (ArrayList<Account>) session.getAttribute("accounts");
        %>
        <script>
            function haha(){
                var user = document.getElementById("username").value;
                var pass = document.getElementById("password").value;
                var name = document.getElementById("name").value;
                var cmnd = document.getElementById("cmnd").value;
                var phone = document.getElementById("phone").value;
                var nick = document.getElementById("nick").value;
                var repass = document.getElementById("repassword").value;
                var date = document.getElementById("date").value;
                var address = document.getElementById("address").value;
                var job = document.getElementById("job").value;
                var money = document.getElementById("money").value;
                if(user == null || pass == null || name == null || cmnd == null || phone == null || nick == null || repass == null || date == null || address == null || address == null ||job == null || money == null||date == ""){
                    alert("Not null");
                }
                else if(pass !== repass) {
                    alert("Re-Pass giống pass");
                }
                
                else document.getElementById("signup").submit();
            }
        </script>
        
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
                                <form action="signup" method="post" id="signup">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group row">
                                                    <label for="username" class="col-md-4 col-form-label text-md-right">Tên đăng nhập</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="username" class="form-control" name="username" required autofocus>
                                                    </div>
                                                    <div style="color: red">${requestScope.error}</div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="password" class="col-md-4 col-form-label text-md-right">Mật khẩu</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="password" class="form-control" name="password" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="name" class="col-md-4 col-form-label text-md-right">Họ và tên</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="name" class="form-control" name="name" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="cmnd" class="col-md-4 col-form-label text-md-right">CMND</label>
                                                    <div class="col-md-6">
                                                        <input type="number" id="cmnd" class="form-control" name="cmnd" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="phone" class="col-md-4 col-form-label text-md-right">Số điện thoại</label>
                                                    <div class="col-md-6">
                                                        <input type="number" id="phone" class="form-control" name="phone" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="gender" class="col-md-4 col-form-label text-md-right">Giới tính</label>

                                                    <div class="col-md-6">
                                                        Nam <input type="radio" name="gender" value="nam" checked="checked" />
                                                        Nữ <input type="radio" name="gender" value="nữ" checked="checked" />
                                                        <!--                                                <input type="checkbox" id="repassword" class="form-control" name="nick" required>-->
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group row">
                                                    <label for="nick" class="col-md-4 col-form-label text-md-right">Nick Name</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="nick" class="form-control" name="nick" required autofocus>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="repassword" class="col-md-4 col-form-label text-md-right">Re - mật khẩu</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="repassword" class="form-control" name="repassword" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="date" class="col-md-4 col-form-label text-md-right">Ngày </label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="date" class="form-control" name="date" required>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label for="address" class="col-md-4 col-form-label text-md-right">Địa chỉ</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="address" class="form-control" name="address" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="job" class="col-md-4 col-form-label text-md-right">Nghề nghiệp</label>
                                                    <div class="col-md-6">
                                                        <input type="text" id="job" class="form-control" name="job" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="money" class="col-md-4 col-form-label text-md-right">Số tiền</label>
                                                    <div class="col-md-6">
                                                        <input type="number" id="money" class="form-control" name="money" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6 offset-md-4">
<!--                                                <button type="submit" class="btn btn-primary">
                                                    Register
                                                </button>-->
<!--                                                <input type="submit" value="Register"  class="btn btn-primary"/>-->
                                                <input type="button" value="Đăng Ký" onclick="haha()" class="btn btn-primary"/>
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
