/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proprietes.DocumentPDF;
import sources.StagiaireController;
import sources.UserController;

/**
 *
 * @author PC-Acta
 */

public class Servlet extends HttpServlet {
    private static final String PAGE_PROFIL = "/WEB-INF/profil.jsp";
    private static final String PAGE_INDEX = "/WEB-INF/index.jsp";
    private static final String PAGE_DECONNEXION = "/WEB-INF/deconnexion.jsp";
    private static final String PAGE_DETAIL = "/WEB-INF/detail.jsp";
    private static final String PAGE_AJOUTER = "/WEB-INF/ajouter.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher(PAGE_INDEX).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("actionlogin") != null) {
            if (!request.getParameter("login").equals("") || !request.getParameter("password").equals("")) {
                UserController usercontroller = new UserController();
                User user = usercontroller.getUser(request.getParameter("login"), request.getParameter("password"));

                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("userid", user.getId());

                    StagiaireController stagiaireController = new StagiaireController();
                    List<Stagiaire> stagiaires = stagiaireController.getStagiaires(user.getId());
                    
                    request.getSession().setAttribute("stagiares", stagiaires);
                    request.getSession().setAttribute("size", stagiaires.size());

                    request.setAttribute("stagiaires", request.getSession().getAttribute("stagiares"));
                    request.setAttribute("size", request.getSession().getAttribute("size"));

                    request.getRequestDispatcher(PAGE_PROFIL).forward(request, response);
                } else {
                    request.getSession().setAttribute("status", "Erreur d'authentification / Utilisateur n'existe pas");
                    request.getServletContext().getRequestDispatcher(PAGE_INDEX).forward(request, response);
                }
            } else {
                request.getSession().setAttribute("status", "Veuillez remplir les champs vides");
                request.getServletContext().getRequestDispatcher(PAGE_INDEX).forward(request, response);
            }
        } else if (request.getParameter("deconnexion") != null) {
            request.getSession().invalidate();
            request.getServletContext().getRequestDispatcher(PAGE_DECONNEXION).forward(request, response);
        } else if (request.getParameter("returnhome") != null) {
            request.getSession().invalidate();
            request.getServletContext().getRequestDispatcher(PAGE_INDEX).forward(request, response);       
        }
        else if (request.getParameter("returnprofil") != null) {
            StagiaireController stagiaireController = new StagiaireController();
            List<Stagiaire> stagiaires = stagiaireController.getStagiaires((int)(request.getSession().getAttribute("userid")));
            request.setAttribute("stagiaires", stagiaires);
            request.setAttribute("size", stagiaires.size());
            request.getRequestDispatcher(PAGE_PROFIL).forward(request, response);
        }
        else if (request.getParameter("actionupdatestagiaire") != null) {
            StagiaireController stag = new StagiaireController();
            String[] id = request.getParameterValues("id");
            for (int i=0; i<id.length;i++){
                Stagiaire stagiaire = new Stagiaire();
                stagiaire.setId(Integer.valueOf(id[i]));
                stagiaire.setNom(request.getParameter(id[i]+".nom"));
                stagiaire.setClasse(request.getParameter(id[i]+".classe"));
                stagiaire.setCdc((request.getParameter(id[i]+".cdc") != null));
                stagiaire.setFiche_visite((request.getParameter(id[i]+".fiche_visite") != null));
                stagiaire.setFiche_evaluation(request.getParameter(id[i]+".fiche_evaluation")!=null);
                stagiaire.setSondage_web(request.getParameter(id[i]+".sondage_web")!=null);
                stagiaire.setRapport_rendu(request.getParameter(id[i]+".rapport_rendu")!=null);
                stagiaire.setSoutenance(request.getParameter(id[i]+".soutenance")!=null);
                stagiaire.setVisite_planif(request.getParameter(id[i]+".visite_planif")!=null);
                stagiaire.setVisite_faite(request.getParameter(id[i]+".visite_faite")!=null);
                if(!request.getParameter(id[i]+".startDate").equals("")){
                    stagiaire.setDebut(Date.valueOf(request.getParameter(id[i]+".startDate")));
                }
                if(!request.getParameter(id[i]+".endDate").equals("")){
                      stagiaire.setFin(Date.valueOf(request.getParameter(id[i]+".endDate")));
                }
                stagiaire.setEntreprise(request.getParameter(id[i]+".entreprise"));
                stagiaire.setMds(request.getParameter(id[i]+".mds"));
                stagiaire.setStage_adresse(request.getParameter(id[i]+".addr"));
                stagiaire.setNote_tech(Integer.valueOf(request.getParameter(id[i]+".note_tech")));
                stagiaire.setNote_com(Integer.valueOf(request.getParameter(id[i]+".note_com")));
                
                stag.updateStagiaire(stagiaire);
            }
            StagiaireController stagiaireController = new StagiaireController();
            List<Stagiaire> stagiaires = stagiaireController.getStagiaires((int)request.getSession().getAttribute("userid"));
            request.setAttribute("stagiaires", stagiaires);
            request.setAttribute("size", stagiaires.size());
            request.getRequestDispatcher(PAGE_PROFIL).forward(request, response);

        }
        //Génaration du PDF
        else if (request.getParameter("actionvalider")!=null){
            String idStagiaire = request.getParameter("idstag");
            StagiaireController stag = new StagiaireController();
            stag.updateCommentaire(request.getParameter("commentaire"), idStagiaire);
            stag.updateDescription(request.getParameter("description_mission"), idStagiaire);
            
            String nomUser = request.getParameter("nomUser");
            String prenomUser = request.getParameter("prenomUser");

            DocumentPDF pdf = new DocumentPDF(stag.getStagiaire(idStagiaire),new User(nomUser,prenomUser) );
            
            request.setAttribute("detailstagiaire", stag.getStagiaire(idStagiaire));
            request.setAttribute("popup","Le PDF à été téléchargé dans votre dossier Téléchargement");
            request.getRequestDispatcher(PAGE_DETAIL).forward(request, response);
            
        }
        //Detail d'un stagiaire
        else if (request.getParameter("actiondetailstagiaire")!=null){
            if(request.getParameterValues( "idstag" ) != null){
                String idStagiaire = request.getParameter("idstag");
                StagiaireController stag = new StagiaireController();
                request.setAttribute("detailstagiaire", stag.getStagiaire(idStagiaire));
                request.getRequestDispatcher(PAGE_DETAIL).forward(request, response); 
            }else{
                request.setAttribute("erreur", "Veuillez cocher une case");
                
                StagiaireController stagiaireController = new StagiaireController();
                List<Stagiaire> stagiaires = stagiaireController.getStagiaires((int)request.getSession().getAttribute("userid"));
                request.setAttribute("stagiaires", stagiaires);
               request.setAttribute("size", stagiaires.size());
               request.getServletContext().getRequestDispatcher(PAGE_PROFIL).forward(request, response);
            }
            
            
        }
        //Ajouter un stagiaire
        else if (request.getParameter("actionajouterstagiaire")!=null){
            StagiaireController stag = new StagiaireController();
            List<Stagiaire> stagiaires = stag.getStagiairesSansTuteur();
            request.setAttribute("stagiaires", stagiaires);
            request.getRequestDispatcher(PAGE_AJOUTER).forward(request, response); 
        }
        //Valider création d'un stagiaire
        else if (request.getParameter("ajout")!=null){
            String idStagiaire = request.getParameter("idstag");
            StagiaireController stag = new StagiaireController();
            System.out.println("ID DU STAGIAIRE :"+request.getParameter("idstag")+":");
            System.out.println("ID DU TUTEUR :"+request.getParameter("idtuteur")+":");
            stag.addStagiaire(stag.getStagiaireSansTuteur(idStagiaire),request.getParameter("idtuteur"));
            
            List<Stagiaire> stagiaires = stag.getStagiairesSansTuteur();
            request.setAttribute("stagiaires", stagiaires);
            request.getRequestDispatcher(PAGE_AJOUTER).forward(request, response); 
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
