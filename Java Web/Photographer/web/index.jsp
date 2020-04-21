<%-- 
    Document   : index
    Created on : Mar 16, 2020, 8:21:39 AM
    Author     : Chucnc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="wrap-content color-text flex">
                <div class="left">
                    <!--intro image,descript-->
                    <div class="intro">
                        <div><img class="introImage" src="${Introduction.image}"/></div>
                        <div class="introDescript size-content font-text">${Introduction.descript}</div>
                    </div>
                    <!--link vew gallery-->
                    <div class="flex">
                        <c:forEach var="g" items="${PagingGallery}" >
                            <div class="galleryTop3">
                                <div class="wrap-top3Image">
                                    <img class="image-galleryTop3" src="${g.image}" >
                                </div>
                                <a class="galleryName color-text" href="GalleryDetail?id=${g.id}">View ${g.name}</a>
                                <div class="galleryDescription  size-content  font-text">
                                    ${g.description}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!--show page index-->
                    <div class="paging flex">
                        <c:forEach var="i" begin="1" end="${numberPage}">
                            <!--page current-->
                            <c:if test="${i == page}">
                                <p>${i}</p>
                            </c:if>
                            <!--other pages:If clicked, it will move to a new page-->
                            <c:if test="${i != page}">
                                <a class="color-text" href="Home?page=${i}" >${i}</a>
                            </c:if>
                        </c:forEach>
                    </div>
                    <!--about me -->
                    <div class="aboutMe">
                        <div class="AboutTitle">About me</div>
                        <p class="size-content  font-text">
                            ${Introduction.aboutme}
                        </p>
                    </div>
                </div>
                <!--right-->
                <div class="right">
                    <%@include file="right.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
