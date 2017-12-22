<%-- 
    Document   : detail
    Created on : 20 déc. 2017, 10:16:05
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
                    
                    
                    <h4>Stagiaires</h4>
                    <div class="row">
                        <table class="striped col s4">
                            <tbody>
                                <tr>
                                    <td>Classe</td>
                                    <td><span id="classe">${detailstagiaire.classe}</span></td>
                                </tr>
                                <tr>
                                    <td>Nom</td>
                                    <td><span id="nom">${detailstagiaire.nom}</span></td>
                                </tr>
                                <tr>
                                    <td>Prenom</td>
                                    <td><span id="prenom">${detailstagiaire.prenom}</span></td>
                                </tr>
                                <tr>
                                    <td>Cdc</td>
                                    <td><input type="checkbox" id="cdc" disabled="disabled" <c:if test="${detailstagiaire.cdc}">checked</c:if> /> <label for="cdc"></label></td>
                                </tr>
                                <tr>
                                    <td>Fiche visite</td>
                                    <td><input type="checkbox" id="fiche_visite" <c:if test="${detailstagiaire.fiche_visite}">checked</c:if> disabled="disabled" /> <label for="fiche_visite"></label></td>
                                </tr>
                                <tr>
                                    <td>Fiche Evaluation</td>
                                    <td><input type="checkbox" id="fiche_evaluation" <c:if test="${detailstagiaire.fiche_evaluation}">checked</c:if> disabled="disabled" /> <label for="fiche_evaluation"></label></td>
                                </tr>
                                <tr>
                                    <td>Sondage web</td>
                                    <td><input type="checkbox" id="sondage_web" <c:if test="${detailstagiaire.sondage_web}">checked</c:if> disabled="disabled" /> <label for="sondage_web"></label></td>
                                </tr>
                                <tr>
                                    <td>Rapport rendu</td>
                                    <td><input type="checkbox" id="rapport_rendu" <c:if test="${detailstagiaire.rapport_rendu}">checked</c:if> disabled="disabled" /> <label for="rapport_rendu"></label></td>
                                </tr>
                                <tr>
                                    <td>Soutenance</td>
                                    <td><input type="checkbox" id="soutenance" <c:if test="${detailstagiaire.soutenance}">checked</c:if> disabled="disabled" /> <label for="soutenance"></label></td>
                                </tr>
                                <tr>
                                    <td>Visite planif</td>
                                    <td><input type="checkbox" id="visite_planif" <c:if test="${detailstagiaire.visite_planif}">checked</c:if> disabled="disabled" /> <label for="visite_planif"></label></td>
                                </tr>
                                <tr>
                                    <td>Visite faite</td>
                                    <td><input type="checkbox" id="visite_faite" <c:if test="${detailstagiaire.visite_faite}">checked</c:if> disabled="disabled" /> <label for="visite_faite"></label></td>
                                </tr>
                                <tr>
                                    <td>Debut - Fin</td>
                                    <td><span id="debut">${detailstagiaire.debut} | ${detailstagiaire.fin}</span></td>
                                </tr>
                                <tr>
                                    <td>Entreprise</td>
                                    <td><span id="entreprise">${detailstagiaire.entreprise}</span></td>
                                </tr>
                                <tr>
                                    <td>Maitre de stage</td>
                                    <td><span id="mds">${detailstagiaire.mds}</span></td>
                                </tr>
                                <tr>
                                    <td>Stage adresse</td>
                                    <td><span id="stage_adresse">${detailstagiaire.stage_adresse}</span></td>
                                </tr>
                                <tr>
                                    <td>Note tech</td>
                                    <td><span id="note_tech">${detailstagiaire.note_tech}</span></td>
                                </tr>
                                <tr>
                                    <td>Note com</td>
                                    <td><span id="note_com">${detailstagiaire.note_com}</span></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row">
                            <form action='Servlet' method='POST'>
                            <div class="input-field col s6 offset-s1">
                                <textarea name="commentaire" id="commentaire" class="materialize-textarea">${detailstagiaire.commentaire}</textarea>
                                <label for="de">Commentaire</label>
                            </div>
                            
                            <div class="input-field col s6 offset-s1">
                                <textarea name="description_mission" id="description_mission" class="materialize-textarea">${detailstagiaire.description_mission}</textarea>
                                <label for="de">Description Mission</label>
                            </div>
                                
                                    <input type="hidden" value="${detailstagiaire.id}" name="idstag">
                                    <input type="hidden" value="${user.getNom()}" name="nomUser"> 
                                    <input type="hidden" value="${user.getPrenom()}" name="prenomUser"> 
                                    <button type='submit' name='actionvalider' class="col s2 btn  waves-effect offset-s3" onclick="Materialize.toast('PDF télécharge dans votre repertoire de téléchargment',4000)"><i class="material-icons right">file_download</i>Valider</button>
                                </form>
                                     <c:if test="${not empty popup}">
                                        <div class="col s2 offset-s3">
                                           <div class="card-panel teal">
                                             <span class="white-text">
                                                 ${popup}
                                             </span>
                                           </div>
                                        </div>   
                                    </c:if>
 
                        </div>

                    </div>
                                
    </body>
</html>
