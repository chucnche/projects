<%-- 
    Document   : ADHistoryPay
    Created on : Nov 6, 2019, 10:07:10 PM
    Author     : Chucnc
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modal.HistoryPayment"%>
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
            ArrayList<HistoryPayment> billsLists = (ArrayList<HistoryPayment>) request.getSession().getAttribute("HistoryPaymentDAO");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getSession().getAttribute("pagecountPay");
            Integer pagesize = (Integer) request.getAttribute("pagesize");
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row"  style="margin-top: 60px;margin-left: 160px;">
                    <div class="col-lg-10 col-md-10">
                        <span style="color:red;font-size: 20px;font-family:'Times New Roman'">Lịch sử thanh toán của học sinh</span>
                        <form style="margin-top: 30px;" id="frm" action="ADHistoryPay" method="POST">
                            <div class="form-group">
                                <button  type="submit" class="btn btn-success pull-left">Tìm kiếm</button>
                                <span style="margin-left: 20px;">Phòng:</span><input style="width: 100px;"  type="text" name="room1" value="" />
                                Ngày từ:<input  style="width: 100px;" type="text" name="from1" value="" />
                                đến:<input  style="width: 100px;" type="text" name="to1" value="" />
                            </div> 
                        </form> 
                        <div style="margin-top: 30px">
                            <%=HtmlHelper.pagerHisPays(pageindex, pagecount, 2)%>
                        </div>
                        <div  style="margin-top: 20px;" class="form-group">
                            <table  class="table table-bordered table-striped table-hover">
                                <thead>
                            <tr>
                                <th style="width:160px;">Phòng</th>
                                <th style="width:160px; " >Mã học Sinh</th>
                                <th style="width:160px;">Ngày tạo</th>
                                <th style="width:160px;color:red">Loại</th>
                                <th style="width:160px;">Tổng tiền thanh toán</th>
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
                                <td><%=billsLists.get(i).getRoom()%></td>
                                <td><%=billsLists.get(i).getStuID()%></td>
                                <td><%=billsLists.get(i).getDatePay()%></td>                               
                                <td style="color:red "><%=billsLists.get(i).getType()%></td>
                                <td><%=billsLists.get(i).getMoneyPay()%></td>
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
