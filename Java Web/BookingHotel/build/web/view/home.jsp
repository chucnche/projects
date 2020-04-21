<%-- 
    Document   : home
    Created on : Nov 1, 2019, 9:24:38 PM
    Author     : dell
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.KindOfRoom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <style>
        .rooms-section {
            position: relative;
            background-attachment: fixed;
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
            padding-bottom: 40px;
        }
        .bgr-acomom {
            background-image: url(image/slide1.PNG);
        }
        #section-2 .title {
            padding-top: 40px;
            color: #fff;
            text-align: center;
            line-height: 40px;
            position: relative;
            margin-bottom: 30px;
        }
    </style>
    <script>
        $('#myCarousel').carousel({
            interval: 1000
        });
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
            <form action="available" id="available" method="post" style="font-size: 14px;
                  line-height: 1.42857143;
                  color: #333;">
                <div class="datepickerebe" style="text-align: center;
                     color: #000;
                     position: relative;
                     /*margin-top: -88px;*/
                     background-color: #ae8545;
                     margin-bottom: 60px;">
                    <div class="datepickerebe-on">
                        <div class="row">
                            <div class="col-md-2 block-left" style="height: 90px;position: relative;
                                 min-height: 1px;
                                 padding:20px 15px 15px 15px;background-color: black">
                                <h4><div class="booking-form-title" style="color: white">Đặt phòng ngay</div></h4>
                                <div class="text-light text-white">
                                    Ưu đãi giá tốt nhất
                                </div>

                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-angle-right fa-stack-1x fa-inverse"></i>
                                </span>
                            </div>


                            <div class="col-md-2" style="width: 100%;padding-top: 20px">
                                <div class="awe-calendar-wrapper">
                                    <select class="form-control" id="kind" name="kid" style="height:40px;">
                                        <option value="">Loại phòng</option>
                                    <c:forEach items="${requestScope.kindors}" var="k">
                                        <option ${(k.kid == requestScope.kid)?"selected=\"selected\"":"" } value="${k.kid}">${k.kind}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="col-md-2" style="padding-top: 20px">
                            <div class="awe-calendar-wrapper " class="datepicker-on">
                                <input type="date" name="from" value="" id="datefrom" class="form-control" class="awe-calendar datepicker-12" placeholder="Arrival Date" id="">
                                <i class="fa fa-calendar" aria-hidden="true"></i>
                            </div>
                        </div>
                        <div class="col-md-2 " style="padding-top: 20px">
                            <div class="awe-calendar-wrapper">
                                <input type="date" name="to" value="" id="dateto" class="form-control" class="awe-calendar datepicker-12" placeholder="DepartureDate" id="">
                                <i class="fa fa-calendar" aria-hidden="true"></i>
                            </div>
                        </div>

                        <div class="col-md-2 mg2" style="padding-top: 20px">
                            <div class="awe-calendar-wrapper">
                                <select class="form-control" id="form" name="fid" style="height:40px">
                                    <option value="">Hình thức</option>
                                    <c:forEach items="${requestScope.formors}" var="f">
                                        <option ${(f.fid == requestScope.fid)?"selected=\"selected\"":"" } value="${f.fid}">${f.form}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="avalability-column col-md-2 " style="padding-top: 20px">
                            <!--                            <button type="submit" class="btn btn-primary">
                                                                                Register
                                                                            </button>-->
                            <input type="button" value="Kiểm tra phòng" onclick="available()" class="btn btn-primary"/>
                        </div>

                    </div>
                </div>
            </div>
        </form>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1 class="title uppercase">Về ch&#250;ng t&#244;i</h1>
                        <div class="text-desc">
                            <p><div style="text-align:justify">Khách sạn Linh Anh tọa lạc tại Quận Hai Bà Trưng, Hà Nội. Nhà hát Lớn Hà Nội và Nhà hát Múa rối Nước Thăng Long là điểm đến văn hóa nổi tiếng; ngoài ra không thể quên kể đến những địa danh được nhiều người biết đến như Văn Miếu cùng Lăng Bác. Sắp có sự kiện hay trận thi đấu nào không? Đừng quên kiểm tra thử lịch chương trình tại Sân vận động Quốc gia Mỹ Đình hay Cung Thể thao dưới nước Mỹ Đình.<br />
                                <br />
                                </div>
                            </p>
                        </div>
                        <div class="btn-a">
                            <a class="learn-more theme-btn btn-style-two" href="${pageContext.request.contextPath}/about">Xem th&#234;m</a>
                        </div>

                    </div>
                    <div class="images-column col-md-6 ">
                        <div class="inner-box">
                            <div class="row">
                                <div class="col-md-12">
                                    <img src="image/R09.PNG" alt="Ch&#224;o mừng đến với Linh Anh Hotel" style="width: 100%"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bgr-acomom rooms-section" id="section-2" style="margin-top: 100px">
                <div class="container">

                    <h1 class="title uppercase magin">Ph&#242;ng kh&#225;ch sạn</h1>

                    <div class="row">
                        <div class="row col-md-12 " style="position:relative;">
                            <c:forEach items="${requestScope.kindors}" var="k">
                                <div class="col-md-4">
                                    <div class="thumbnail item container-img" style="background-color: #fff">
                                        <a href="${pageContext.request.contextPath}/kind" title="${k.kind}">
                                            <img class="img image" src="image/${k.kid}.PNG" alt="${k.kind}" style="width: 100%"/>
                                        </a>
                                        <div class="caption cap-img " style="padding: 20px 20px">
                                            <div class="item-description">
                                                <a href="${pageContext.request.contextPath}/kind" title="${k.kid}">
                                                    <h3 class="item-title" style="color: #ae8545;
                                                        font-size: 18px;
                                                        margin-bottom: 10px;
                                                        margin-top: 5px;
                                                        text-transform: uppercase;
                                                        font-weight: bold;
                                                        text-align: center;">${k.kind}</h3>
                                                </a>
                                                <c:if test="${k.kid == 'K01'}">
                                                    <div style="text-align: justify;">Phòng đơn với thiết kế hài hòa, nội thất sang trọng với đầy đủ tiện nghi hiện đại. Diện tích khoảng 13m<sub>2</sub> mỗi phòng được trang trí cửa sổ mang đến không gian thoải mái nhất cho bạn.</div>

                                                </c:if>
                                                <c:if test="${k.kid == 'K02'}">
                                                    <div style="text-align: justify;">Phòng đôi có tầm nhìn bao quát có diện tích khoảng 16m<sub>2</sub> mỗi phòng có một phòng đơn và một phòng đôi không gian rộng lớn thoải mái </div>

                                                </c:if>
                                                <c:if test="${k.kid == 'K03'}">
                                                    <div style="text-align: justify;">Phòng VIP có tiện ích sang trọng với diện tích khoảng 27m<sub>2</sub> phù hợp với cả gia đình với 2 giường cỡ lớn và có tầm nhìn đẹp ra ngoài. </div>

                                                </c:if>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                </div>
            </div>
            <div class="services-section" id="section-3" >
                <div class="container" style="position: relative;z-index: 9;">
                    <div class="row">
                        <div class="title-column col-md-12 col-sm-12 col-xs-12 text-center">
                            <div class="inner-box" style="margin-bottom:20px;">
                                <!--Sec Title-->
                                <div class="sec-title" style="margin-bottom:10px;">
                                    <h1 class="title uppercase" style="margin-bottom:10px;padding: 20px 20px">Dịch vụ</h1>
                                </div>
                                <div class="text-desc" style="text-align: center;">H&#227;y đến với ch&#250;ng t&#244;i bạn sẽ nhận được những dịch vụ v&#224; ưu đ&#227;i tốt nhất</div>

                            </div>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <!--Service Block-->
                        <div class="service-block col-md-3 col-sm-6 col-xs-12">
                            <div class="inner">


                                <div class="text-desc" style="text-align: left;">
                                    <ul>
                                        <li>Truyền h&#236;nh c&#225;p</li>
                                        <li>Giường</li>
                                        <li>Ph&#242;ng tắm v&#242;i sen</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--Service Block-->
                        <div class="service-block col-md-3 col-sm-6 col-xs-12">
                            <div class="inner">


                                <div class="text-desc" style="text-align: left;">
                                    <ul>
                                        <li>M&#225;y sấy t&#243;c</li>
                                        <li>Hệ thống kh&#243;a tự động</li>
                                        <li>Nước n&#243;ng</li>
                                        <li>Điện thoại</li>
                                        <li>Miễn ph&#237; Wifi</li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--Service Block-->
                        <div class="service-block col-md-3 col-sm-6 col-xs-12">
                            <div class="inner">


                                <div class="text-desc" style="text-align: left;">
                                    <ul>

                                        <li>L&#224;m ph&#242;ng : 01 hoặc 02 lần mỗi ng&#224;y</li>
                                        <li>Nhận ph&#242;ng VIP theo y&#234;u cầu </li>
                                        <li>Nước suối miễn ph&#237; mỗi ng&#224;y</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--Service Block-->
                        <div class="service-block col-md-3 col-sm-6 col-xs-12">
                            <div class="inner">


                                <div class="text-desc" style="text-align: left;">
                                    <ul>	
                                        <li>Dịch vụ giặt ủi</li>
                                        <li>Dịch vụ gửi xe</li>
                                        <li>Phục vụ ăn tại ph&#242;ng</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
