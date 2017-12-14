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
import java.util.List;
import java.util.Properties;
import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                    StagiaireController stagiaireController = new StagiaireController();
                    List<Stagiaire> stagiaires = stagiaireController.getStagiaires(user.getId());
                    request.setAttribute("stagiaires", stagiaires);
                    request.setAttribute("size", stagiaires.size());

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
        else if (request.getParameter("getuser")!=null){
            StagiaireController stagiaireController = new StagiaireController();
            Stagiaire stagiaire = stagiaireController.getStagiaire(request.getParameter("getuser"));
            String json = new Gson().toJson(stagiaire);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        } else if (request.getParameter("actionupdatestagiaire") != null) {
  
            String[] id = request.getParameterValues("id");
            for (int i=0; i<id.length;i++){
                Stagiaire stagiaire = new Stagiaire();
                stagiaire.setCdc(Boolean.valueOf(request.getParameter(id[i]+".cdc")));
                stagiaire.setCdc(Boolean.valueOf(request.getParameter(id[i]+".fiche_visite")));
                stagiaire.setCdc(Boolean.valueOf(request.getParameter(id[i]+".fiche_evaluation")));
               
                
            }
            
            

          

        }
        else if (request.getParameter("createPDF")!=null){
            StagiaireController stagiaireController = new StagiaireController();
            Stagiaire stagiaire = stagiaireController.getStagiaire(request.getParameter("createPDF"));
            
            request.getParameter("commentaire");
            request.getParameter("description");
                    
            
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
