<%-- 
    Document   : book
    Created on : Nov 3, 2019, 11:03:15 PM
    Author     : dell
--%>

<%@page import="util.HtmlHelper"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getAttribute("pagecount");
            Date from = (Date) request.getAttribute("from");
            Date to = (Date) request.getAttribute("to");
            String kid = (String) request.getAttribute("kid");
            String fid = (String) request.getAttribute("fid");
        %>
        <style>
            .panel-info {
                border-color: #bce8f1;
                border: 1px;
            }
            .panel-heading {
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }
            .panel-heading {
                padding: 10px 15px;
                border-bottom: 1px solid transparent;
                border-top-left-radius: 3px;
                border-top-right-radius: 3px;
            }
        </style>
    </head>
    <script>
        function bookf01() {
            var from = document.getElementById("datefromf01").value;
            var to = document.getElementById("datetof01").value;
            if (from > to) {
                alert("Lựa chọn lại Date To");
            }
            else if (from == null || to == null || from == "" || to == "")
                alert("date not null")
            else
                document.getElementById("bookf01").submit();
        }
        function bookf02() {
            var from = document.getElementById("datefromf02").value;
            if (from == null || from == "")
                alert("date not null")
            else
                document.getElementById("bookf02").submit();
        }
        function hihi() {
            var haha = document.getElementById("haha").value;
            if (haha != "submit")
                alert("Submit not null")
            else
                alert("Ok")
        }
