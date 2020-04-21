<%-- 
    Document   : index
    Created on : Mar 24, 2020, 7:23:01 PM

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/index.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="welcome flex fontText">
                <p class="sizeText colorText">Welcome</p>
                <p class="user sizeText colorTitle">${sessionScope.Account.username}</p>
            </div>
        </div>
    </body>
</html>
