<%-- 
    Document   : ADPage
    Created on : Nov 4, 2019, 6:03:36 PM
    Author     : Chucnc
--%>

<%@page import="modal.Manager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="Login/css/main.css"%></style>
        <style><%@include file="Login/css/bootstrap.css"%></style>
        <%
            Manager s = (Manager) request.getSession().getAttribute("ManagerDAO");
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 100px;margin-left: 200px;">
                    <span style="color:red;font-size: 30px;font-family:'Times New Roman'">Thông tin người quản lí</span>
                    </br>
                    <font color="green">(quản lí có trách nghiệm chỉnh sửa thông tin chính xác và phản hồi yêu cầu của học sinh)</font>
                    <table class="table table-bordered table-striped table-hover">
                        <tbody>
                            <tr>
                                <th style="width: 160px;">Mã quản lí</th>
                                <td><%=s.getMaID()%></td>
                            </tr>
                            <tr>
                                <th>Tên đăng nhập</th>
                                <td><%=s.getUsername()%></td>                                
                            </tr>
                            <tr>
                                <th>Họ và Tên</th>
                                <td><%=s.getName()%></td>                                
                            </tr>
                            <tr>
                                <th>Ngày sinh</th>
                                <td><%=s.getDob()%></td>                                
                            </tr>
                            <tr>
                                <th>Giới tính</th>
                                <%
                                String g="";
                                if(s.getGender()==1) g="nam";
                                else g="nữ";
                                %>
                                <td><%=g%></td>                                
                            </tr>
                            <tr>
                                <th>Mail</th>
                                <td><%=s.getMail()%></td>                                
                            </tr> 
                            <tr>
                                <th>Số điện thoại</th>
                                <td><%=s.getPhoneNumber()%></td>                                
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
