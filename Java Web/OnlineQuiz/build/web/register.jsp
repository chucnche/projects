<%-- 
    Document   : register
    Created on : Mar 25, 2020, 9:30:37 AM
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/register.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="content">
                <div class="all fontText sizeText">
                    <div class="title">
                        <div class="fontBold">Registration Form</div>
                    </div>
                    <div class="rg">
                        <div>${notify}</div>
                        <form action="Register" method="post">
                            <table>
                                <tr>
                                    <td class="titleUser">User Name:</td>
                                    <td><input class="inputText" type="text" name="username" value="${username}"  required="true"/></td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td><input class="inputText" type="password" name="password" value="${password}"  required="true"/></td>
                                </tr>
                                <tr>
                                    <td>User Type: </td>
                                    <td>
                                        <select name="role">
                                            <option value="teacher" ${teacher}>Teacher</option>
                                            <option value="student" ${student}>Student</option>
                                        </select>
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>Email:</td>
                                    <td><input type="inputText" name="email" value="${email}"  required="true"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input class="fontBold sizeText" type="submit" name="submit" value="Register"/></td>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
