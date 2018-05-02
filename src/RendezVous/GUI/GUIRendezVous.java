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

public class GUIRendezVous extends SideMenuBaseForm {

    Form f;
    SpanLabel lb;
    EncodedImage encoded;




    public GUIRendezVous() {

        f = new Form("Mes RendezVous");
        Toolbar tb = this.f.getToolbar();

        tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
            GUIPersonne grv = new GUIPersonne(Resources.getGlobalResources());
            grv.show();
        });

        ServiceRendezVous serviceRendezVous = new ServiceRendezVous();
        Map x = WebService.getResponse("rend/rv/");

        ArrayList<Rendez_vous> listRendezVous = serviceRendezVous.listRendezVous(x);

        for (Rendez_vous rv : listRendezVous) {
            if (rv.getIdMed() == WebService.getConnectedUser().getId()) {
                Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Container oneLine = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW));
                try {
                    ScaleImageLabel sep = new ScaleImageLabel(Image.createImage("/Separator.png"));
                    oneLine.add(sep);
                } catch (IOException ex) {
                    //Logger.getLogger(CoVoiturageView.class.getName()).log(Level.SEVERE, null, ex);
                }
                Label date;
                Label heure;
                Label maladie;


                Label ldate;
                Label lheure;
                Label lmaladie;

                date = new Label(rv.getDate() + "");
                heure = new Label(rv.getHeure() + "");
                maladie = new Label(rv.getMaladie());

                ldate = new Label("Date :");
                lheure = new Label("Heure :");
                lmaladie = new Label("Maladie :");


                C1.add(date);
                C1.add(heure);
                C1.add(maladie);
                //C1.add(btnshow);

                C2.add(ldate);
                C2.add(lheure);
                C2.add(lmaladie);
                Button fall = new Button("Voir");


                C3.addPointerPressedListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        GUIRendezVousShow grv = new GUIRendezVousShow(rv);
                        grv.getForm().show();
                    }
                });
                bouhom.add(C3);
                bouhom.add(oneLine);

                C3.add(C2);
                C3.add(C1);

                C1.setLeadComponent(date);
                f.add(bouhom);

            }
        }
    }
    @Override
    protected void showOtherForm(Resources res) {

    }


    public Form getForm() {
        return this.f;
    }



}
