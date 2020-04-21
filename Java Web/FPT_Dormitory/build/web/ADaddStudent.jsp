<%-- 
    Document   : ADaddStudent
    Created on : Nov 5, 2019, 6:26:49 PM
    Author     : Chucnc
--%>

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
            ArrayList<Room> payLists = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
            String floor = (String) request.getAttribute("floor");
            ArrayList<Room> room = (ArrayList<Room>) request.getAttribute("room");
            Room roomName = (Room) request.getAttribute("roomName");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String sID = request.getParameter("sID");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String money = request.getParameter("money");
        %>
        <script>
            function submitFRM()
            {
                document.getElementById("frm").submit();
            }
        </script>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />

        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;margin-left:210px;">Đặt chỗ</span>
                    <div style="margin-left: 180px;" class="col-md-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    --Thông tin--
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form id="frm" action="ADaddStudent" method="POST">
                                    <%
                                        if(user==null) user="";
                                        if(pass==null) pass="";
                                        if(sID==null) sID="";
                                        if(name==null) name="";
                                        if(dob==null) dob="";
                                        if(gender==null) gender="";
                                        if(money==null) money="";
                                    %>
                                    <div class="form-group">
                                        Tên đăng nhập:<input class="form-control" type="text" name="user" value="<%=user%>" />
                                    </div>
                                    <div class="form-group">
                                        Mật khẩu:<input class="form-control" type="text" name="pass" value="<%=pass%>" />
                                    </div>
                                    <div class="form-group">
                                        Mã học sinh:<input class="form-control" type="text" name="sID" value="<%=sID%>" />
                                    </div>
                                    <div class="form-group">
                                        Họ và tên:<input class="form-control" type="text" name="name" value="<%=name%>"/>
                                    </div> 
                                    <div class="form-group">
                                        Ngày sinh:<input class="form-control" type="text" name="dob" value="<%=dob%>"/>
                                    </div> 
                                    <div class="form-group">
                                        <span style="color: #999999;font-size:15px;margin-right: 5px;">Nam</span><input type="radio" name="gender" value="1" checked="" />
                                        <span style="margin-left: 20px;color: #999999;font-size:15px;">Nữ</span> <input type="radio" name="gender" value="0" />
                                    </div> 
                                    <div class="form-group">
                                        Số dư tài khoản:<input class="form-control" type="text" name="money" value="<%=money%>"/>
                                    </div> 
                                    <div class="form-group">
                                        Chọn tầng:
                                        <select class="form-control" name="floor" onchange="submitFRM();">
                                            <%
                                                if (floor.equalsIgnoreCase("0")) {
                                            %>
                                            <option value="0">--All--</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <%} else{
                                            %>
                                            <option <%=(floor.equalsIgnoreCase("1"))?"selected":""%> value="1">1</option>
                                            <option <%=(floor.equalsIgnoreCase("2"))?"selected":""%> value="1">2</option>
                                            <option <%=(floor.equalsIgnoreCase("3"))?"selected":""%> value="1">3</option>
                                            <option <%=(floor.equalsIgnoreCase("4"))?"selected":""%> value="1">4</option>
                                            <%}%>
                                        </select>
                                    </div>  
                                    <div class="form-group">
                                        Chọn phòng:
                                        <select class="form-control" name="room" onchange="submitFRM();">
                                            <%
                                                if (floor.equalsIgnoreCase("0")) {
                                            %>
                                            <option value="0">--All--</option>
                                            <%}
                                             else {
                                            %>
                                            <option value="0">--All--</option>
                                            <%
                                                for (Room r : room) {
                                                    if(roomName!=null){                                               
                                            %>
                                            <option <%=(roomName.getRoomName().trim().equalsIgnoreCase(r.getRoomName().trim()))?"selected":""%> value="<%=r.getRoomName().trim()%>"><%=r.getRoomName().trim()%></option>                                          
                                            <%}else{
                                            %>
                                            <option value="<%=r.getRoomName().trim()%>"><%=r.getRoomName().trim()%></option>     
                                            <%}
                                                }
                                                }%>
                                        </select>
                                    </div> 
                                    <div class="form-group">
                                        Chọn giường:
                                        <select class="form-control" name="bed">
                                            <%
                                                if (roomName == null) {
                                            %>
                                            <option value="0">--All--</option>
                                            <%}else {
                                            %>
                                            <option value="0">--All--</option>
                                            <%
                                                if (roomName.getBed1() == 0) {
                                            %>
                                            <option value="1">1</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed2() == 0) {
                                            %>
                                            <option value="2">2</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed3() == 0) {
                                            %>
                                            <option value="3">3</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed4() == 0) {
                                            %>
                                            <option value="4">4</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed5() == 0) {
                                            %>
                                            <option value="5">5</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed6() == 0) {
                                            %>
                                            <option value="6">6</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed7() == 0) {
                                            %>
                                            <option value="7">7</option>    
                                            <%}%>
                                            <%
                                                if (roomName.getBed8() == 0) {
                                            %>
                                            <option value="8">8</option>    
                                            <%}%>
                                            <%}%>
                                        </select>
                                    </div> 
                                    <button type="submit" class="btn btn-success pull-left">Tạo học sinh</button>

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
