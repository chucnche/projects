<%-- 
    Document   : available
    Created on : Nov 4, 2019, 2:04:28 PM
    Author     : dell
--%>
<%@page import="java.sql.Date"%>
<%@page import="util.HtmlHelper"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        %>
    </head>
    <script>
        function available() {
            var from = document.getElementById("datefrom").value;
            var to = document.getElementById("dateto").value;
            if (from > to) {
                alert("Lựa chọn lại Date To");
            }
            else if (from == null || to == null || from == "" || to == "")
                alert("date not null")
            else
                document.getElementById("available").submit();
        }
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
                    <h1 id="H1Title" class="main-header text-center" style="padding-top: 30px;padding-bottom: 30px">Đặt phòng</h1>
                <c:forEach items="${requestScope.rooms}" var="r">
                    <div class="row">
                        <div class="col-md-9">
                            <div >
                                <img class="d-block w-100" src="image/${r.rid}.PNG" height="400px"  alt="First slide">
                                <div class="room-detail_tab">

                                        
                                        <c:if test="${r.kindor.kid == 'K01'}">
                                            <h3 class="title-sub" style="padding-top: 10px">Phòng ${r.roomnum}</h3>
                                            <div style="text-align: justify;">Phòng đơn với thiết kế hài hòa, nội thất sang trọng với đầy đủ tiện nghi hiện đại. Diện tích khoảng 13m<sub>2</sub> mỗi phòng được trang trí cửa sổ mang đến không gian thoải mái nhất cho bạn.</div>

                                        </c:if>
                                        <c:if test="${r.kindor.kid == 'K02'}">
                                            <h3 class="title-sub" style="padding-top: 10px">Phòng ${r.roomnum}</h3>
                                            <div style="text-align: justify;">Phòng đôi có tầm nhìn bao quát có diện tích khoảng 16m<sub>2</sub> mỗi phòng có một phòng đơn và một phòng đôi không gian rộng lớn thoải mái </div>

                                        </c:if>
                                        <c:if test="${r.kindor.kid == 'K03'}">
                                            <h3 class="title-sub" style="padding-top: 10px">Phòng ${r.roomnum}</h3>
                                            <div style="text-align: justify;">Phòng VIP có tiện ích sang trọng với diện tích khoảng 27m<sub>2</sub> phù hợp với cả gia đình với 2 giường cỡ lớn và có tầm nhìn đẹp ra ngoài. </div>

                                        </c:if>
                                        
                                        <div><strong>Các tiện ích: </strong><br />
                                            &nbsp;
                                            <table border="0" cellpadding="8" cellspacing="0" style="width:100%">
                                                <tbody>
                                                    <tr>
                                                        <td style="width:50%">
                                                            <ul>
                                                                <li>Truyền hình cáp</li>
                                                                <li>Điện thoại</li>
                                                                <li>Giường</li>
                                                                <li>Phòng tắm vòi sen</li>
                                                                <li>Hệ thống khóa tự động</li>
                                                                <li>Nước suối miễn phí</li>
                                                            </ul>
                                                        </td>
                                                        <td>
                                                            <ul>
                                                                <li>Nước nóng</li>
                                                                <li>Miễn phí Wifi</li>
                                                                <li>Làm phòng : 01 hoặc 02 lần mỗi ngày</li>
                                                                <li>Sony 32 inch LCD TV</li>
                                                                <li>Nước suối miễn phí mỗi ngày</li>
                                                                <li>Free parking at the hotel<br />
                                                                    &nbsp;</li>
                                                            </ul>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3" style="width: 200px">
                            <div class="room-detail_book">

                                <div class="sidebar">
                                    <div class="check-room">
                                        <div class="check-room-form">
                                            <form action="book" id="available" method="get">
                                                <div class="form-group">
                                                    <label for="fromf01">Ng&#224;y đến<span class="required">*</span></label>
                                                    <input class="form-control" type="date" id="datefrom" name="from" id="" value="${requestScope.from}" />
                                                </div>
                                                <div class="form-group">
                                                    <label for="tof01">Ng&#224;y đi<span class="required">*</span></label>
                                                    <input class="form-control" type="date" id="dateto" name="to" id="" value="${requestScope.to}" />
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

                                                <div class="">
                                                    <input type="button" value="Kiểm tra phòng" onclick="available()" class="btn btn-primary"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <%=HtmlHelper.pageravailable(pageindex, pagecount, 1, from, to, kid)%>
            </ul>


        </section>

    </body>
</html>
