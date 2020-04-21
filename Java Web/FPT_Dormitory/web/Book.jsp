<%-- 
    Document   : Book
    Created on : Oct 29, 2019, 7:50:56 PM
    Author     : Chucnc
--%>

<%@page import="modal.Student"%>
<%@page import="modal.Room"%>
<%@page import="java.util.ArrayList"%>
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
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
            String floor = (String) request.getAttribute("floor");
            ArrayList<Room> room = (ArrayList<Room>) request.getAttribute("room");
            Room roomName = (Room) request.getAttribute("roomName");
        %>
        <script>
            function submitFRM()
            {
                document.getElementById("frm").submit();
            }
        </script>
    </head>
    <body>
        <jsp:include page="menu.jsp" />

        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;margin-left:210px;">Đặt chỗ</span>
                    </br>
                    <%
                        if (stu.getDebt() != 0) {
                    %>
                    <span style="color:red;margin-left:210px;">Bạn còn nợ <%=stu.getDebt()%> vnđ.Bạn phải thanh toán thì mới được đặt phòng mới.</span>
                    <!--<button  style="background-color:#999999; border:none;border-radius: 2px;width: 100px;height: 20px;" type="button" class ="btn btn-3 btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">-->
                    <a href="#" data-toggle="modal" data-target=".bs-example-modal-lg" ><span style="color:blue;font-size:15px;">Thanh toán</span></a></br>
                    <i style="font-style: italic;font-size: 13px;color:red;margin-left:210px;">(Nếu bạn có gì thắc mắc hãy liên hệ với người quản lí qua chức năng yêu cầu)</i>
                    <div style="margin-left: 180px;" class="col-md-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    --Thông tin--
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form id="frm" action="book" method="POST">
                                    <div class="form-group">
                                        Mã học sinh:<input class="form-control" type="text" name="sID" value="<%=stu.getStuID()%>" readonly="readonly" />
                                    </div>
                                    <div class="form-group">
                                        Họ và tên:<input class="form-control" type="text" name="name" value="<%=stu.getName()%>" readonly="readonly" />
                                    </div>
                                    <div class="form-group">
                                        Phòng hiện tại:<input class="form-control" type="text" name="sID" value="<%=stu.getRoomName().trim()%>" readonly="readonly" />
                                    </div>
                                    <div class="form-group">
                                        Giường hiện tại:<input class="form-control" type="text" name="name" value="<%=stu.getBedNo()%>" readonly="readonly" />
                                    </div> 
                                </form>
                            </div>

                        </div>
                    </div>
                    <!--</button>-->
                    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                        <div class="modal-dialog modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-lg-5 col-md-5 block-image">
                                            <img src="Login/img/thanhtoan.png" class="img-responsive"/>
                                        </div>
                                        <div style="margin-top: 50px" class="col-lg-6 col-md-6 block-contact">
                                            <h1 style="color: #999999;font-size: 30px;">Số tiền chưa thanh toán</h1>
                                            <form action="Payment" method="POST">
                                                <div class="form-group">
                                                    <input style="color: blueviolet" type="text" name="money" value="<%=stu.getDebt()%> vnđ" readonly="readonly" />
                                                </div>   
                                                
                                                <i style="font-style: italic;font-size: 13px;color:red;">(Tiền sẽ trừ trực tiếp vào tài khoản của bạn)</i>
                                                </br>
                                                <button type="submit" class="btn btn-success pull-left">Thanh toán</button>
                                               
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%} else {
                    %>
                    <div style="margin-left: 180px;" class="col-md-7">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    --Thông tin--
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form id="frm" action="book" method="POST">
                                    <div class="form-group">
                                        Mã học sinh:<input class="form-control" type="text" name="sID" value="<%=stu.getStuID()%>" readonly="readonly" />
                                    </div>
                                    <div class="form-group">
                                        Họ và tên:<input class="form-control" type="text" name="name" value="<%=stu.getName()%>" readonly="readonly" />
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
                                            <option <%=(roomName.getRoomName().trim().equalsIgnoreCase(r.getRoomName().trim()))?"selected":""%> value="<%=r.getRoomName()%>"><%=r.getRoomName()%></option>                                          
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
                                    <button type="submit" class="btn btn-success pull-left">Đặt phòng</button>

                                </form>
                            </div>

                        </div>
                    </div>
                    <%}%>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>        
    </body>
</html>
