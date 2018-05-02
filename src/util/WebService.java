/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import User.Entities.Personne;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

/**
 *
 * @author Justpro
 */
public class WebService {
    static Map h;
    static Personne per;
    public static Map<String, Object> getResponse(String url){
        url = "http://localhost/kidz/web/app_dev.php/"+url;
        ConnectionRequest r = new ConnectionRequest();
        r.setUrl(url);
        r.setPost(false);
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(dlg);
        r.addResponseListener((evt) -> {
            try {
                JSONParser p = new JSONParser();
                Reader targetReader = new InputStreamReader(new ByteArrayInputStream(r.getResponseData()));
                System.out.println(targetReader);
                h= p.parseJSON(targetReader);

            } catch (Exception ex) {


            }
 
        });
        r.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(r);

        if(r.getResponseCode() != 200 ) {
            Dialog.show("Erreur", "Rééssayer une autre fois", "OK", "Cancel");

        }

        return h; 
    }

    public static void setPer(Personne per) {

        WebService.per = per;
    }

    public static Personne getConnectedUser(){

        return per;
    }



}
