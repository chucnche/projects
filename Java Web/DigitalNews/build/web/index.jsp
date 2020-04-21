<%-- 
    Document   : index
    Created on : Feb 25, 2020, 8:12:28 PM
    Author     : Chucnc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!--        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>-->
        <link href="public/css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container">
            <div class="wrap-content flex">
                <!--left-Article dedail-->
                <div class="left">
                    <p  class="titleArticle colorTitle">${currentArticle.title}</p>
                    <img class="home-img" src="${currentArticle.image}">
                    <div class="home-content sizeContent">
                        <p>${currentArticle.content}</p>
                    </div>
                    <div class="datePublish sizeContent colorTitle">
                        <div class="iconComment"></div>
                        <div class="iconTime"></div>
                        By ${currentArticle.author} | ${currentArticle.getDateFormat()}
                    </div>
                </div>
                <!--right-->
                <%@include file="right.jsp"%>
            </div>
            <!--footer-->
            <footer class="footer">
            </footer>
        </div>
    </body>
</html>
