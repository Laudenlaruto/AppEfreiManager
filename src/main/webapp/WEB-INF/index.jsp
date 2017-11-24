<%-- 
    Document   : index
    Created on : 16 nov. 2017, 15:17:41
    Author     : PC-Acta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>AppEfreiManager</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="WEB-INF/style.css">

    </head>
    <body>
    <center>
        <h5 class="indigo-text">EfreiManager</h5>
        <c:out value="${status}" />
        <div class="container">
            <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">
                <form class="col s12" action='Servlet' method='POST'>
                    <div class='row'>
                        <div class='col s12'></div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='text' name="login" id='login'/>
                            <label for='login'>Enter your login</label>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <input class='validate' type='password' name="password" id='password'/>
                            <label for='password'>Enter your password</label>
                        </div>
                    </div>
                    <br />
                    <center>
                        <div class='row'>
                            <input type="hidden" name="actionlogin">
                            <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Login</button>
                        </div>
                    </center>
                </form>
            </div>
        </div>
        <a href="http://www.efrei.fr/">Efrei</a>
    </center>
     <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>
</html>
