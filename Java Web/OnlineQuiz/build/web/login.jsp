<%-- 
    Document   : index
    Created on : Mar 23, 2020, 9:23:40 PM

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="content fontText sizeText ">
                <div class="all">
                    <div class="title">
                        <div class="fontBold sizeText">Login Form</div>
                    </div>
                    <div class="lg">
                        <p class="notiLogin"> ${notify} </p>
                        <form action="Home" method="POST">
                            <table>
                                <tr>
                                    <td class="colorText">User Name:</td>
                                    <td><input class="inputUser sizeText" type="text" name="username" value=""/></td>
                                </tr>
                                <tr>
                                    <td class="colorText">Password:</td>
                                    <td><input class="inputPass sizeText" type="password" name="password" value=""/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input class="buttonSubmit sizeText" type="submit" name="submit" value="Sign in"/> 
                                        <a class="linkRegister colorText" href="register.jsp">Register</a></td>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
