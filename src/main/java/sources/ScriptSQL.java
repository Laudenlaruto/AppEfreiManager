/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC-Acta
 */
public class ScriptSQL {


    public ScriptSQL() {
        
            try {
            Properties prop;
                try {
                    prop = properties.PropertyLoader.load();
                    Connection c = DriverManager.getConnection(prop.getProperty("databasedriver") + prop.getProperty("database"),prop.getProperty("logindatabase"),prop.getProperty("mdpdatabase"));
                    Statement stmt = c.createStatement();

stmt.executeUpdate("CREATE TABLE tuteur(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),nom VARCHAR(24),prenom VARCHAR(24),login VARCHAR(24),mdp VARCHAR(24))");                
stmt.executeUpdate("CREATE TABLE stagiaire(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nom VARCHAR(24),prenom VARCHAR(24),classe VARCHAR(5))");
stmt.executeUpdate("CREATE TABLE entreprise(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),id_stagiaire INTEGER,id_tuteur INTEGER,cdc BOOLEAN,fiche BOOLEAN,visite BOOLEAN,fiche_evaluation BOOLEAN,sondage_web BOOLEAN,rapport_rendu BOOLEAN,soutenance BOOLEAN,visite_planification BOOLEAN,visite_faite BOOLEAN,debut DATE,fin DATE,entreprise VARCHAR(64),stage_adresse VARCHAR(64), note_tech INTEGER,  note_com INTEGER)");
stmt.executeUpdate("ALTER TABLE tuteur ADD PRIMARY KEY (id)");
stmt.executeUpdate("ALTER TABLE stagiaire ADD PRIMARY KEY (id)");
stmt.executeUpdate("ALTER TABLE entreprise ADD PRIMARY KEY (id)");
stmt.executeUpdate("ALTER TABLE entreprise ADD FOREIGN KEY (id_tuteur) REFERENCES tuteur(id)");
stmt.executeUpdate("ALTER TABLE entreprise ADD FOREIGN KEY (id_stagiaire) REFERENCES stagiaire(id)");

stmt.executeUpdate("INSERT INTO tuteur (nom,prenom,login,mdp) values('Augustin','Jaques','azerty','azerty')");
stmt.executeUpdate("INSERT INTO tuteur (nom,prenom,login,mdp) values('Lahlou','Karim','azerty','azerty')");
stmt.executeUpdate("INSERT INTO tuteur (nom,prenom,login,mdp) values('Khoury','Christian','azerty','azerty')");
stmt.executeUpdate("INSERT INTO tuteur (nom,prenom,login,mdp) values('TestNom','TestPrenom','t','t')");

stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Marquet','Cyril','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Sanvoisin','Benjamin','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Mercier','Nicolas','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Bouchara','Laura','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Lachambre','Damien','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Boukari','Bryan','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Alermoz','Florian','M1')");
stmt.executeUpdate("INSERT INTO stagiaire(nom,prenom,classe) values('Michau','Victor','M1')");

stmt.executeUpdate("INSERT INTO entreprise(id_stagiaire,id_tuteur,cdc,fiche,visite,fiche_evaluation,sondage_web,rapport_rendu,soutenance,visite_planification,visite_faite,debut,fin,entreprise,stage_adresse,note_tech,note_com) values(1,4,false,false,false,false,false,false,false,false,false,'2017-09-01','2018-08-31','EDF','62 rue du tonnerre',12,15)");
stmt.executeUpdate("INSERT INTO entreprise(id_stagiaire,id_tuteur,cdc,fiche,visite,fiche_evaluation,sondage_web,rapport_rendu,soutenance,visite_planification,visite_faite,debut,fin,entreprise,stage_adresse,note_tech,note_com) values(2,4,false,false,false,false,false,false,false,false,false,'2017-09-01','2018-08-31','EDF','62 rue du tonnerre',12,15)");
stmt.executeUpdate("INSERT INTO entreprise(id_stagiaire,id_tuteur,cdc,fiche,visite,fiche_evaluation,sondage_web,rapport_rendu,soutenance,visite_planification,visite_faite,debut,fin,entreprise,stage_adresse,note_tech,note_com) values(3,4,false,false,false,false,false,false,false,false,false,'2017-09-01','2018-08-31','EDF','62 rue du tonnerre',12,15)");

                } catch (IOException ex) {
                    Logger.getLogger(ScriptSQL.class.getName()).log(Level.SEVERE, null, ex);
                }

            
            } catch (SQLException ex) {
                    Logger.getLogger(ScriptSQL.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
public static void main (String[] args){
    ScriptSQL sql= new ScriptSQL();
}

            

}
