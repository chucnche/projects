<%-- 
    Document   : contact
    Created on : Mar 16, 2020, 7:39:04 PM
    Author     : Chucnc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/contact.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="wrap-content color-text flex">
                <div class="left">
                    <div>
                        <div class="titleContact">Contact</div>
                        <div class="titlePhoto">PHOTOGRAPHER</div>
                    </div>
                    <div class="font-text size-content">
                        <div class="pt">Address: ${information.address}</div>
                        <div  class="pt">City: ${information.city}</div>
                        <div  class="pt">Country: ${information.country}</div>
                        <div class="tel">Tel:${information.tel}</div>
                        <div>Email: ${information.email}</div>                       
                    </div>
                    <div class="imgContact">
                        <img class="inforImage" src="${information.image}"/>
                    </div>
                </div>
                <div class="right">
                    <%@include file="right.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
