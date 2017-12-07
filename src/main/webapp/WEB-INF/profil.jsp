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
                           <input checked="checked" name="modifstagiaire" type="radio" id="${stagiaire.id}" />
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
            
            <div class="right">
                <a class="waves-effect waves-light btn modal-trigger" id="buttondetails" href="#details"><i class="material-icons right">assignment</i>Détails</a>
                <a class="waves-effect waves-light btn modal-trigger" href="#ajout"><i class="material-icons right">note_add</i>Ajouter un stagiaire</a>
            </div>

            <div id="details" class="modal">
              <div class="modal-content">
                <h4>Stagiaires</h4>
                <p id="idstag"></p>
                <p id="data"></p>
                <table class="striped">
                    <tbody>
                        <tr>
                            <td>Classe</td>
                            <td><span id="classe"></span></td>
                        </tr>
                        <tr>
                            <td>Nom</td>
                            <td><span id="nom"></span></td>
                        </tr>
                        <tr>
                            <td>Prenom</td>
                            <td><span id="prenom"></span></td>
                        </tr>
                        <tr>
                            <td>Cdc</td>
                            <td><input type="checkbox" id="cdc" checked="false" disabled="disabled" /> <label for="cdc"></label></td>
                        </tr>
                        <tr>
                            <td>Fiche</td>
                            <td><input type="checkbox" id="fiche" checked="false" disabled="disabled" /> <label for="fiche"></label></td>
                        </tr>
                        <tr>    
                            <td>Visite</td>
                            <td><input type="checkbox" id="visite" checked="false" disabled="disabled" /> <label for="visite"></label></td>
                        </tr>
                        <tr>
                            <td>Fiche Evaluation</td>
                            <td><input type="checkbox" id="fiche_evaluation" checked="false" disabled="disabled" /> <label for="fiche_evaluation"></label></td>
                        </tr>
                        <tr>
                            <td>Sondage web</td>
                            <td><input type="checkbox" id="sondage_web" checked="false" disabled="disabled" /> <label for="sondage_web"></label></td>
                        </tr>
                        <tr>
                            <td>Rapport rendu</td>
                            <td><input type="checkbox" id="rapport_rendu" checked="false" disabled="disabled" /> <label for="rapport_rendu"></label></td>
                        </tr>
                        <tr>
                            <td>Soutenance</td>
                            <td><input type="checkbox" id="soutenance" checked="false" disabled="disabled" /> <label for="soutenance"></label></td>
                        </tr>
                        <tr>
                            <td>Visite planif</td>
                            <td><input type="checkbox" id="visite_planif" checked="false" disabled="disabled" /> <label for="visite_planif"></label></td>
                        </tr>
                        <tr>
                            <td>Visite faite</td>
                            <td><input type="checkbox" id="visite_faite" checked="false" disabled="disabled" /> <label for="visite_faite"></label></td>
                        </tr>
                        <tr>
                            <td>Debut</td>
                            <td><span id="debut"></span></td>
                        </tr>
                        <tr>
                            <td>Fin</td>
                            <td><span id="fin"></span></td>
                        </tr>
                        <tr>
                            <td>Entreprise</td>
                            <td><span id="entreprise"></span></td>
                        </tr>
                        <tr>
                            <td>Mds</td>
                            <td><span id="mds"></span></td>
                        </tr>
                        <tr>
                            <td>Stage adresse</td>
                            <td><span id="stage_adresse"></span></td>
                        </tr>
                        <tr>
                            <td>Note tech</td>
                            <td><span id="note_tech"></span></td>
                        </tr>
                        <tr>
                            <td>Note com</td>
                            <td><span id="note_com"></span></td>
                        </tr>
                    </tbody>
                    </table>

                    <div class="row">
                        <div class="input-field col s12">
                             <textarea id="commentaire" class="materialize-textarea"></textarea>
                             <label for="de">Commentaire</label>
                       </div>
                     </div>
                
                    <div class="row">
                        <div class="input-field col s12">
                             <textarea id="description_mission" class="materialize-textarea"></textarea>
                             <label for="de">Description Mission</label>
                       </div>
                     </div>
                
                
                
                
              </div>
              <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat" id="valider">Valider</a>
              </div>
            </div>
            
           </c:when>
           <c:otherwise>
               <p>Aucun stagiaire ne vous a été affecté! Contactez le service des stages.</p>
           </c:otherwise>
       </c:choose>

    </body>

</html>