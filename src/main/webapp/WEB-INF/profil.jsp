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

        <c:choose>
           <c:when test="${not empty stagiaires}">
            <table class="centered striped">
                <thead>
                    <tr>
                      <th>Select</th>
                      <th>Classe</th>
                      <th>Name</th>
                      <th>Cdc</th>
                      <th>Fiche de visite</th>
                      <th>Fiche Eval Entr</th>
                      <th>Sondage web</th>
                      <th>Rapport rendu</th>
                      <th>Soutenance</th>
                      <th>Planification visite</th>
                      <th>Visite Faite</th>
                      <th>Debut</th>
                      <th>Fin</th>
                      <th>Entreprise</th>
                      <th>Mds</th>
                      <th>Adresse</th>
                      <th>Note Tech</th>
                      <th>Note Com</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${stagiaires}" var="stagiaire">
                       <tr>
                           <td>
                           <input name="modifstagiaire" type="radio" id="${stagiaire.prenom}" />
                           <label for="${stagiaire.prenom}"></label>
                           </td>  
                            <td contenteditable='true'><c:out value="${stagiaire.classe}" /></td>
                            <td><c:out value="${stagiaire.nom}" /></td>
                            <td contenteditable='true'><c:out value="${stagiaire.cdc}" /></td>
                            <td contenteditable='true'><c:out value="${stagiaire.fiche}" /></td>
                            <td contenteditable='true'><c:out value="${stagiaire.fiche_evaluation}" /></td>
                            <td><c:out value="${stagiaire.sondage_web}" /></td>
                            <td><c:out value="${stagiaire.rapport_rendu}" /></td>
                            <td><c:out value="${stagiaire.soutenance}" /></td>
                            <td><c:out value="${stagiaire.visite_planif}" /></td>
                            <td><c:out value="${stagiaire.visite_faite}" /></td>
                            <td><c:out value="${stagiaire.debut}" /></td>
                            <td><c:out value="${stagiaire.fin}" /></td>
                            <td><c:out value="${stagiaire.entreprise}" /></td>
                            <td><c:out value="${stagiaire.mds}" /></td>
                            <td contenteditable='true'><c:out value="${stagiaire.stage_adresse}" /></td>
                            <td contenteditable='true'><c:out value="${stagiaire.note_tech}" /></td>
                            <td contenteditable='true'><c:out value="${stagiaire.note_com}" /></td>
                       </tr>
                    </tbody>
                </c:forEach>
            </table>
            <button class="btn waves-effect waves-light" type="submit" name="detail">Détail
                <i class="material-icons right">cached</i>
            </button>
            <button class="btn waves-effect waves-light" type="submit" name="valider">Valider
                <i class="material-icons right">cached</i>
            </button>
            <button class="btn waves-effect waves-light" type="submit" name="ajouter">Ajouter
                <i class="material-icons right">cached</i>
            </button>
           </c:when>
           <c:otherwise>
               <p>Aucun stagiaire ne vous a été affecté! Contactez le service des stages.</p>
           </c:otherwise>
       </c:choose>

    </body>
</html>
