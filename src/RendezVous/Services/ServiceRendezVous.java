package RendezVous.Services;

import RendezVous.Entities.Rendez_vous;
import User.Entities.Personne;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

public class ServiceRendezVous {

    static Map events;

    public  ArrayList<Rendez_vous> listRendezVous(Map m){
        ArrayList<Rendez_vous> listrendezvous = new ArrayList<>();
        ArrayList d = (ArrayList) m.get("root");

        Map f =  (Map) d.get(0);
        for(int i = 0; i<d.size();i++){
             f =  (Map) d.get(i);
            Rendez_vous e = new Rendez_vous();
            java.util.Date date1=new Date(((Double)((Map)f.get("date")).get("timestamp")).longValue()*1000);
            java.util.Date time1=new Date(((Double)((Map)f.get("time")).get("timestamp")).longValue()*1000);

            SimpleDateFormat dateFormat1 = new SimpleDateFormat(" dd/MM/yyyy");
            String date = dateFormat1.format(date1);

            SimpleDateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss");
            String time = dateFormat.format(time1);
            e.setDate(date);
            e.setHeure(time);
            e.setMaladie((String)f.get("maladie"));
            e.setIdMed(((Double) f.get("idmed")).intValue());
            listrendezvous.add(e);
        }
        return listrendezvous;

    }

    public ArrayList<Personne> listmed(Map f){
        ArrayList<Personne> listmed = new ArrayList<>();
        ArrayList d = (ArrayList) f.get("root");

        Map m =  (Map) d.get(0);
        for(int i = 0; i<d.size();i++){
            m =  (Map) d.get(i);
            Personne e=new Personne();
            e.setId(((Double) m.get("id")).intValue());
            e.setUsername(m.get("username").toString());
            e.setEmail(m.get("email").toString());
            e.setCin((String) m.get("cin"));
            e.setPrenom((String) m.get("prenom"));
            e.setPhoto((String) m.get("photo"));

            e.setAdresse((String) m.get("adresse"));
            e.setPhoto((String) m.get("photo"));
            e.setNom((String) m.get("nom"));
            e.setProfessionnel((String) m.get("professionnel"));
            e.setPassword((String) m.get("password"));
            e.setSexe((String) m.get("sexe"));
            e.setTel(String.valueOf(((Double) m.get("tel")).intValue()));
            listmed.add(e);
        }
        return listmed;

    }

}
