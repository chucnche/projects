<%-- 
    Document   : galleryDetail
    Created on : Mar 16, 2020, 8:31:10 PM
    Author     : Chucnc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="public/js/clickImage.js" type="text/javascript"></script>
        <link href="public/css/galleryDetail.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="wrap-content color-text flex">
                <div class="left">
                    <c:if test="${galleryCurrent!= null}">   
                        <!--gallery title,big image-->
                        <div>
                            <p class="galleryCurrentName">${galleryCurrent.name}</p>  
                            <div class="warp-galleryCurrentImage">
                                <img class="galleryCurrentImage" id="galleryCurrentClick" src="${galleryCurrent.image}"/>
                            </div>
                        </div>
                        <!--other images-->
                        <div class="otherImage">

                            <c:forEach items="${imgGalleryList}" var="img">
                                <div class="sub-gallery">
                                    <div class="sub-img">
                                       <img class="imageOtherGalleryDetail" id="${img.image}" src="${img.image}" onclick="imageOnClick(this.id)"/>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <!--page index-->
                        <div class="pagingDetail flex">
                            <c:forEach var="i" begin="1" end="${numberPage}">
                                <!--page current-->
                                <c:if test="${i == page}">
                                    <p>${i}</p>
                                </c:if>
                                <!--other pages:If clicked, it will move to a new page-->
                                <c:if test="${i != page}">
                                    <a class="color-text" href="GalleryDetail?page=${i}&id=${galleryCurrent.id}" >${i}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <!--right-->
                <div class="right">
                    <%@include file="right.jsp"%>
                </div>
            </div>
        </div>
        <!--footer-->
        <%@include file="footer.jsp"%>
    </body>
</html>
