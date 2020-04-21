<%-- 
    Document   : ADElectricityWater
    Created on : Nov 5, 2019, 9:17:44 PM
    Author     : Chucnc
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="util.HtmlHelper"%>
<%@page import="modal.ElectricityWaterBills"%>
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
            ArrayList<ElectricityWaterBills> billsLists = (ArrayList<ElectricityWaterBills>) request.getSession().getAttribute("ElectricityWaterBills");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getSession().getAttribute("pagecountE");
            Integer pagesize = (Integer) request.getAttribute("pagesize");
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row"  style="margin-top: 60px;margin-left: 160px;">
                    <div class="col-lg-10 col-md-10">
                        <span style="color:red;font-size: 20px;font-family:'Times New Roman'">Thông tin số điện/nước vượt mức sử dụng</span>
                        <form style="margin-top: 30px;" id="frm" action="ADElectricityWater" method="POST">
                            <div class="form-group">
                                <button  type="submit" class="btn btn-success pull-left">Tìm kiếm</button>
                                <span style="margin-left: 20px;">Phòng:</span><input style="width: 100px;"  type="text" name="room1" value="" />
                                Ngày từ:<input  style="width: 100px;" type="text" name="from1" value="" />
                                đến:<input  style="width: 100px;" type="text" name="to1" value="" />
                            </div> 
                        </form>
                        <button  style="background-color:#999999; border:none;border-radius: 4px;" type="button" class ="btn btn-3 btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">
                            <span style="color:wheat;font-size:15px;">Cập nhật điện/nước tháng này</span>
                        </button>  
                        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <div class="row">
                                            <div style="margin-top: 60px;" class="col-lg-5 col-md-5 block-image">
                                                <img src="Login/img/nuoc.jpg" class="img-responsive"/>
                                            </div>
                                            <div style="margin-top: 40px" class="col-lg-6 col-md-6 block-contact">
                                                <%
                                                        DateFormat simpleDateFormat = new SimpleDateFormat("MM-yyyy");
                                                        String da = simpleDateFormat.format(Calendar.getInstance().getTime());
                                                %>
                                                <h1 style="color: #999999;font-size: 30px;">Điện nước tháng <%=da%></h1>
                                                <form action="ADaddBills" method="POST">
                                                    <div class="form-group">
                                                        Phòng<input class="form-control" type="text" name="room" value="" />
                                                        Số điện<input class="form-control" type="text" name="sodien" value="" />
                                                        Số nước<input class="form-control" type="text" name="sonuoc" value="" />
                                                    </div>          
                                                    <button type="submit" class="btn btn-success pull-left">cập nhật</button>

                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="margin-top: 30px">
                            <%=HtmlHelper.pagerBills(pageindex, pagecount, 2)%>
                        </div>
                        <div  style="margin-top: 20px;" class="form-group">
                            <table  class="table table-bordered table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Tên phòng</th>
                                        <th>Tháng năm</th>
                                        <th style="color:red ">Số điện vượt mức</th>
                                        <th style="color:blue ">Số nước vượt mức</th>
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
                                        <td><%=billsLists.get(i).getRoomName()%></td>
                                        <td><%=billsLists.get(i).getMonthYear()%></td>
                                        <td style="color:red "><%=billsLists.get(i).getSoDien()%></td>
                                        <td style="color:blue "><%=billsLists.get(i).getSoNuoc()%></td>
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
