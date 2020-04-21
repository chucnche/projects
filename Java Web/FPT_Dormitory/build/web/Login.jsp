<%-- 
    Document   : Login
    Created on : Oct 23, 2019, 8:02:38 PM
    Author     : Chucnc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>KTXTHPTLHP</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <!--<link href="Login/css/bootstrap.css" rel="stylesheet">-->
    <!--<link href="Login/css/main.css" rel="stylesheet">-->
    <style><%@include file="Login/css/main.css"%></style>
    <style><%@include file="Login/css/bootstrap.css"%></style>
    <%
            String s= (String)request.getAttribute("check");
    %>
  </head>
  <body background="Login/img/ktxb.jpg">
      <section>
          <div class="container">
              <div  class="row">
                  <h1  style="color: #FF0000;font-size: 60px;margin-left: 30px;margin-top: 150px">Kí Túc Xá Trường THPT Lê Hồng Phong</h1>
                  <button  style="background-color:#999999; border:none;border-radius: 4px; margin-left: 480px;margin-top: 50px;width: 250px;height: 80px;" type="button" class ="btn btn-3 btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">
                      <span style="color:wheat;font-size:40px;">Login</span>
                  </button>
                  <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                      <div class="modal-dialog modal-lg" role="document">
                          <div class="modal-content">
                              <div class="modal-body">
                                  <div class="row">
                                      <div class="col-lg-5 col-md-5 block-image">
                                          <img src="Login/img/login.png" class="img-responsive"/>
                                      </div>
                                      <div style="margin-top: 50px" class="col-lg-6 col-md-6 block-contact">
                                          <h1 style="color: #999999;font-size: 50px;">Login</h1>
                                          <form action="Login" method="POST">
                                              <div class="form-group">
                                                  <input type="text" name="username" class="form-control" placeholder="Username" value="" />
                                              </div>
                                              <div class="form-group">
                                                  <input type="text" name="password" class="form-control" placeholder="Password" value="" />
                                              </div>
                                              <div class="form-group">
                                                 <span style="color: #999999;font-size:15px;">Manager</span> <input  type="radio" name="adstu" value="0" checked="checked" />
                                                 <span style="margin-left: 20px;color: #999999;font-size:15px;">Student</span> <input  type="radio" name="adstu" value="1" />
                                              </div>
                                              <div class="form-group">
                                                  <% if(!s.equalsIgnoreCase("no")){%>
                                                  </br>
                                                  <span style="color: #999999;font-size:15px;">*incorrect user or password or type*</span> 
                                              <%}%>
                                              </div>
                                              <button type="submit" class="btn btn-success pull-left">Login</button>

                                          </form>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </section>
    <script src="Login/js/jquery-3.4.1.js"></script>
    <script src="Login/js/bootstrap.js"></script>
  </body>
</html>
