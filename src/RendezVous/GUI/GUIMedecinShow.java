package RendezVous.GUI;

import RendezVous.Entities.Rendez_vous;
import User.Entities.Personne;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import javafx.scene.control.DatePicker;
import util.WebService;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class GUIMedecinShow extends Form {

    Form f;
    SpanLabel lb;
    EncodedImage encoded;



    public GUIMedecinShow(Personne p)  {

        f = new Form("");

        Toolbar tb = this.f.getToolbar();
        tb.addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e -> {
            GUIMedecin grv=new GUIMedecin();
            grv.getForm().show();
        });


        Container bouhom1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container oneLine = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C6 = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW));

        Label nom;
        Label tel;
        Label email;


        Label lnom;
        Label ltel;
        Label lemail;

        nom = new Label(p.getNom() + " "+p.getPrenom());
        tel = new Label(p.getTel() + "");
        email = new Label(p.getEmail());

        lnom = new Label("Nom :");
        ltel = new Label("Tel :");
        lemail = new Label("Email :");
        Picker date = new Picker() ;

        date.setType(Display.PICKER_TYPE_DATE);

        Picker time = new Picker() ;

        time.setType(Display.PICKER_TYPE_TIME);

        time.getAllStyles().setFgColor(0xFF000000);
        date.getAllStyles().setFgColor(0xFF000000);
        date.getAllStyles().setMargin(LEFT, 0);
        time.getAllStyles().setMargin(LEFT, 0);
        date.getPreferredW();
        time.getPreferredW();
        date.shouldTickerStart();
        TextArea maladie=new TextArea("",4,100,TextArea.TEXT_CURSOR);
        maladie.setHint("Maladie");

        Button pr = new Button("Prendre un rendez vous");
        pr.getPreferredW();
        pr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {


                if (date.getDate().compareTo(new Date())>0) {
                    Map x = WebService.getResponse("rend/rv/new?nom=" + p.getNom() +
                            "&prenom=" + p.getPrenom() + "&tel=" + p.getTel() + "&iduser=" + WebService.getConnectedUser().getId() +
                            "&idmed=" + p.getId() + "&date=" + date.getText() + "&time=" + time.getText() + "&maladie=" + maladie.getText());
                  GUIMedecin guiMedecin=new GUIMedecin();
                  guiMedecin.getForm().show();

                }
                else {
                    Dialog.show("Erreur", "Date invalide", "OK", "Cancel");

                }

            }
        });

        C4.add(nom);
        C4.add(tel);
        C4.add(email);
//C1.add(btnshow);

        C5.add(lnom);
        C5.add(ltel);
        C5.add(lemail);
        C7.add(date);
        C7.add(time);
        C7.add(maladie);
        C7.add(pr);
        bouhom1.add(oneLine);

        C6.add(C5);
        C6.add(C4);

        C6.setLeadComponent(nom);

        bouhom1.add(C6);
        f.add(bouhom1);
        f.add(C7);


     }





    public Form getForm() {
        return this.f;
    }



}
