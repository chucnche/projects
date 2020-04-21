<%-- 
    Document   : ADstudent
    Created on : Nov 4, 2019, 8:12:07 PM
    Author     : Chucnc
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="modal.Student"%>
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
            ArrayList<Student> studentLists = (ArrayList<Student>) request.getSession().getAttribute("StudentDAOs");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getSession().getAttribute("pagecountS");
            Integer pagesize = (Integer) request.getAttribute("pagesize");
            String id1 =(String) request.getAttribute("sID1");
            String name =(String)request.getAttribute("name1");
            String room =(String)request.getAttribute("room1");
            String bed =(String)request.getAttribute("bed1");
            String dobFrom =(String)request.getAttribute("from1");
            String dobTo = (String)request.getAttribute("to1");
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
                    <span style="font-size: 35px;">Danh sách học sinh</span>
                    <form id="frm" action="ADstudent" method="POST">
                        <div class="form-group">
                            Mã học sinh:<input style="width: 100px;"  type="text" name="sID1" value=""  />
                            Họ tên:<input style="width: 100px;"  type="text" name="name1" value="" />
                            Phòng:<input style="width: 100px;"  type="text" name="room1" value="" />
                            Giường:<input style="width: 100px;" type="text" name="bed1" value="" />
                            Ngày đặt phòng từ:<input  style="width: 100px;" type="text" name="from1" value="" />
                            đến:<input  style="width: 100px;" type="text" name="to1" value="" />
                        </div> 
                        <div class="form-group">
                            <span style="font-size:15px;margin-right: 5px;">Nam</span><input type="radio" name="gender1" value="1" />
                            <span style="margin-left: 20px;font-size:15px;">Nữ</span> <input type="radio" name="gender1" value="0" />
                            <span style="margin-left: 20px;font-size:15px;">Cả hai</span> <input type="radio" name="gender1" value="2" />
                        </div> 
                        <button type="submit" class="btn btn-success pull-left">Tìm kiếm</button>
                    </form>
                    <form action="ADaddStudent" method="GET">
                        <button style="margin-left: 30px;" type="submit" class="btn btn-success pull-left">Thêm học sinh</button>    
                    </form>
                    <div style="margin-top: 60px">
                        <%=HtmlHelper.pager(pageindex, pagecount, 2)%>
                    </div>
                    <div style="margin-top: 30px">
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th style="width:160px;">Mã học sinh</th>
                                    <th style="width:160px; " >Họ tên</th>
                                    <th style="width:160px;">Ngày sinh</th>
                                    <th style="width:160px;">Giới tính</th>
                                    <th style="width:160px;">Ngày đặt phòng</th>
                                    <th style="width:160px;">Phòng</th>
                                    <th style="width:160px;">Giường</th>
                                    <th style="width:160px;">Số dư tài khoản</th>
                                    <th style="width:160px;">Số nợ</th>
                                    <th style="width:160px;">Edit</th>
                                </tr>
                            </thead>
                            <tbody>
                                    <%
                                        int start = (pageindex - 1) * pagesize + 1;
                                        int end = pagesize * pageindex;
                                    %>
                                    <%        for (int i = start - 1; i < end; i++) {
                                            if (i < studentLists.size()) {

                                    %>
                                <tr>
                                    <td><%=studentLists.get(i).getStuID()%></td>
                                    <td><%=studentLists.get(i).getName()%></td>
                                    <td><%=studentLists.get(i).getDob()%></td> 
                                    <%
                                        String g = "";
                                        if (studentLists.get(i).getGender() == 1) {
                                            g = "nam";
                                        } else {
                                            g = "nữ";
                                        }
                                    %>
                                    <td><%=g%></td>  
                                    <td><%=studentLists.get(i).getBookingDate()%></td>
                                    <td><%=studentLists.get(i).getRoomName().trim()%></td>
                                    <td><%=studentLists.get(i).getBedNo()%></td>
                                    <td><%=studentLists.get(i).getMoneyAccount()%></td>
                                    <td><%=studentLists.get(i).getDebt()%></td>
                                    <td> <a href="ADeditStudent.jsp?user=<%=studentLists.get(i).getUsername()%>">Edit</a> </td>
                                </tr>
                                <%}
                                    }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <script src="Login/js/jquery-3.4.1.js"></script>
        <script src="Login/js/bootstrap.js"></script>
    </body>
</html>
