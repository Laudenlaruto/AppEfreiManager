<%-- 
    Document   : ajouter
    Created on : 20 déc. 2017, 15:02:20
    Author     : cmarquet-lamagnere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-alpha.1/js/materialize.min.js"></script>
        <script src="ressources/js/script.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.debug.js"></script>
        <link rel="stylesheet" type="text/css" href="ressources/css/style.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>AppEfreiManager</title>
    </head>
    <body>

        <nav>
            <div class="nav-wrapper cyan darken-2">
                <a href="#" class="brand-logo center">EfreiManager</a>
                <ul class="left hide-on-med-and-down">
                    <li>
                        <form  action='Servlet' method='POST'>
                            <button class="btn waves-effect waves-light" type="submit" name="returnprofil">Retour</button>
                        </form>
                    </li>
                </ul>
                <ul class="right hide-on-med-and-down">
                    <li>${user.getNom()}  ${user.getPrenom()}</li>
                    <li>
                        <form class="form-inline my-2 my-lg-0" action='Servlet' method='POST'>
                            <button class="btn waves-effect waves-light" type="submit" name="deconnexion">Deconnexion</button>
                        </form>  
                    </li>  
                </ul>
            </div>
        </nav>


        <div class="row">
            
                <table class="striped centered col s8 offset-s2">
                    <thead>
                        <tr>
                            <th>Ajouter</th>
                            <th>Classe</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${stagiaires}" var="stagiaire">
                            <tr>
                                <form action='Servlet' method='POST'>
                                    <td><button type='submit' name='ajout' class="btn  waves-effect indigo"><i class="material-icons right">note_add</i>Ajouter</button></td>
                                    <td>${stagiaire.classe}</td>
                                    <td>${stagiaire.nom}</td>
                                    <td>${stagiaire.prenom}</td>
                                    <input type="hidden" name="idstag" value="${stagiaire.id}" />
                                    <input type="hidden" name="idtuteur" value="${user.getId()}" /> 
                                </form>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            
        </div>


    </body>
</html>
