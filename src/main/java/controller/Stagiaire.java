/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;

/**
 *
 * @author PC-Acta
 */
public class Stagiaire {
    private int id;
    private String nom;
    private String prenom;
    private String classe;
    private boolean cdc;
    private boolean fiche;
    private boolean visite;
    private boolean fiche_evaluation;
    private boolean sondage_web;
    private boolean rapport_rendu;
    private boolean soutenance;
    private boolean visite_planif;
    private boolean visite_faite;
    private Date debut;
    private Date fin;
    private String entreprise;
    private int mds;
    private String stage_adresse;
    private int note_tech;
    private int note_com;

    public Stagiaire(int id, int mds, String nom, String prenom, String classe, boolean cdc, boolean fiche, boolean visite, boolean fiche_evaluation, boolean sondage_web, boolean rapport_rendu, boolean soutenance, boolean visite_planif, boolean visite_faite, Date debut, Date fin, String entreprise, String stage_adresse, int note_tech, int note_com) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.cdc = cdc;
        this.fiche = fiche;
        this.visite = visite;
        this.fiche_evaluation = fiche_evaluation;
        this.sondage_web = sondage_web;
        this.rapport_rendu = rapport_rendu;
        this.soutenance = soutenance;
        this.visite_planif = visite_planif;
        this.visite_faite = visite_faite;
        this.debut = debut;
        this.fin = fin;
        this.entreprise = entreprise;
        this.mds = mds;
        this.stage_adresse = stage_adresse;
        this.note_tech = note_tech;
        this.note_com = note_com;
    }

    public void setMds(int mds) {
        this.mds = mds;
    }

    public boolean isRapport_rendu() {
        return rapport_rendu;
    }

    public int getMds() {
        return mds;
    }

    public void setRapport_rendu(boolean rapport_rendu) {
        this.rapport_rendu = rapport_rendu;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public void setFiche(boolean fiche) {
        this.fiche = fiche;
    }

    public void setVisite(boolean visite) {
        this.visite = visite;
    }

    public void setFiche_evaluation(boolean fiche_evaluation) {
        this.fiche_evaluation = fiche_evaluation;
    }

    public void setSondage_web(boolean sondage_web) {
        this.sondage_web = sondage_web;
    }

    public void setSoutenance(boolean soutenance) {
        this.soutenance = soutenance;
    }

    public void setVisite_planif(boolean visite_planif) {
        this.visite_planif = visite_planif;
    }

    public void setVisite_faite(boolean visite_faite) {
        this.visite_faite = visite_faite;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setStage_adresse(String stage_adresse) {
        this.stage_adresse = stage_adresse;
    }

    public void setNote_tech(int note_tech) {
        this.note_tech = note_tech;
    }

    public void setNote_com(int note_com) {
        this.note_com = note_com;
    }

    
    public Stagiaire(int id, String nom, String prenom, String classe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }
   public Stagiaire() {
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public boolean isCdc() {
        return cdc;
    }

    public boolean isFiche() {
        return fiche;
    }

    public boolean isVisite() {
        return visite;
    }

    public boolean isFiche_evaluation() {
        return fiche_evaluation;
    }

    public boolean isSondage_web() {
        return sondage_web;
    }

    public boolean isSoutenance() {
        return soutenance;
    }

    public boolean isVisite_planif() {
        return visite_planif;
    }

    public boolean isVisite_faite() {
        return visite_faite;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public String getStage_adresse() {
        return stage_adresse;
    }

    public int getNote_tech() {
        return note_tech;
    }

    public int getNote_com() {
        return note_com;
    }
    
    
}
