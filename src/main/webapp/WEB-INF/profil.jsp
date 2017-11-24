<%-- 
    Document   : profil
    Created on : 17 nov. 2017, 16:10:25
    Author     : lauden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <title>AppEfreiManager Profile</title>
    </head>
    <body>

        <nav>
            <div class="nav-wrapper cyan darken-2">
                <a href="#" class="brand-logo center">EfreiManager</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li>${user.getNom()}  ${user.getPrenom()}</li>
                    <li>
                        <form class="form-inline my-2 my-lg-0" action='Servlet' method='POST'>
                            <button class="btn waves-effect waves-light" type="submit" name="deconnexion">Deconnexion
                            </button>
                        </form>  
                    </li>  
                </ul>
            </div>
        </nav>           
            <c:forEach items="${stagiaires}" var="stagiaire">
               <c:out value="${stagiaire.nom}" />
            </c:forEach>
    </body>
</html>
