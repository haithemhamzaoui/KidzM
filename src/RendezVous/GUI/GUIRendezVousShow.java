package RendezVous.GUI;

import RendezVous.Entities.Rendez_vous;
import RendezVous.Services.ServiceRendezVous;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import util.WebService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class GUIRendezVousShow extends Form {

    Form f;
    SpanLabel lb;
    EncodedImage encoded;



    public GUIRendezVousShow(Rendez_vous rv)  {

        f = new Form("");

        Toolbar tb = this.f.getToolbar();
        tb.addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e -> {
            GUIRendezVous grv=new GUIRendezVous();
            grv.getForm().show();
        });




        Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container oneLine = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW ));

        Label date;
        Label heure;
        Label maladie;


        Label ldate;
        Label lheure;
        Label lmaladie;
             date = new Label(rv.getDate()+"");
        heure = new Label(rv.getHeure()+"");
        maladie = new Label(rv.getMaladie());

        ldate = new Label("Date :");
        lheure = new Label("Heure :");
        lmaladie = new Label("Maladie :");

        System.out.println(rv.getMaladie());


        C1.add(date);
        C1.add(heure);
        C1.add(maladie);
        //C1.add(btnshow);

        C2.add(ldate);
        C2.add(lheure);
        C2.add(lmaladie);

        C3.add(C2);
        C3.add(C1);



        bouhom.add(C3);
            bouhom.add(oneLine);



        C1.setLeadComponent(date);
        f.add(bouhom);

     }





    public Form getForm() {
        return this.f;
    }



}
