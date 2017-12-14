/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proprietes;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.Stagiaire;
import controller.User;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC-Acta
 */
public class DocumentPDF {
            private static final Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);

    public DocumentPDF(Stagiaire stagiaire, User user)  {
        Document document = new Document();
        
        String NomEleve = stagiaire.getNom();
        String PrenomEleve = stagiaire.getPrenom();
        String Filiere = stagiaire.getClasse();
        String NomResp = user.getNom();
        String PrenomResp = user.getPrenom();
        String Titre = stagiaire.getDescription_mission();
        String Entreprise = stagiaire.getEntreprise();
        try{
            String space = "                                                                                                                                 ";   
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Test.pdf"));
            document.open();
            Image logoEfrei = Image.getInstance("efreilogo.jpg");
            document.add (logoEfrei);
            Font Content = new Font (FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font fontTitre = new Font(FontFamily.TIMES_ROMAN,15, Font.BOLD|Font.UNDERLINE); 
            Paragraph titre = new Paragraph("FICHE DE VISITE", fontTitre);
            titre.setAlignment(Element.ALIGN_CENTER);
            document.add(titre);
            Paragraph Right = new Paragraph("\n" +space +"Sur Site /Téléphonique \n"+space+"Année : M1/M2",Content);
            document.add(Right);
            Font FontLittleRight = new Font(FontFamily.TIMES_ROMAN, 8);
            Paragraph LittleRight = new Paragraph (space  +"                                                                  entourer la mention utile", FontLittleRight);
            LittleRight.setAlignment(Integer.BYTES);
            document.add(LittleRight);
            Paragraph RightNext = new Paragraph(space+"Filière : " + Filiere, Content);
            document.add(RightNext);
            Paragraph Left = new Paragraph ("Stagiaire (nom et prénom) :"+NomEleve+" "+PrenomEleve+" \n \n Entreprise (nom et adresse) : "+Entreprise+"\n \n Responsable du stage (nom et prénom) : "+NomResp+" " +PrenomResp + " \n \n Titre du stage : "+Titre+" \n\nCahier des charges du stage fourni : OUI/NON \n\n", Content);
            document.add(Left);
            //table part
            Paragraph paraTable = new Paragraph();
            float[] columnWidths = {15f, 1f, 1f, 1f,1f,1f};
            PdfPTable table = new PdfPTable(columnWidths);
            table.addCell("Comportement Général");
            table.addCell(" A");
            table.addCell(" B");
            table.addCell(" C");
            table.addCell(" D");
            table.addCell(" E");
            table.addCell("Intégration au sein de l'entreprise, comportement\n\nMotivation et Intérêt pour les missions condiées\n\nPrise d'initiative, créativité\n\nSens des responsabilités\n\nRigueur, professionnalisme");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell("Compétences techniques");
            table.addCell(" A");
            table.addCell(" B");
            table.addCell(" C");
            table.addCell(" D");
            table.addCell(" E");
            table.addCell("Acquisition du contexte\n\nMaitrise des technologies\n\nCapacité à s'adapter à de nouvelles techniques ou technologies\n\nCapacité d'analyse d'une situation ou d'une problématique\n\nCapacité de proposition de solutions");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell("Gestion de projet");
            table.addCell(" A");
            table.addCell(" B");
            table.addCell(" C");
            table.addCell(" D");
            table.addCell(" E");
            table.addCell("Organisation du travail\n\nAutonomie\n\nCompte rendu régulier au Maitre de stage\n\nPrise de parole en réunion\n\nCommunication écrite");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            paraTable.add(table);
            document.add(paraTable);
            document.add(new Paragraph ("Légende : A (excellent), B (satisfaisant), C (en cours d’acquisition), D (Légende : A (excellent), B (satisfaisant), C (en cours d’acquisition), D (non acquis), E (pose problème)\n \n", Content));
            document.add(new Paragraph ("Bilan des missions", fontTitre));
            document.add(new Paragraph ("\n\n\n\n"));
            document.add(new Paragraph ("Points positifs", fontTitre));
            document.add(new Paragraph ("\n\n\n\n"));
            document.add(new Paragraph ("Axe de progrès", fontTitre));
            document.add(new Paragraph ("\n\n\n\n"));
            document.add(new Paragraph ("Voix de l'entreprise (vis-à-vis de l'école)", fontTitre));
            document.add(new Paragraph ("\n\n\n\n\n\n\n\n"));
            document.add(new Paragraph ("Visite effectuée par : \nLe", Content));
            Paragraph duree = new Paragraph("durée de la visite :           \n", Content);
            duree.setAlignment(Element.ALIGN_RIGHT);
            document.add(duree);
            document.add(new Paragraph ("Signature :", Content));
            
            
            document.close();
            writer.close();
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(DocumentPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                    Logger.getLogger(DocumentPDF.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }
    
    public static void main(String[] args){
        DocumentPDF pdf = new DocumentPDF(new Stagiaire(), new User());
    }
}

