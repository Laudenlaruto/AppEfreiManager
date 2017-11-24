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
    private boolean soutenance;
    private boolean visite_planif;
    private boolean visite_faite;
    private Date debut;
    private Date fin;
    private String entreprise;
    private String stage_adresse;
    private int note_tech;
    private int note_com;

    public Stagiaire(int id, String nom, String prenom, String classe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }
   public Stagiaire() {
    }

    @Override
    public String toString() {
        return "Stagiaire{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", classe=" + classe + '}';
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
    
    
}
