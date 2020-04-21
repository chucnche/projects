<%-- 
    Document   : ADeditStudent
    Created on : Nov 4, 2019, 8:50:22 PM
    Author     : Chucnc
--%>

<%@page import="dal.RoomDAO"%>
<%@page import="dal.StudentDAO"%>
<%@page import="modal.Student"%>
<%@page import="modal.Room"%>
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
            String user = request.getParameter("user");
            StudentDAO st = new StudentDAO();
            Student stu = st.getStudent(user);
            request.getSession().setAttribute("stuEdit",stu);
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;margin-left:210px;">Sửa thông tin học sinh</span>
                    </br>
                    <div style="margin-left: 180px;" class="col-md-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    --Thông tin--
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form id="frm" action="ADeditStudent" method="POST">
                                    <div class="form-group">
                                        Mã học sinh:<input class="form-control" type="text" name="sID" value="<%=stu.getStuID()%>" readonly="readonly" />
                                    </div>
                                    <div class="form-group">
                                        Họ và tên:<input class="form-control" type="text" name="name" value="<%=stu.getName()%>" />
                                    </div> 
                                    <div class="form-group">
                                        Ngày sinh:<input class="form-control" type="text" name="dob" value="<%=stu.getDob()%>" />
                                    </div>  
                                    <div class="form-group">
                                        <span style="color: #999999;font-size:15px;margin-right: 5px;">Nam</span><input type="radio" name="gender" value="1" checked="checked" />
                                        <span style="margin-left: 20px;color: #999999;font-size:15px;">Nữ</span> <input type="radio" name="gender" value="0" />
                                    </div> 
                                    <div class="form-group">
                                       Phòng:<input class="form-control" type="text" name="room" value="<%=stu.getRoomName().trim()%>" />
                                    </div> 
                                    <div class="form-group">
                                        Giường:<input class="form-control" type="text" name="bed" value="<%=stu.getBedNo()%>" />
                                    </div> 
                                    <button type="submit" class="btn btn-success pull-left">Sửa</button>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>   
    </body>
</html>
