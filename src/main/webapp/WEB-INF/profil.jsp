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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.debug.js"></script>
        <link rel="stylesheet" type="text/css" href="ressources/css/style.css">
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
               
                <form action='Servlet' method='POST'>
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
                                        <input name="idstag" type="radio" id="${stagiaire.id}" value="${stagiaire.id}" />
                                        <label for="${stagiaire.id}"></label>
                                    </td>
                            <input type="hidden" name="id" value="${stagiaire.id}" />                                   

                            <td><input type="text" name="${stagiaire.id}.classe" value="${stagiaire.classe}" /></td>
                            <td><input type="text" name="${stagiaire.id}.nom" value="${stagiaire.nom}" /></td>

                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.cdc" id="${stagiaire.id}.cdc"  <c:if test="${stagiaire.cdc}">checked</c:if> />
                                    <label for="${stagiaire.id}.cdc"></label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.fiche_visite" id="${stagiaire.id}.fiche_visite" <c:if test="${stagiaire.fiche_visite}">checked</c:if>  />
                                    <label for="${stagiaire.id}.fiche_visite"></label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.fiche_evaluation" id="${stagiaire.id}.fiche_evaluation"  <c:if test="${stagiaire.fiche_evaluation}">checked</c:if>  />
                                    <label for="${stagiaire.id}.fiche_evaluation"</label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.sondage_web"  id="${stagiaire.id}.sondage_web" <c:if test="${stagiaire.sondage_web}">checked</c:if>  />
                                    <label for="${stagiaire.id}.sondage_web"></label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.rapport_rendu" id="${stagiaire.id}.rapport_rendu" <c:if test="${stagiaire.rapport_rendu}">checked</c:if>/>
                                    <label for="${stagiaire.id}.rapport_rendu"></label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.soutenance" id="${stagiaire.id}.soutenance" <c:if test="${stagiaire.soutenance}">checked</c:if>  />
                                    <label for="${stagiaire.id}.soutenance"></label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.visite_planif" id="${stagiaire.id}.visite_planif"  <c:if test="${stagiaire.visite_planif}">checked</c:if>  />
                                    <label for="${stagiaire.id}.visite_planif"></label>
                                </p>
                            </td>
                            <td>
                                <p>
                                    <input type="checkbox" name="${stagiaire.id}.visite_faite" id="${stagiaire.id}.visite_faite"  <c:if test="${stagiaire.visite_faite}">checked</c:if>  />
                                    <label for="${stagiaire.id}.visite_faite"></label>
                                </p>
                            </td>

                            <td><input type="date" name="${stagiaire.id}.startDate" value="${stagiaire.debut}" /></td>
                            <td><input type="date" name="${stagiaire.id}.endDate" value="${stagiaire.fin}" /></td>
                            <td><input type="text" name="${stagiaire.id}.entreprise" value="${stagiaire.entreprise}" /></td>
                            <td><input type="text" name="${stagiaire.id}.mds" value="${stagiaire.mds}" /></td>
                            <td><input type="text" name="${stagiaire.id}.addr" value="${stagiaire.stage_adresse}" /></td>
                            <td><input type="number" name="${stagiaire.id}.note_tech" value="${stagiaire.note_tech}" /></td>
                            <td><input type="number" name="${stagiaire.id}.note_com" value="${stagiaire.note_com}" /></td>


                            </tr>

                        </c:forEach>
                        </tbody>

                    </table>

                    <div class="right">
                        <button type='submit' name='actionupdatestagiaire' class='btn  waves-effect indigo'><i class="material-icons right">cached</i>Mettre à jour stagiaire</button>
                            
                        <button type='submit' name='actiondetailstagiaire' class="btn  waves-effect indigo"><i class="material-icons right">assignment</i>Détails</button>
                        
                        <button type='submit' name='actionajouterstagiaire' class="btn  waves-effect indigo"><i class="material-icons right">note_add</i>Ajouter un stagiaire</button>
                    </div>
                     <c:if test="${not empty erreur}">
                    <div class ="row">
                        <div id="card-alert" class="card red col s2 offset-s8">
                      <div class="card-content white-text">
                          <p><c:out value="${erreur}"/></p>
                      </div>
                    </div>  
                    </div>    
                    </c:if>
                </form>
                  

            </c:when>
            <c:otherwise>
                <p>Aucun stagiaire ne vous a été affecté! Contactez le service des stages.</p>
            </c:otherwise>
        </c:choose>

    </body>

</html>
