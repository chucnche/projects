<%-- 
    Document   : ADHistoryBook
    Created on : Nov 6, 2019, 9:50:03 PM
    Author     : Chucnc
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="modal.HistoryBook"%>
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
            ArrayList<HistoryBook> billsLists = (ArrayList<HistoryBook>) request.getSession().getAttribute("HistoryBookDAO");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getSession().getAttribute("pagecountHB");
            Integer pagesize = (Integer) request.getAttribute("pagesize");
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row"  style="margin-top: 60px;margin-left: 160px;">
                    <div class="col-lg-10 col-md-10">
                        <span style="color:red;font-size: 20px;font-family:'Times New Roman'">Lịch sử đặt phòng/chuyển phòng của học sinh</span>
                        <form style="margin-top: 30px;" id="frm" action="ADHistoryBook" method="POST">
                            <div class="form-group">
                                <button  type="submit" class="btn btn-success pull-left">Tìm kiếm</button>
                                <span style="margin-left: 20px;">Phòng:</span><input style="width: 100px;"  type="text" name="room1" value="" />
                                Ngày từ:<input  style="width: 100px;" type="text" name="from1" value="" />
                                đến:<input  style="width: 100px;" type="text" name="to1" value="" />
                            </div> 
                        </form> 
                        <div style="margin-top: 30px">
                            <%=HtmlHelper.pagerHisBooks(pageindex, pagecount, 2)%>
                        </div>
                        <div  style="margin-top: 20px;" class="form-group">
                            <table  class="table table-bordered table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th style="width:160px;color:blue">Mã sinh viên</th>
                                        <th style="width:160px;color:red">Ngày đặt</th>
                                        <th style="width:160px;color:red">Ngày hết hạn</th>
                                        <th style="width:160px; " >Phòng</th>
                                        <th style="width:160px;">Giường</th>
                                        <th style="width:160px;">Loại Phòng</th>
                                        <th style="width:160px;color:red">Trạng thái</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        int start = (pageindex - 1) * pagesize + 1;
                                        int end = pagesize * pageindex;
                                    %>
                                    <%        for (int i = start - 1; i < end; i++) {
                                            if (i < billsLists.size()) {

                                    %>
                                    <tr>
                                        <td style="color:blue"><%=billsLists.get(i).getStuID()%></td>
                                        <td style="color:red"><%=billsLists.get(i).getDateBook()%></td>
                                        <td style="color:red"><%=billsLists.get(i).getDateEx()%></td>
                                        <td><%=billsLists.get(i).getRoomName().trim()%></td>
                                        <td><%=billsLists.get(i).getBedNo()%></td>                                                              
                                        <td>8 giường</td>
                                        <td style="color:red" >Được chấp nhận</td>
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
