/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import controller.Stagiaire;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ArrayList<Stagiaire> getStagiaires(int idTuteur) throws IOException {
        Properties prop = PropertyLoader.load();
        try (Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"), prop.getProperty("logindatabase"), prop.getProperty("mdpdatabase"))) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM entreprise NATURAL JOIN stagiaire where id_tuteur = ?");
            pstmt.setInt(1, idTuteur);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Stagiaire> stagiaires = new ArrayList<>();

            while (rs.next()) {
                Stagiaire stagiaire = new Stagiaire();
                stagiaire.setId(rs.getInt("id_stagiaire"));
                stagiaire.setNom(rs.getString("nom"));
                stagiaire.setPrenom(rs.getString("prenom"));
                stagiaire.setClasse(rs.getString("classe"));
                stagiaire.setCdc(rs.getBoolean("cdc"));
                stagiaire.setFiche_visite(rs.getBoolean("fiche_visite"));
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
        Properties prop = PropertyLoader.load();
        try (Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"), prop.getProperty("logindatabase"), prop.getProperty("mdpdatabase"))) {
            int id_stag = Integer.parseInt(id_stagiaire);

            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM entreprise NATURAL JOIN stagiaire where id_stagiaire = ?");
            pstmt.setInt(1, id_stag);
            ResultSet rs = pstmt.executeQuery();
            Stagiaire stagiaire = new Stagiaire();
            if (rs.next()) {
                stagiaire.setId(rs.getInt("id_stagiaire"));
                stagiaire.setNom(rs.getString("nom"));
                stagiaire.setPrenom(rs.getString("prenom"));
                stagiaire.setClasse(rs.getString("classe"));
                stagiaire.setCdc(rs.getBoolean("cdc"));
                stagiaire.setFiche_visite(rs.getBoolean("fiche_visite"));
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

        return null;
    }

    public void updateCommentaire(String com, String id_stagiaire) throws IOException {
        Properties prop = PropertyLoader.load();

        try (Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"), prop.getProperty("logindatabase"), prop.getProperty("mdpdatabase"))) {
            int id_stag = Integer.parseInt(id_stagiaire);
            PreparedStatement pstmt = c.prepareStatement("UPDATE entreprise SET commentaire = ? where id_stagiaire = ?");
            pstmt.setString(1, com);
            pstmt.setInt(2, id_stag);
            pstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDescription(String description, String id_stagiaire) throws IOException {
        Properties prop = PropertyLoader.load();

        try (Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"), prop.getProperty("logindatabase"), prop.getProperty("mdpdatabase"))) {

            int id_stag = Integer.parseInt(id_stagiaire);

            PreparedStatement pstmt = c.prepareStatement("UPDATE entreprise SET description_mission = ? where id_stagiaire = ?");
            pstmt.setString(1, description);
            pstmt.setInt(2, id_stag);
            pstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void updateStagiaire(Stagiaire stagiaire) throws IOException {
        Properties prop = PropertyLoader.load();

        try (Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"), prop.getProperty("logindatabase"), prop.getProperty("mdpdatabase"))) {

            PreparedStatement pstmt = c.prepareStatement("UPDATE entreprise SET "
                                                        + "cdc = ? ,"
                                                        + "fiche_visite = ? ,"
                                                        + "fiche_evaluation = ? ,"
                                                        + "sondage_web = ? ,"
                                                        + "rapport_rendu = ? ,"
                                                        + "soutenance = ? ,"
                                                        + "visite_planification = ? ,"
                                                        + "visite_faite = ? ,"
                                                        + "debut = ? ,"
                                                        + "fin = ? ,"
                                                        + "entreprise = ? ,"
                                                        + "stage_adresse = ? ,"
                                                        + "note_tech = ? ,"
                                                        + "note_com = ? "
                                                        + "WHERE id_stagiaire = ?");
            
            pstmt.setBoolean(1, stagiaire.isCdc());
            pstmt.setBoolean(2, stagiaire.isFiche_visite());
            pstmt.setBoolean(3, stagiaire.isFiche_evaluation());
            pstmt.setBoolean(4, stagiaire.isSondage_web());
            pstmt.setBoolean(5, stagiaire.isRapport_rendu());
            pstmt.setBoolean(6, stagiaire.isSoutenance());
            pstmt.setBoolean(7, stagiaire.isVisite_planif());
            pstmt.setBoolean(8, stagiaire.isVisite_faite());
            pstmt.setDate(9, stagiaire.getDebut());
            pstmt.setDate(10, stagiaire.getFin());
            pstmt.setString(11, stagiaire.getEntreprise());
            pstmt.setString(12, stagiaire.getStage_adresse());
            pstmt.setInt(13, stagiaire.getNote_tech());
            pstmt.setInt(14, stagiaire.getNote_com());         
            pstmt.setInt(15, stagiaire.getId());
            pstmt.executeUpdate();
                      
            PreparedStatement pstmt2 = c.prepareStatement("UPDATE stagiaire SET "
                                                        + "nom = ? ,"
                                                        + "classe = ? "
                                                        + "WHERE id = ?");
            
            pstmt2.setString(1, stagiaire.getNom());
            pstmt2.setString(2, stagiaire.getClasse());
            pstmt2.setInt(3, stagiaire.getId());
            pstmt2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
