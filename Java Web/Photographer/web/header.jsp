<%-- 
    Document   : header
    Created on : Mar 16, 2020, 8:13:06 AM
    Author     : Chucnc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/header.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="menu font-text size-content">
            <ul>
                <!--Bold the current page-->
                <li><a class="color-text ${boldHome}" href="Home">My front page</a></li>
                    <c:forEach var="x" items="${Top3Gallery}">
                        <c:if test="${x.id==id}">
                            <li><a class="color-text font-bold" href="GalleryDetail?id=${x.id}">${x.name}</a></li>
                        </c:if>
                        <c:if test="${x.id!=id}">
                            <li><a class="color-text" href="GalleryDetail?id=${x.id}">${x.name}</a></li>
                        </c:if>
                    </c:forEach>                
                <li><a class="color-text ${boldContact}" href="Contact">Contact</a></li>
            </ul>
        </div>
        <div class="head">
            <div class="pre-header flex">
                <a href="Home">
                    <div class="imageIcon">    
                    </div>
                </a>
                <div class="title">
                    <div class="name"><a class="color-text" href="Home">PHOTOGRAPHER</a></div>
                    <div class="welcome color-text">Welcome to this website</div>
                </div>
            </div>

        </div>
    </body>
</html>
