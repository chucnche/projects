<%-- 
    Document   : invoice
    Created on : Nov 10, 2019, 2:44:29 PM
    Author     : dell
--%>

<%@page import="model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        <%
            ArrayList<Service> services = (ArrayList<Service>) request.getAttribute("services");

        %>
    </script>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="row">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="image/slide1.PNG" height="500px" alt="First slide">
                </div>
            </div>
            <section>
                <div class="container">
                    <h1 id="H1Title" class="main-header text-center" style="padding-top: 30px">Hóa đơn</h1>
                    <div class="d-flex justify-content-center">
                        <div class="col-md-6" >
                            <div class="panel panel-info col-md-12" style="border: 1px solid #bce8f1;">
                                <div class="col-md-12">
                                    <form action="invoice" method="post" >
                                        <div class="form-group">
                                            <label for="">Họ và tên :</label> 
                                            <input class="form-control" type="text" readonly="" name="name" id="" value="${requestScope.name}" />
                                        <input type="hidden" name="user" value="${requestScope.user}"/>
                                    </div>
                                    <div class="form-group" style="padding-bottom: 10px;border-bottom: 2px solid #bce8f1;">
                                        <label for="kind">Số phòng : </label>
                                        <div class="row col-md-12">
                                            <div class="col-md-6">
                                                <c:if test="${requestScope.check == null}">
                                                <select class="form-control" id="rid" name="rid" style="height:40px;width: 150px">
                                                    <c:forEach items="${requestScope.rooms}" var="r">
                                                        <option ${(r.rid == requestScope.rid)?"selected=\"selected\"":"" } value="${r.rid}">${r.roomnum}</option>
                                                        <input type="hidden" name="" value="${r.rid}">
                                                    </c:forEach>
                                                </select>
                                                </c:if>
                                                <c:if test="${requestScope.check!=null}">
                                                    <input class="form-control" type="text" id="datefromf01" name="fromf01" id="" value="${requestScope.num}" />
                                                </c:if>
                                            </div>
                                            <div class="col-md-6">
                                                <button type="submit" class="btn btn-danger">Xem hóa dơn</button>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                                <ul>

                                    <li style="list-style: none;
                                        clear: both;
                                        display: -webkit-box;">
                                        <%for (int i = 0; i < services.size(); i++) {
                                                if (i % 2 == 0) {%>
                                        <div class="form-group col-md-6">
                                            <label for=""><%=services.get(i).getName()%></label> 
                                            <input class="form-control" type="text" readonly="" name="name" id="" value="${s.prices}" />
                                        </div>
                                        <%}

                                            }%>
                                    </li>
                                    <li style="list-style: none;
                                        clear: both;
                                        display: -webkit-box;">
                                        <%for (int i = 0; i < services.size(); i++) {
                                                if (i % 2 == 1) {%>
                                        <div class="form-group col-md-6">
                                            <label for=""><%=services.get(i).getName()%></label> 
                                            <input class="form-control" type="text" readonly="" name="name" id="" value="${s.prices}" />
                                        </div>
                                        <%}

                                            }%>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
