/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Services;


import User.Entities.Personne;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.social.Login;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hamzaoui
 */
public class ServicePersonne {
        static Map events;



    
    public  Personne getConnected(Map m) {
        Personne e = new Personne();
        //Map<String, Object> d = (Map<String, Object>) m.get("root");
        if (m != null) {
            e.setId(((Double) m.get("id")).intValue());
            e.setUsername(m.get("username").toString());
            e.setEmail(m.get("email").toString());
            e.setCin((String) m.get("cin"));
            e.setPrenom((String) m.get("prenom"));
            e.setPhoto((String) m.get("photo"));
            java.util.Date date = new java.util.Date(((Double) ((Map) m.get("dNaiss")).get("timestamp")).longValue() * 1000);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String time = dateFormat.format(date);

            e.setD_naiss(time);

            e.setAdresse((String) m.get("adresse"));
            e.setPhoto((String) m.get("photo"));
            e.setNom((String) m.get("nom"));
            e.setProfessionnel((String) m.get("professionnel"));
            e.setPassword((String) m.get("password"));
            e.setSexe((String) m.get("sexe"));
            e.setTel(String.valueOf(((Double) m.get("tel")).intValue()));
            System.out.println(String.valueOf(((Double) m.get("tel")).intValue()));
            return e;

        } else {
            new User.GUI.Login(Resources.getGlobalResources()).show();
        }

        return e;

    }

    
}
