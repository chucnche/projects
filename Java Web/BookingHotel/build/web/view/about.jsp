<%-- 
    Document   : about
    Created on : Nov 6, 2019, 9:05:59 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
        <div class="container posts">
    <div class="row">
        <div class="col-md-12">
            <h1 id="H1Title" class="main-header text-center" style="padding-top: 30px">Welcom to Linh Anh Hotel</h1>
            <p style="text-align:justify"><p style="margin-left:auto; margin-right:auto; text-align:justify">Khách sạn Linh Anh tọa lạc tại Quận Hai Bà Trưng, Hà Nội. Nhà hát Lớn Hà Nội và Nhà hát Múa rối Nước Thăng Long là điểm đến văn hóa nổi tiếng; ngoài ra không thể quên kể đến những địa danh được nhiều người biết đến như Văn Miếu cùng Lăng Bác. Sắp có sự kiện hay trận thi đấu nào không? Đừng quên kiểm tra thử lịch chương trình tại Sân vận động Quốc gia Mỹ Đình hay Cung Thể thao dưới nước Mỹ Đình.<br />
<br />
Phục vụ cà phê tại khu vực chung, dịch vụ phòng 24 giờ và dịch vụ giặt khô là những tiện nghi, dịch vụ nổi bật tại khách sạn không khói thuốc này. Khách có thể sử dụng Wifi tại khu vực chung miễn phí. Ngoài ra, trong khuôn viên còn có quầy tiếp tân phục vụ 24 giờ/ngày và chỗ đậu xe máy. Tất cả 12 khu phòng đều có Wifi miễn phí, dịch vụ phòng 24 giờ và TV màn hình phẳng với các kênh truyền hình cáp. Những tiện nghi, dịch vụ khác dành cho khách bao gồm nước đóng chai miễn phí, máy sấy tóc và đồ dùng nhà tắm miễn phí.<br />
<br />
Linh Anh HOTEL với trên 20 phòng sạch đẹp, hiện đại, trang nhã, đối diện bệnh viện Bạch Mai. Mở cửa 24/24, chúng tôi xin đón chào và được phục vụ quý khách
Tọa lạc gần trung tâm thành phố là điểm giao giữa các tuyến đường giao thông chính, quý khách sẽ thuận tiện cho việc lưu thông, di chuyển giữa các địa điểm khác nhau.<br />
<br />
</p>

        </div>
    </div>
</div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
