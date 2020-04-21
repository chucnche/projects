<%-- 
    Document   : kind
    Created on : Nov 5, 2019, 6:52:48 PM
    Author     : dell
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        .Accomodation-container ul li:nth-child(odd) .Left-row {
            width: 46%;
            float: left;
            padding: 0 2%;
            height: 230px;
        }
        .Accomodation-container ul li:nth-child(odd) .Right-row {
            width: 46%;
            float: left;
            padding: 0 2%;
            padding-top: 20px;
        }
        .Accomodation-container ul li:nth-child(even) .Left-row {
            width: 46%;
            float: right;
            padding: 0 2%;
            height: 230px;
        }
        .Accomodation-container ul li:nth-child(even) .Right-row {
            width: 46%;
            float: right;
            padding: 0 2%;
            padding-top: 20px;
        }
        .Accomodation-container ul li:nth-child(odd) .Right-row a {
            color: #955851;
            font-style: initial;
            text-align: right;
            display: block;
        }
        .Accomodation-container ul li:nth-child(even) .Left-row a {
            color: #955851;
            font-style: initial;
            text-align: right;
            display: block;
        }
    </style>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="row">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="image/slide1.PNG" height="500px" alt="First slide">
                </div>
            </div>
            <section class="section-room bg-white">
                <div class="container">
                    <h1 id="H1Title" class="main-header text-center" style="padding-top: 30px">LOẠI PH&#210;NG</h1>
                    <div class="wpb_wrapper">
                        <div class="Accomodation-container">
                            <ul>
                            <c:forEach items="${requestScope.kindors}" var="k" varStatus="loop">
                                <li>
                                    <div class="Accomodation-inner-container">
                                        <div ${loop.index mod 2 == 0?"class=\"Left-row\"":"class=\"Right-row\""}>
                                            <img width="100%" src="image/${k.kid}.PNG"  />
                                        </div>
                                        <div ${loop.index mod 2 == 0?"class=\"Right-row\"":"class=\"Left-row\""}>
                                            <h2>${k.kind}</h2>
                                            <c:if test="${k.kid == 'K01'}">
                                                Phòng đơn với thiết kế hài hòa, nội thất sang trọng với đầy đủ tiện nghi hiện đại. Diện tích khoảng 13m<sub>2</sub> mỗi phòng được trang trí cửa sổ mang đến không gian thoải mái nhất cho bạn.
                                            </c:if>
                                            <c:if test="${k.kid == 'K02'}">
                                                Phòng đôi có tầm nhìn bao quát có diện tích khoảng 16m<sub>2</sub> mỗi phòng có một phòng đơn và một phòng đôi không gian rộng lớn thoải mái 

                                            </c:if>
                                            <c:if test="${k.kid == 'K03'}">
                                                Phòng VIP có tiện ích sang trọng với diện tích khoảng 27m<sub>2</sub> phù hợp với cả gia đình với 2 giường cỡ lớn và có tầm nhìn đẹp ra ngoài.

                                            </c:if>

                                            <a href="${pageContext.request.contextPath}/book">Đặt phòng<span aria-hidden="true" class="arrow_carrot-2right"></span></a>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
