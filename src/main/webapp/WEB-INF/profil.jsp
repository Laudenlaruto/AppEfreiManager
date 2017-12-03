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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-alpha.1/js/materialize.min.js"></script>
        <script src="ressources/js/script.js"></script>

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>AppEfreiManager</title>
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
                           <input name="modifstagiaire" type="radio" id="${stagiaire.id}" />
                           <label for="${stagiaire.id}"></label>
                           </td>  
                            <td><c:out value="${stagiaire.classe}" /></td>
                            <td><c:out value="${stagiaire.nom}" /></td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="cdc" <c:if test="${stagiaire.cdc}">checked</c:if> disabled="disabled" />
                                    <label for="cdc"></label>
                                  </p>
                            </td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="fiche" <c:if test="${stagiaire.fiche}">checked</c:if> disabled="disabled" />
                                    <label for="fiche"></label>
                                  </p>
                            </td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="visite" <c:if test="${stagiaire.fiche_evaluation}">checked</c:if> disabled="disabled" />
                                    <label for="visite"></label>
                                  </p>
                            </td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="test7" <c:if test="${stagiaire.sondage_web}">checked</c:if> disabled="disabled" />
                                    <label for="test7"></label>
                                  </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" id="test7" <c:if test="${stagiaire.rapport_rendu}">checked</c:if> disabled="disabled" />
                                    <label for="test7"></label>
                                  </p>
                            </td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="test7" <c:if test="${stagiaire.soutenance}">checked</c:if> disabled="disabled" />
                                    <label for="test7"></label>
                                  </p>
                            </td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="test7" <c:if test="${stagiaire.rapport_rendu}">checked</c:if> disabled="disabled" />
                                    <label for="test7"></label>
                                  </p>
                            </td>
                            <td>
                                 <p>
                                    <input type="checkbox" id="test7" <c:if test="${stagiaire.soutenance}">checked</c:if> disabled="disabled" />
                                    <label for="test7"></label>
                                  </p>
                            </td>
                            <td><c:out value="${stagiaire.debut}" /></td>
                            <td><c:out value="${stagiaire.fin}" /></td>
                            <td><c:out value="${stagiaire.entreprise}" /></td>
                            <td><c:out value="${stagiaire.mds}" /></td>
                            <td><c:out value="${stagiaire.stage_adresse}" /></td>
                            <td><c:out value="${stagiaire.note_tech}" /></td>
                            <td><c:out value="${stagiaire.note_com}" /></td>
                       </tr>
                    </tbody>
                </c:forEach>
            </table>
            <a class="waves-effect waves-light btn modal-trigger" id="buttondetails" href="#details">Détails 
                <i class="material-icons">assignment</i>            
            </a>
            <a class="waves-effect waves-light btn modal-trigger" href="#ajout">Ajouter un stagiaire 
                <i class="material-icons">note_add</i>            
            </a>


            <div id="details" class="modal">
              <div class="modal-content">
                <h4>Stagiaires</h4>
                <p id="idstag"></p>
                <p id="data"></p>
              </div>
              <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
              </div>
            </div>
            
           </c:when>
           <c:otherwise>
               <p>Aucun stagiaire ne vous a été affecté! Contactez le service des stages.</p>
           </c:otherwise>
       </c:choose>

    </body>

</html>
