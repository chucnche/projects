<%-- 
    Document   : Search
    Created on : Feb 26, 2020, 8:18:13 PM
    Author     : Chucnc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/search.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container">
            <div class="wrap-content flex">
                <div class="left">
                    <!--If not find anything will notify-->
                    <c:if test="${found==false}">
                        <p class="not-found">Not found Anything</p>
                    </c:if>
                    <!--show result search in page current-->
                    <c:forEach var="article" items="${listSearch}">
                        <p class="titleArticle ">
                            <a class="colorTitle searchTitle" href="viewarticle?id=${article.id}">${article.title}</a>
                        </p>
                        <div class="text-wrap">        
                            <img class="search-img"  src="${article.image}"/>
                            <p class="sizeContent descrip" >${article.description}</p>                         
                        </div>
                    </c:forEach>

                    <!--show page index-->
                    <div class="paging flex">
                        <c:forEach var="i" begin="1" end="${numberPage}">
                            <!--page current-->
                            <c:if test="${i == page}">
                                <p>${i}</p>
                            </c:if>
                            <!--other pages:If clicked, it will move to a new page-->
                            <c:if test="${i != page}">
                                <a href="Search?page=${i}&search=${search}" >${i}</a>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <%@include file="right.jsp"%>
            </div>
            <footer class="footer">
            </footer>
        </div>
    </body>
</html>
