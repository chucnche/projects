<%-- 
    Document   : Request.jsp
    Created on : Oct 28, 2019, 7:38:24 PM
    Author     : Chucnc
--%>

<%@page import="Controller.Request"%>
<%@page import="modal.Student"%>
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
       <%
            ArrayList<RequestStudent> requestLists = (ArrayList<RequestStudent>) request.getSession().getAttribute("RequestDAO");
            Student stu = (Student) request.getSession().getAttribute("StudentDAO");
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="example">
            <div class="container">
                <div class="row">
                    <h2>Table Border</h2>
                   <button  style="background-color:#999999; border:none;border-radius: 4px;width: 140px;height: 40px;" type="button" class ="btn btn-3 btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">
                      <span style="color:wheat;font-size:15px;">Tạo yêu cầu</span>
                  </button>
                    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                      <div class="modal-dialog modal-lg" role="document">
                          <div class="modal-content">
                              <div class="modal-body">
                                  <div class="row">
                                      <div style="margin-top: 60px;" class="col-lg-5 col-md-5 block-image">
                                          <img src="Login/img/request.png" class="img-responsive"/>
                                      </div>
                                      <div style="margin-top: 40px" class="col-lg-6 col-md-6 block-contact">
                                          <h1 style="color: #999999;font-size: 50px;">Nội Dung</h1>
                                          <form action="Request" method="POST">
                                              <div class="form-group">
                                                  <textarea style="  border: 2px solid cornflowerblue;border-radius: 4px;color:#999999;font-size: 25px;width:470px;height:200px;"
                                                        rows="5" name="requestStu" ></textarea>
                                              </div>          
                                              <button type="submit" class="btn btn-success pull-left">Yêu cầu</button>

                                          </form>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th style="width:160px;color:red ">Ngày tạo</th>
                                <th style="width:320px;">Nội dung</th>
                                <th style="width:160px;color:blue ">Ngày trả lời</th>
                                <th style="width:320px;">Trả lời</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (RequestStudent s : requestLists) {
                                    if (stu.getStuID().equalsIgnoreCase(s.getStuID())) {
                            %>
                            <tr>
                                <td style="color:red "><%=s.getDateRequest()%></td>
                                <td><%=s.getRequest()%></td>
                                <%
                                if(s.getDateReply()!=null && s.getReply()!=null){
                                %>
                                <td style="color:blue "><%=s.getDateReply()%></td>                               
                                <td><%=s.getReply()%></td>
                                <%}
                                else{
                                %>
                                <td></td>                               
                                <td></td>
                                <%}%>
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
