<%-- 
    Document   : right
    Created on : Mar 16, 2020, 1:33:27 PM
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
        <div class="wrap-right">
            <div class="title-share">
                <p class="color-text">Share this page</p>
            </div>
            <div class="social size-content ">
                    <c:forEach var="s" items="${ShareList}" >
                        <div class="all-link flex">
                            <img src="${s.icon}" width="9px" height="11px"/>
                            <a class="linkShare color-text font-text" href="${s.url}">Share on ${s.socialNetwork}</a>
                        </div>
                    </c:forEach>
            </div>
        </div> 
    </body>
</html>
