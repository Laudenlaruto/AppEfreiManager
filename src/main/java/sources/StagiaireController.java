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
import proprietes.PropertyLoader;

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
                stagiaires.add(stagiaire);
                
            }
            return stagiaires;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         return null;   
    }
}