//        function dcm() {
//            var from = document.getElementById("CheckIn").value;
//            var to = document.getElementById("CheckOut").value;
//            var kid = document.getElementById("kind").value;
//            var fid = document.getElementById("fid").value;
//            if (from == null || to == null || kid == null || fid == null)
//                alert("Not null");
//            else
//                document.getElementById("myModal").innerHTML;
//        }
    </script>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="image/slide1.PNG" height="500px" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="image/slide2.PNG" height="500px" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="image/slide3.PNG" height="500px" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <section>
                <div class="container">
                    <h1 id="H1Title" class="main-header text-center" style="padding-top: 30px; padding-bottom: 20px;">Đặt Phòng</h1>
                    <div class="row col-md-12">
                        
                        <div class="col-md-6" >
                            <div class="panel-heading">
                                <h4 class="panel-title">Thuê theo ngày</h4>
                            </div>
                            <div class="panel panel-info col-md-12" style="border: 1px solid #bce8f1;">

                                <form action="book" id="bookf01" method="post" class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="fromf01">Ng&#224;y đến<span class="required">*</span></label>
                                            <input class="form-control" type="date" id="datefromf01" name="fromf01" id="" value="${requestScope.from}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="kind">Loại phòng<span class="required">*</span></label>
                                        <select class="form-control" id="kind" name="kid" style="height:40px;">
                                            <option value="">Loại phòng</option>
                                            <c:forEach items="${requestScope.kindors}" var="k">
                                                <option ${(k.kid == requestScope.kid)?"selected=\"selected\"":"" } value="${k.kid}">${k.kind}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="tof01">Ng&#224;y đi<span class="required">*</span></label>
                                        <input class="form-control" type="date" id="datetof01" name="tof01" id="" value="${requestScope.to}" />
                                    </div>


                                </div>
                                <input type="hidden" name="fid" value="F02"></input>
                                <div style="padding: 15px 15px">
                                    <input type="button" value="Xem phòng"onclick="bookf01()" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-6" >
                        <div class="panel-heading">
                            <h4 class="panel-title">Thuê qua đêm</h4>
                        </div>
                        <div class="panel panel-info col-md-12" style="border: 1px solid #bce8f1;">

                            <form action="book" method="post" id="bookf02" class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="CheckIn">Ng&#224;y đến<span class="required">*</span></label>
                                        <input class="form-control" type="date" id="datefromf02" name="fromf02" id="" value="${requestScope.from}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="kind">Loại phòng<span class="required">*</span></label>
                                        <select class="form-control" id="kind" name="kid" style="height:40px;">
                                            <option value="">Loại phòng</option>
                                            <c:forEach items="${requestScope.kindors}" var="k">
                                                <option ${(k.kid == requestScope.kid)?"selected=\"selected\"":"" } value="${k.kid}">${k.kind}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">



                                </div>
                                <input type="hidden" name="fid" value="F01"></input>
                                <div style="padding: 15px 15px">
                                    <input type="button" value="Xem phòng" onclick="bookf02()" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row col-md-12" style="padding-top: 30px;">
                    <div class="panel-heading" style="margin-bottom: 30px" >
                        <h4 class="panel-title">Thông tin phòng</h4>
                    </div>
                    <c:forEach items="${requestScope.rooms}" var="r">
                        <div class="row col-md-12">

                            <div class="col-md-6">
                                <div >
                                    <img class="d-block w-100" src="image/${r.rid}.PNG" height="400px">

                                </div>
                            </div>
                            <div class="col-md-3" style="border-right: 2px solid #bce8f1;">
                                <c:if test="${r.kindor.kid == 'K01'}">
                                    <h3 class="title-sub">Phòng ${r.roomnum}</h3>
                                    <div style="text-align: justify;">Phòng đơn với thiết kế hài hòa, nội thất sang trọng với đầy đủ tiện nghi hiện đại. Diện tích khoảng 13m<sub>2</sub> mỗi phòng được trang trí cửa sổ mang đến không gian thoải mái nhất cho bạn.</div>

                                </c:if>
                                <c:if test="${r.kindor.kid == 'K02'}">
                                    <h3 class="title-sub">Phòng ${r.roomnum}</h3>
                                    <div style="text-align: justify;">Phòng đôi có tầm nhìn bao quát có diện tích khoảng 16m<sub>2</sub> mỗi phòng có một phòng đơn và một phòng đôi không gian rộng lớn thoải mái </div>

                                </c:if>
                                <c:if test="${r.kindor.kid == 'K03'}">
                                    <h3 class="title-sub">Phòng ${r.roomnum}</h3>
                                    <div style="text-align: justify;">Phòng VIP có tiện ích sang trọng với diện tích khoảng 27m<sub>2</sub> phù hợp với cả gia đình với 2 giường cỡ lớn và có tầm nhìn đẹp ra ngoài. </div>

                                </c:if>
                            </div>    

                            <div class="col-md-3">
                                <form action="submit" method="get">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">Xác nhận thông tin</h5>
                                    </div>

                                    <div class="form-group">
                                        <label for="CheckIn">Ng&#224;y đến<span class="required">*</span></label>
                                        <input class="form-control" type="date" name="subfrom"  id="CheckIn" readonly="" value="${requestScope.from}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="CheckOut">Ng&#224;y đi<span class="required">*</span></label>
                                        <input class="form-control" type="date" name="subto" id="CheckOut" readonly="" value="${requestScope.to}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="kind">Loại phòng<span class="required">*</span></label>
                                        <c:forEach items="${requestScope.kindors}" var="k">
                                            <c:if test="${r.kindor.kid == k.kid}">
                                                <input class="form-control" disabled="disabled" type="text" name="kind" id="CheckOut" value="${k.kind}" />
                                                <input type="hidden" name="subkid" value="${k.kid}"></input>
                                                <input type="hidden" name="subkind" value="${k.kind}"></input>
                                            </c:if>
                                        </c:forEach>


                                    </div>
                                    <input type="hidden" name="subrid" value="${r.rid}"
                                           <div class="form-group">
                                        <label for="CheckIn">Hình thức : </label>
                                        <input class="form-control" disabled="disabled" type="text" name="form" id="CheckOut" value="${(requestScope.fid eq "F01")?"Thuê qua đêm":"Thuê theo ngày"}" />
                                    </div>
                                    <input type="hidden" name="subfid" value="${requestScope.fid}">    
                                    <input type="hidden" name="subform" value="${(requestScope.fid eq "F01")?"Thuê qua đêm":"Thuê theo ngày"}"></input>
                                    <input type="${(requestScope.fid eq null)?"button":"submit"}" value="Đặt Phòng" class="btn btn-primary " style="margin-top: 20px;"/>

                                </form>
                            </div>

                        </div>
                    </c:forEach>
                </div>
                <ul class="pagination justify-content-center" style="margin:20px 0">
                    <%=HtmlHelper.pagerbook(pageindex, pagecount, 1, from, to, kid, fid)%>
                </ul>

        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
