/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Entities;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author WiKi
 */
public class Personne extends ArrayList<Personne> {
    public int id ;
    public String nom;
    public String cin;
    public String prenom;
    public String adresse;
    public String username;
    public String email;
    public String password ;
    public String password2 ;
    public String professionnel;
    public String sexe;
    public String tel;
    public String d_naiss;
    public String photo;
    
    
    public Personne() {
    }

    public Personne( String nom, String prenom, String adresse, String username, String email, String professionnel, String sexe, String tel,String cin, String d_naiss) {
         this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.username = username;
        this.email = email;
        this.professionnel = professionnel;
        this.sexe = sexe;
        this.tel = tel;
        this.d_naiss = d_naiss;
    }


   public Personne(int id, String nom, String prenom,String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.photo=photo;
            
    }

    public Personne(int id,String nom, String prenom, String adresse, String username, String email, String professionnel, String sexe, String tel,String cin, String d_naiss) {
        this.id = id;
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.adresse = adresse;
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.professionnel = professionnel;
        this.sexe = sexe;
        this.tel = tel;
        this.d_naiss = d_naiss;
    }
   
   

    public String getAdresse() {
        return adresse;
    }

    public String getCin() {
        return cin;
    }

    public String getD_naiss() {
        return d_naiss;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getProfessionnel() {
        return professionnel;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTel() {
        return tel;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setD_naiss(String d_naiss) {
        this.d_naiss = d_naiss;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setProfessionnel(String professionnel) {
        this.professionnel = professionnel;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + getId() + ", nom=" + nom + ", cin=" + cin + ", prenom=" + prenom + ", adresse=" + getAdresse() + ", username=" + username + ", email=" + email + ", password=" + password + ", password2=" + password2 + ", professionnel=" + professionnel + ", sexe=" + sexe + ", tel=" + tel + ", d_naiss=" + d_naiss + ", photo=" + photo + '}';
    }

    
    
   
     

}
