/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import controller.Stagiaire;
import controller.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import properties.PropertyLoader;

/**
 *
 * @author PC-Acta
 */
public class StagiaireController {
    public ArrayList<Stagiaire> getStagiaires(int idTuteur) throws IOException{
        try {
            Properties prop = PropertyLoader.load();

            Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"),prop.getProperty("logindatabase"),prop.getProperty("mdpdatabase"));
            Statement stmt = c.createStatement();
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM entreprise NATURAL JOIN stagiaire where id_tuteur = ?");
            pstmt.setInt(1, idTuteur);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Stagiaire> stagiaires = new ArrayList<>();
            
            while(rs.next()){
                Stagiaire stagiaire = new Stagiaire();
                stagiaire.setId(rs.getInt("id_stagiaire"));
                stagiaire.setNom(rs.getString("nom"));
                stagiaire.setPrenom(rs.getString("prenom"));
                stagiaire.setClasse(rs.getString("classe"));
                stagiaire.setCdc(rs.getBoolean("cdc"));
                stagiaire.setFiche(rs.getBoolean("fiche_visite"));
                stagiaire.setFiche_evaluation(rs.getBoolean("fiche_evaluation"));
                stagiaire.setSondage_web(rs.getBoolean("sondage_web"));
                stagiaire.setRapport_rendu(rs.getBoolean("rapport_rendu"));
                stagiaire.setSoutenance(rs.getBoolean("soutenance"));
                stagiaire.setVisite_planif(rs.getBoolean("visite_planification"));
                stagiaire.setVisite_faite(rs.getBoolean("visite_faite"));
                stagiaire.setDebut(rs.getDate("debut"));
                stagiaire.setFin(rs.getDate("fin"));
                stagiaire.setEntreprise(rs.getString("entreprise"));
                stagiaire.setMds(rs.getInt("id_tuteur"));
                stagiaire.setStage_adresse(rs.getString("stage_adresse"));
                stagiaire.setNote_tech(rs.getInt("note_tech"));
                stagiaire.setNote_com(rs.getInt("note_com"));
                stagiaire.setStage_adresse(rs.getString("description_mission"));
                stagiaire.setStage_adresse(rs.getString("stage_adresse"));
                stagiaires.add(stagiaire);
                
            }
            return stagiaires;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         return null;   
    }

    public Stagiaire getStagiaire(String id_stagiaire) throws IOException {
 try {
            int id_stag = Integer.parseInt(id_stagiaire);

            Properties prop = PropertyLoader.load();

            Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"),prop.getProperty("logindatabase"),prop.getProperty("mdpdatabase"));
            Statement stmt = c.createStatement();
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM entreprise NATURAL JOIN stagiaire where id_stagiaire = ?");
            pstmt.setInt(1, id_stag);
            ResultSet rs = pstmt.executeQuery();
            Stagiaire stagiaire = new Stagiaire();
            if(rs.next()){
                stagiaire.setId(rs.getInt("id_stagiaire"));
                stagiaire.setNom(rs.getString("nom"));
                stagiaire.setPrenom(rs.getString("prenom"));
                stagiaire.setClasse(rs.getString("classe"));
                stagiaire.setCdc(rs.getBoolean("cdc"));
                stagiaire.setFiche(rs.getBoolean("fiche_visite"));
                stagiaire.setFiche_evaluation(rs.getBoolean("fiche_evaluation"));
                stagiaire.setSondage_web(rs.getBoolean("sondage_web"));
                stagiaire.setRapport_rendu(rs.getBoolean("rapport_rendu"));
                stagiaire.setSoutenance(rs.getBoolean("soutenance"));
                stagiaire.setVisite_planif(rs.getBoolean("visite_planification"));
                stagiaire.setVisite_faite(rs.getBoolean("visite_faite"));
                stagiaire.setDebut(rs.getDate("debut"));
                stagiaire.setFin(rs.getDate("fin"));
                stagiaire.setEntreprise(rs.getString("entreprise"));
                stagiaire.setMds(rs.getInt("id_tuteur"));
                stagiaire.setStage_adresse(rs.getString("stage_adresse"));
                stagiaire.setNote_tech(rs.getInt("note_tech"));
                stagiaire.setNote_com(rs.getInt("note_com"));
                stagiaire.setDescription(rs.getString("description_mission"));
                stagiaire.setCommentaire(rs.getString("commentaire"));
                
                
            }
            return stagiaire;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         return null;      }
}
