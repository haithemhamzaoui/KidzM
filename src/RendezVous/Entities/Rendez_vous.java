/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RendezVous.Entities;

/**
 *
 * @author Ahmed
 */
public class Rendez_vous {

    private int id ;
    private int idUser;
    private int idMed ;
    private String date;
    private String heure;
    private String maladie;

    public Rendez_vous() {
    }

    public Rendez_vous(int id, int idUser, int idMed, String date, String heure, String maladie) {
        this.id = id;
        this.idUser = idUser;
        this.idMed = idMed;
        this.date = date;
        this.heure = heure;
        this.maladie = maladie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdMed() {
        return this.idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }


    @Override
    public String toString() {
        return "Rendez_vous{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idMed=" + idMed +
                ", date=" + date +
                ", heure=" + heure +
                ", maladie='" + maladie + '\'' +
                '}';
    }
}
