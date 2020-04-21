<%-- 
    Document   : right
    Created on : Feb 25, 2020, 10:14:49 PM
    Author     : Chucnc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/right.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="right">
            <!--About the most recent article-->
            <div>
                <p class="titleItem colorTitle right-top1">
                    Digital News
                </p>
                <p class="sizeContent mapa">${mostArticle.description}</p>
            </div>
            <!--search-->
            <div>
                <p class="titleItem colorTitle mapa">
                    Search
                </p>
                <!--click buttton to move to Search(Post)-->
                <form class="flex"  method="POST" action="Search">
                    <input type="text" class="search" name="search" required="true">
                    <input type="submit" class="button" value="Go">
                </form>
            </div>
            <!--Top 5 recent Aticle-->
            <div class="LastAr">
                <p class="titleItem colorTitle mapa">
                    Last Articles
                </p>
                <c:forEach var="article" items="${fiveRecentArticle}">
                    <!--click to view detail article-->
                    <p class="linkTopFive">
                    <a class="sizeContent colorTitle" href="viewarticle?id=${article.id}">${article.title}</a> 
                    </p>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
