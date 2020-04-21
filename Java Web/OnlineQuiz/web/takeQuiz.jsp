<%-- 
    Document   : takeQuiz
    Created on : Mar 25, 2020, 11:06:37 AM
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Question"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/takeQuiz.css" rel="stylesheet" type="text/css"/>
        <script src="public/js/takeQuiz.js" type="text/javascript"></script>
        <script src="public/js/time.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="content">
                <div class="all fontText sizeText">
                    <!--create quiz-->
                    <c:if test="${start==false}">
                        <div class="flex fontText">
                            <p class="colorText">Welcome</p>
                            <p class="userTakeQuiz colorTitle">${sessionScope.Account.username}</p>
                        </div>
                        <div>
                            <p class="notifyTakeQuiz">${notify}</p>
                            <!--enter number question-->
                            <form action="TakeQuiz" method="post">
                                <div class="colorText"> Enter number of questions: </div>
                                <div> <input class="inputNumberQuesions" type="text" name="numberQuestions"/> </div>
                                <div class="buttonStart"> <input class="sizeText fontText" type="submit" value="Start"/> </div>  
                            </form> 
                        </div>                  
                    </c:if>
                    <!--test-->
                    <c:if test="${start==true}">
                        <div class="flex fontText">
                            <p class="colorText">Welcome</p>
                            <p class="userTakeQuiz colorTitle">${sessionScope.Account.username}</p>
                        </div>
                        <!--show time remaining-->
                        <div class="title-time">
                            <div class="time flex">
                                <p class="">Time remaining</p>
                                <p class="timeRemaining" id="time"></p>
                            </div>
                        </div>
                        <!--show question-->
                        <form action="TakeQuiz" method="post" id="takeResult">
                            <c:forEach items="${listQuestions}" var="q">
                                <c:if test="${q.index==1}">
                                    <div id="q${q.index}" class="question colorText">    
                                </c:if>
                                <c:if test="${q.index!=1}">
                                    <div id="q${q.index}" class="hidden question colorText">  
                                </c:if>
                                        <input type="hidden" name="q${q.index}" value="${q.id}"/>
                                        <input type="hidden" name="numberQ" value="${numberQ}"/>
                                        <p>${q.q_name}</p>
                                        <p> <input type="checkbox" name="true_ans${q.index}" value="1" />${q.ans_1}</p>
                                        <p> <input type="checkbox" name="true_ans${q.index}" value="2" />${q.ans_2}</p>
                                        <p> <input type="checkbox" name="true_ans${q.index}" value="3" />${q.ans_3}</p>
                                        <p> <input type="checkbox" name="true_ans${q.index}"  value="4" />${q.ans_4}</p>
                                    </div>
                            </c:forEach>
                            <div class="buttonNextFinish">   
                                <button class="${buttonNext}" id="next" type="button" onclick="nextQ(${numberQ})">Next</button> 
                                <input  class="${buttonFinish}" id="finish" type="submit" value="Finish"/>                             
                            </div>
                        </form>                
                    </c:if>
                    <!--result-->
                    <c:if test="${start==null}">
                        <div class="flex">
                            <p class="score colorText">Your score</p>
                            <p class="colorTitle">${score}${passed}</p>
                        </div> 

                        <form action="TakeQuiz">
                            <div class="flex">
                                <p class="anotherTitle colorText">Take another test</p>
                                <p><input class="sizeText" type="submit" value="Start" /></p>
                            </div> 
                        </form>

                    </c:if>
                </div>
            </div>
        </div>

        <script>
            clock(${time});
        </script>
    </body>
</html>
