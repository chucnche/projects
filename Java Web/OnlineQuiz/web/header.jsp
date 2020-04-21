<%-- 
    Document   : header
    Created on : Mar 23, 2020, 9:23:53 PM

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/header.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="prev"></div>
        <div class="menu">
            <div class="mn">
                <ul >
                    <li><a class="fontBold fontText sizeText" href="Home">Home</a></li>
                    <li><a class="fontBold fontText sizeText" href="TakeQuiz">Take Quiz</a></li>
                    <li><a class="fontBold fontText sizeText" href="MakeQuiz">Make Quiz</a></li>
                    <li><a class="fontBold fontText sizeText" href="ManageQuiz">Manage Quiz</a></li>  
                    <!--if logined => show logout-->
                    <c:if test="${sessionScope.Account!=null}">
                        <li><a class="fontBold fontText sizeText" href="Logout">Logout</a></li>
                    </c:if>
                </ul>
            </div>
        </div>

    </body>
</html>
