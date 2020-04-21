<%-- 
    Document   : Payment
    Created on : Oct 29, 2019, 8:09:09 PM
    Author     : Chucnc
--%>

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
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;margin-left:210px;">Nạp tiền</span>
                    </br>
                   <i style="font-style: italic;font-size: 13px;color:red;margin-left:210px;">(Tiền của bạn không đủ để thanh toán.Hãy nạp thêm tiền)</i>
                    <div style="margin-left: 180px;" class="col-md-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    --Nạp tiền--
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form  action="Recharge" method="POST">
                                    <div class="form-group">
                                    Số dư tài khoản:<input class="form-control" type="text" name="money" value="<%=stu.getMoneyAccount()%>VNĐ" disabled="disabled" />
                                    </div>
                                    <div class="form-group">
                                    Số tiền nạp:<input class="form-control" type="text" name="nap" value="" />
                                    </div>
                                    <button type="submit" class="btn btn-success pull-left">Nạp</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!--</button>-->
                </div>
            </div>
        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
