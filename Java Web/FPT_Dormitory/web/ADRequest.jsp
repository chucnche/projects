<%-- 
    Document   : ADRequest.jsp
    Created on : Nov 7, 2019, 5:31:54 PM
    Author     : Chucnc
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="modal.RequestStudent"%>
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
            ArrayList<RequestStudent> studentLists = (ArrayList<RequestStudent>) request.getSession().getAttribute("RequestDAO");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getSession().getAttribute("pagecountRe");
            Integer pagesize = (Integer) request.getAttribute("pagesize");
        %>
    </head>
    <body>
        <jsp:include page="Admenu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row" style="margin-top: 70px;">
                    <span style="font-size: 35px;">Danh sách yêu cầu của học sinh</span>
                    <form id="frm" action="ADRequest" method="POST">
                        <div class="form-group">
                            Mã học sinh:<input style="width: 100px;"  type="text" name="sID1" value=""  />
                            Ngày yêu cầu từ:<input  style="width: 100px;" type="text" name="from1" value="" />
                            đến:<input  style="width: 100px;" type="text" name="to1" value="" />
                        </div> 
                        <div class="form-group">
                            <span style="font-size:15px;margin-right: 5px;">Đã trả lời</span><input type="radio" name="type" value="1" />
                            <span style="margin-left: 20px;font-size:15px;">Chưa trả lời</span> <input type="radio" name="type" value="0" />
                            <span style="margin-left: 20px;font-size:15px;">Cả hai</span> <input type="radio" name="type" value="2" />
                        </div> 
                        <button type="submit" class="btn btn-success pull-left">Tìm kiếm</button>
                    </form>
                    <div style="margin-top: 60px">
                        <%=HtmlHelper.pagerRequest(pageindex, pagecount, 2)%>
                    </div>
                    <div style="margin-top: 30px">
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th style="width:160px;color:red ">Mã sinh viên</th>
                                    <th style="width:160px;color:red ">Ngày tạo</th>
                                    <th style="width:320px;">Nội dung</th>
                                    <th style="width:160px;color:blue ">Mã quản lí</th>
                                    <th style="width:160px;color:blue ">Ngày trả lời</th>
                                    <th style="width:320px;">Nội dung</th>
                                    <th style="width:160px;">Trạng thái</th>
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
                                    <td style="color:red "><%=studentLists.get(i).getStuID()%></td>
                                    <td style="color:red "><%=studentLists.get(i).getDateRequest()%></td>
                                    <td><%=studentLists.get(i).getRequest()%></td>
                                    <%
                                        if (studentLists.get(i).getDateReply() != null && studentLists.get(i).getReply() != null) {
                                    %>
                                    <td style="color:blue"><%=studentLists.get(i).getMaID()%></td>
                                    <td style="color:blue "><%=studentLists.get(i).getDateReply()%></td>                               
                                    <td><%=studentLists.get(i).getReply()%></td>
                                    <td style="color: blue">Đã trả lời</td>
                                    <%} else {
                                    %>
                                    <td></td>                               
                                    <td></td>
                                    <td></td>
                                    <td><button  style="background-color:#999999;width: 60px;height: 40px; border:none;border-radius: 4px;" type="button" class ="btn btn-3 btn-primary" data-toggle="modal" data-target=".<%=i%>">
                                            <span style="color:wheat;font-size:15px;">Trả lời</span>
                                        </button> 
                                    </td>
                            <div class="modal fade <%=i%>" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <div class="row">
                                                <div style="margin-top: 120px;" class="col-lg-4 col-md-4 block-image">
                                                    <img src="Login/img/reply1.jpg" class="img-responsive"/>
                                                </div>
                                                <div style="margin-top: 40px" class="col-lg-6 col-md-6 block-contact">
                                                    <h1 style="color: #999999;font-size: 50px;">Nội Dung trả lời</h1>
                                                    <form action="ADReply" method="POST">
                                                        <input type="hidden" name="sid" value="<%=studentLists.get(i).getDateRequest()%>" />
                                                        <div class="form-group">
                                    
                                                            <textarea style="  border: 2px solid cornflowerblue;border-radius: 4px;color:#999999;font-size: 25px;width:470px;height:200px;"
                                                                      rows="5" name="requestStu" ></textarea>
                                                        </div>          
                                                        <button type="submit" class="btn btn-success pull-left">Trả lời</button>

                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%}%>
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
