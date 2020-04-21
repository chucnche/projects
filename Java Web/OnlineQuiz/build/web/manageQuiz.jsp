<%-- 
    Document   : makeQuiz
    Created on : Mar 24, 2020, 9:27:31 PM
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/manageQuiz.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="content fontText sizeText ">
                <!--case user is student-->
                <c:if test="${warning==true}">
                    <div class="warning sizeText fontText">This function is for teachers only use</div>
                </c:if>
                <!--case user is teacher-->
                <c:if test="${warning==null}">
                    <div class="numberQuestions sizeText flex">
                        <p class="colorText">Number of questions:</p>
                        <p class="nQ fontBold colorTitle">${numberQuestions}</p>
                    </div>
                    <table class="tableManage">
                        <tr class="sizeText flex colorTitle">
                            <td class="columQuestions">Questions</td>
                            <td class="columDateCreated">DateCreated</td>
                            <td></td>
                        </tr>
                        <c:forEach items="${listQuestions}" var="q">
                            <tr class="sizeText flex">
                                <td class="columQuestions">${q.q_name}</td>
                                <td class="columDateCreated">${q.date_created}</td>
                                <td><a onclick="return confirm('Are you want to delete?')" href="ManageQuiz?id=${q.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <!--show page index-->
                    <div class="paging flex">
                        <c:forEach var="i" begin="1" end="${numberPage}">
                            <!--page current-->
                            <c:if test="${i == page}">
                                <p>${i}</p>
                            </c:if>
                            <!--other pages:If clicked, it will move to a new page-->
                            <c:if test="${i != page}">
                                <a href="ManageQuiz?page=${i}" >${i}</a>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>
