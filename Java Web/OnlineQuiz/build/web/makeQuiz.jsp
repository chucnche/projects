<%-- 
    Document   : makeQuiz
    Created on : Mar 25, 2020, 7:47:10 AM

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/makeQuiz.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="content">
                <div class="makeQuestion fontText">
                    <!--case user is student-->
                    <c:if test="${warning==true}">
                        <div class="warningMakeQuiz sizeText fontText">This function is for teachers only use</div>                  
                    </c:if>
                    <!--case user is teacher-->    
                    <c:if test="${warning==null}">
                        <div class="addQuestion">
                            <form action="MakeQuiz" method="post">
                                <div class="noti sizeText">${notify}</div>
                                <div class="flex">
                                    <div  class="sizeText colorText padingQ">Question:</div>
                                    <div><textarea class="textQuestion fontText" name="question" rows="7">${question}</textarea></div>                     
                                </div>
                                <div class="flex">
                                    <div class="sizeText colorText addOption">Option1:</div>
                                    <div><textarea class="textQuestion fontText" name="ans_1" rows="3">${ans_1}</textarea></div>                       
                                </div>
                                <div class="flex">
                                    <div class="sizeText colorText addOption">Option2:</div>
                                    <div><textarea class="textQuestion fontText" name="ans_2" rows="3" >${ans_2}</textarea></div>                       
                                </div>
                                <div class="flex">
                                    <div class="sizeText colorText addOption">Option3:</div>
                                    <div><textarea class="textQuestion fontText" name="ans_3" rows="3" >${ans_3}</textarea></div>                       
                                </div>
                                <div class="flex">
                                    <div class="sizeText colorText addOption">Option4:</div>
                                    <div><textarea class="textQuestion fontText"  name="ans_4" rows="3">${ans_4}</textarea></div>                       
                                </div>
                                <div class="flex colorText">
                                    <div class="sizeText">Answer(s):</div>
                                    <div class="flex">
                                        <input class="inputCheck" type="checkbox" name="true_ans"  value="1" ${checkbox1}/> Option 1
                                        <input class="inputCheck" type="checkbox" name="true_ans"  value="2" ${checkbox2}/> Option 2
                                        <input class="inputCheck" type="checkbox" name="true_ans"  value="3" ${checkbox3}/> Option 3
                                        <input class="inputCheck" type="checkbox" name="true_ans"  value="4" ${checkbox4}/> Option 4
                                    </div>
                                </div>
                                <div class="submit"><input type="submit" value="Save" /></div>

                            </form>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
