<%-- 
    Document   : ADRoom
    Created on : Nov 6, 2019, 10:34:39 PM
    Author     : Chucnc
--%>

<%@page import="util.HtmlHelper"%>
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
        <style><%@include file="Login/css/paging.css"%></style>
        <%
            ArrayList<Room> billsLists = (ArrayList<Room>) request.getSession().getAttribute("RoomDAO");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getAttribute("pagecount");
            Integer pagesize = (Integer) request.getAttribute("pagesize");
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row"  style="margin-top: 60px;margin-left: 160px;">
                    <div class="col-lg-10 col-md-10">
                        <span style="color:red;font-size: 20px;font-family:'Times New Roman'">Danh sách các phòng</span>
                        </br>
                        <button  style="margin-top: 20px;background-color:#999999; border:none;border-radius: 4px;" type="button" class ="btn btn-3 btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">
                            <span style="color:wheat;font-size:15px;">Thêm phòng</span>
                        </button>  
                        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <div class="row">
                                            <div style="margin-top: 60px;" class="col-lg-4 col-md-4 block-image">
                                                <img src="Login/img/room1.png" class="img-responsive"/>
                                            </div>
                                            <div style="margin-top: 40px" class="col-lg-4 col-md-4 block-contact">
                                                <h1 style="color: #999999;font-size: 30px;">Tạo phòng mới</h1>                
                                                <form action="ADaddRoom" method="POST">
                                                    <div class="form-group">
                                                        <span style="color: #999999;font-size:15px;margin-right: 5px;">Tên phòng</span><input class="form-control"  type="text" name="name" value=""  />
                                                    </div> 
                                                    <div class="form-group">
                                                        <span style="color: #999999;font-size:15px;margin-right: 5px;">Nam</span><input type="radio" name="gender" checked="checked" value="1" />
                                                        <span style="color: #999999;margin-left: 20px;font-size:15px;">Nữ</span> <input type="radio" name="gender" value="0" />
                                                    </div>           
                                                    <button type="submit" class="btn btn-success pull-left">Tạo</button>

                                                </form>
                                            </div>
                                            <div style="margin-top: 60px;" class="col-lg-4 col-md-4 block-image">
                                                <img src="Login/img/room2.png" class="img-responsive"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="margin-top: 30px">
                            <%=HtmlHelper.pagerRooms(pageindex, pagecount, 2)%>
                        </div>
                        <div  style="margin-top: 20px;" class="form-group">
                            <table  class="table table-bordered table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Tên phòng</th>
                                        <th>Tổng Số Giường</th>
                                        <th style="color:red ">Giường Trống</th>
                                        <th style="color:blue ">Giường đã sử dụng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        int start = (pageindex - 1) * pagesize + 1;
                                        int end = pagesize * pageindex;
                                    %>
                                    <%        for (int i = start - 1; i < end; i++) {
                                            if (i < billsLists.size()) {
                                                String s1 = "";
                                                String s2 = "";
                                                if (billsLists.get(i).getBed1() == 1) {
                                                    s1 = s1 + "1,";
                                                } else {
                                                    s2 = s2 + "1,";
                                                }
                                                if (billsLists.get(i).getBed2() == 1) {
                                                    s1 = s1 + "2,";
                                                } else {
                                                    s2 = s2 + "2,";
                                                }
                                                if (billsLists.get(i).getBed3() == 1) {
                                                    s1 = s1 + "3,";
                                                } else {
                                                    s2 = s2 + "3,";
                                                }
                                                if (billsLists.get(i).getBed4() == 1) {
                                                    s1 = s1 + "4,";
                                                } else {
                                                    s2 = s2 + "4,";
                                                }
                                                if (billsLists.get(i).getBed5() == 1) {
                                                    s1 = s1 + "5,";
                                                } else {
                                                    s2 = s2 + "5,";
                                                }
                                                if (billsLists.get(i).getBed6() == 1) {
                                                    s1 = s1 + "6,";
                                                } else {
                                                    s2 = s2 + "6,";
                                                }
                                                if (billsLists.get(i).getBed7() == 1) {
                                                    s1 = s1 + "7,";
                                                } else {
                                                    s2 = s2 + "7,";
                                                }
                                                if (billsLists.get(i).getBed8() == 1) {
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
                                        <td><%=billsLists.get(i).getRoomName().trim()%></td>
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
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
