<%-- 
    Document   : service
    Created on : Nov 8, 2019, 9:37:49 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .Accomodation-container ul li {
            list-style: none;
            clear: both;
            display: -webkit-box;
            padding-top: 60px;
            padding-bottom: 60px;
        }
        .Accomodation-container ul li .Left-row {
            width: 46%;
            float: left;
            padding: 0 2%;
            height: 230px;
        }
        .Accomodation-container ul li .Right-row {
            width: 46%;
            float: left;
            padding: 0 2%;
        }
    </style>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="row">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="image/slide1.PNG" height="500px" alt="First slide">
                </div>

            </div>
            <section>

                <div class="container col-md-12">
                    <div class="container">
                        <h1 id="H1Title" class="main-header text-center" style="padding-top: 30px">Dịch Vụ</h1>
                        <div class="wpb_wrapper">
                            <div class="Accomodation-container">
                                <ul>
                                    <li>
                                    <c:forEach items="${requestScope.services}" var="s" varStatus="loop">

                                        <c:if test="${loop.index mod 2 == 0}">

                                            <div class="col-md-6">
                                                <div class="Accomodation-inner-container">
                                                    <div class="Left-row">
                                                        <img width="100%" src="image/${s.sid}.jpg" alt=""/>
                                                    </div>
                                                    <div class="Right-row">
                                                        <h4>${s.name}</h4>
                                                        <p class="bold_p_accommodation">
                                                            Giá dịch vụ: ${s.price} đồng
                                                        </p>

                                                        <c:if test="${s.sid == 'S01'}">
                                                            Mọi loại nước uống sẽ được phục vụ khi khách yêu cầu<br/>
                                                        </c:if>
                                                        <c:if test="${s.sid == 'S02'}">
                                                            Thức ăn ngon miệng luôn luôn chờ để phục vụ bạn<br/>
                                                        </c:if>
                                                        <c:if test="${s.sid == 'S03'}">
                                                            Quần áo của bạn sẽ sạch sẽ ngay khi bạn sử dụng dịch vụ<br/>
                                                        </c:if>
                                                        <c:if test="${s.sid == 'S04'}">
                                                            Khu vực an toàn cho phương tiện di chuyển của bạn<br/>
                                                        </c:if>
                                                        <c:if test="${requestScope.a == null}">
                                                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login">Đặt dịch vụ</a>
                                                        </c:if>
                                                        <c:if test="${requestScope.a !=null}">
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${s.sid}">
                                                            Đặt dịch vụ
                                                        </button>
                                                        </c:if>
                                                        <div class="modal" id="${s.sid}">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">

                                                                    <!-- Modal Header -->
                                                                    <div class="modal-header">
                                                                        <h4 class="modal-title">Xác nhận dịch vụ</h4>
                                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                    </div>
                                                                    <c:if test="${requestScope.size != 0}">
                                                                        <form action="service" method="post">
                                                                            <input type="hidden" name="sid" value="${s.sid}"/>
                                                                            <!-- Modal body -->

                                                                            <div class="modal-body">
                                                                                <div class="form-group">
                                                                                    <label for="kind">Số phòng : </label>
                                                                                    <select class="form-control" id="rid" name="rid" style="height:40px;width: 150px">
                                                                                        <c:forEach items="${requestScope.rooms}" var="r">
                                                                                            <option ${(r.rid == requestScope.rid)?"selected=\"selected\"":"" } value="${r.rid}">${r.roomnum}</option>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                ${s.name} : ${s.price} đồng/sản phẩm
                                                                            </div>

                                                                            <!-- Modal footer -->
                                                                            <div class="modal-footer">
                                                                                <button type="submit" class="btn btn-danger">Đồng ý</button>
                                                                            </div>
                                                                        </form>
                                                                    </c:if>
                                                                    <c:if test="${requestScope.size == 0}">
                                                                        <div class="modal-body">
                                                                            ${requestScope.error}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="submit" class="btn btn-danger" data-dismiss="modal">Đồng ý</button>
                                                                        </div>
                                                                    </c:if>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>

                                    </c:forEach>
                                </li>
                                <li>
                                    <c:forEach items="${requestScope.services}" var="s" varStatus="loop">

                                        <c:if test="${loop.index mod 2 == 1}">
                                            <div class="col-md-6">
                                                <div class="Accomodation-inner-container">
                                                    <div class="Left-row">
                                                        <img width="100%" src="image/${s.sid}.jpg" alt=""/>
                                                    </div>
                                                    <div class="Right-row">
                                                        <h4>${s.name}</h4>
                                                        <p class="bold_p_accommodation">
                                                            Giá dịch vụ: ${s.price} đồng
                                                        </p>
                                                        <c:if test="${s.sid == 'S01'}">
                                                            Mọi loại nước uống sẽ được phục vụ khi khách yêu cầu<br/>
                                                        </c:if>
                                                        <c:if test="${s.sid == 'S02'}">
                                                            Thức ăn ngon miệng luôn luôn chờ để phục vụ bạn<br/>
                                                        </c:if>
                                                        <c:if test="${s.sid == 'S03'}">
                                                            Quần áo của bạn sẽ sạch sẽ ngay khi bạn sử dụng dịch vụ<br/>
                                                        </c:if>
                                                        <c:if test="${s.sid == 'S04'}">
                                                            Khu vực an toàn cho phương tiện di chuyển của bạn<br/>
                                                        </c:if>
                                                        <c:if test="${requestScope.a == null}">
                                                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login">Đặt dịch vụ</a>
                                                        </c:if>
                                                        <c:if test="${requestScope.a !=null}">
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${s.sid}">
                                                            Đặt dịch vụ
                                                        </button>
                                                        </c:if>

                                                        <div class="modal" id="${s.sid}">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">

                                                                    <!-- Modal Header -->
                                                                    <div class="modal-header">
                                                                        <h4 class="modal-title">Xác nhận dịch vụ</h4>
                                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                    </div>
                                                                    <c:if test="${requestScope.size != 0}">
                                                                        <form action="service" method="post">
                                                                            <input type="hidden" name="sid" value="${s.sid}"/>
                                                                            <!-- Modal body -->

                                                                            <div class="modal-body">
                                                                                <div class="form-group">
                                                                                    <label for="kind">Số phòng : </label>
                                                                                    <select class="form-control" id="rid" name="rid" style="height:40px;width: 150px">
                                                                                        <c:forEach items="${requestScope.rooms}" var="r">
                                                                                            <option ${(r.rid == requestScope.rid)?"selected=\"selected\"":"" } value="${r.rid}">${r.roomnum}</option>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                ${s.name} : ${s.price} đồng/sản phẩm
                                                                            </div>

                                                                            <!-- Modal footer -->
                                                                            <div class="modal-footer">
                                                                                <button type="submit" class="btn btn-danger">Đồng ý</button>
                                                                            </div>
                                                                        </form>
                                                                    </c:if>
                                                                    <c:if test="${requestScope.size == 0}">
                                                                        <div class="modal-body">
                                                                            ${requestScope.error}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="submit" class="btn btn-danger" data-dismiss="modal">Đồng ý</button>
                                                                        </div>
                                                                    </c:if>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>

                                    </c:forEach>
                                </li> 


                                <!-- The Modal -->

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
