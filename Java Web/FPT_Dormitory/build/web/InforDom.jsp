<%-- 
    Document   : InforDom
    Created on : Oct 28, 2019, 4:52:30 PM
    Author     : Chucnc
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="modal.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modal.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="Login/css/main.css"%></style>
        <style><%@include file="Login/css/bootstrap.css"%></style>
        <%
            ArrayList<Room> roomLists = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 100px;">
                    <%  DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String endDate = simpleDateFormat.format(Calendar.getInstance().getTime());
                        String g="";
                        if(stu.getGender()==1) g = "nam";
                        else g="nu";
                    %>
                    <span style="color:red;font-size: 20px;font-family:'Times New Roman'">Chi tiết từng giường của Kí Túc Xá THPT Lê Hồng Phong cho giới tính:<%=g%></span>
                    </br>
                    <span>Thời gian truy cập: <%=endDate%></span>
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Tên phòng</th>
                                <th>Tổng Số Giường</th>
                                <th style="color:red ">Giường Trống</th>
                                <th style="color:blue ">Giường đã sử dụng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Room s : roomLists) {
                                    if (stu.getGender() == s.getGender()) {
                                        String s1 = "";
                                        String s2 = "";
                                        if (s.getBed1() == 1) {
                                            s1 = s1 + "1,";
                                        } else {
                                            s2 = s2 + "1,";
                                        }
                                        if (s.getBed2() == 1) {
                                            s1 = s1 + "2,";
                                        } else {
                                            s2 = s2 + "2,";
                                        }
                                        if (s.getBed3() == 1) {
                                            s1 = s1 + "3,";
                                        } else {
                                            s2 = s2 + "3,";
                                        }
                                        if (s.getBed4() == 1) {
                                            s1 = s1 + "4,";
                                        } else {
                                            s2 = s2 + "4,";
                                        }
                                        if (s.getBed5() == 1) {
                                            s1 = s1 + "5,";
                                        } else {
                                            s2 = s2 + "5,";
                                        }
                                        if (s.getBed6() == 1) {
                                            s1 = s1 + "6,";
                                        } else {
                                            s2 = s2 + "6,";
                                        }
                                        if (s.getBed7() == 1) {
                                            s1 = s1 + "7,";
                                        } else {
                                            s2 = s2 + "7,";
                                        }
                                        if (s.getBed8() == 1) {
                                            s1 = s1 + "8,";
                                        } else {
                                            s2 = s2 + "8,";
                                        }
                                        if (s1.length() >= 1) {
                                            s1 = s1.substring(0, s1.length() - 1);
                                        }
                                        if (s2.length() >= 1) {
                                            s2 = s2.substring(0, s2.length() - 1);
                                        }
                                       
                            %>
                            <tr>
                                <td><%=s.getRoomName().trim()%></td>
                                <td>8</td>
                                <td style="color:red "><%=s2%></td>
                                <td style="color:blue "><%=s1%></td>
                            </tr>
                            <%}
                                }%>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
