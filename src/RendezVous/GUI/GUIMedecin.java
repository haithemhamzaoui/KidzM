package RendezVous.GUI;

import RendezVous.Entities.Rendez_vous;
import RendezVous.Services.ServiceRendezVous;
import User.Entities.Personne;
import User.GUI.GUIPersonne;
import User.GUI.SideMenuBaseForm;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import util.WebService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class GUIMedecin extends SideMenuBaseForm {

    Form f;
    SpanLabel lb;
    EncodedImage encoded;




    public GUIMedecin() {

        f = new Form("Nos Medecin");
        Toolbar tb = this.f.getToolbar();

        tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
            GUIPersonne grv = new GUIPersonne(Resources.getGlobalResources());
            grv.show();
        });

        ServiceRendezVous serviceRendezVous = new ServiceRendezVous();
        Map x= WebService.getResponse("rend/rv/rvmed");

        ArrayList<Personne> listmed = serviceRendezVous.listmed(x);

        for (Personne p : listmed) {
            Container bouhom1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container oneLine = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C6 = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW));
            try {
                ScaleImageLabel sep = new ScaleImageLabel(Image.createImage("/Separator.png"));
                oneLine.add(sep);
            } catch (IOException ex) {
//Logger.getLogger(CoVoiturageView.class.getName()).log(Level.SEVERE, null, ex);
            }
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


            C4.add(nom);
            C4.add(tel);
            C4.add(email);
//C1.add(btnshow);

            C5.add(lnom);
            C5.add(ltel);
            C5.add(lemail);


             C6.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            GUIMedecinShow grv = new GUIMedecinShow(p);
            grv.getForm().show();
            }
            });
            bouhom1.add(C6);
            bouhom1.add(oneLine);

            C6.add(C5);
            C6.add(C4);

            C4.setLeadComponent(nom);

            f.add(bouhom1);
        }

    }
    @Override
    protected void showOtherForm(Resources res) {

    }


    public Form getForm() {
        return this.f;
    }



}
