/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.GUI;

import RendezVous.GUI.GUIMedecin;
import RendezVous.GUI.GUIRendezVous;
import User.Entities.Personne;
import User.Services.ServicePersonne;
import com.codename1.components.*;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import util.WebService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author Hamzaoui
 */
public class GUIPersonne extends SideMenuBaseForm {
    public GUIPersonne(Resources res) {

        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        Personne personne=WebService.getConnectedUser();
if (WebService.getConnectedUser().getProfessionnel().equals("Medecin")) {
    tb.addMaterialCommandToSideMenu("RendezVous", FontImage.MATERIAL_WEB, e -> {
        GUIRendezVous guiRendezVous = new GUIRendezVous();
        guiRendezVous.getForm().show();
    });
}else {
    tb.addMaterialCommandToSideMenu("Medecin", FontImage.MATERIAL_WEB, e -> {
        GUIMedecin guiMedecin = new GUIMedecin();
        guiMedecin.getForm().show();
    });
}
        tb.addMaterialCommandToSideMenu("Produit", FontImage.MATERIAL_PHOTO, e -> {});
        tb.addMaterialCommandToSideMenu("Evenement", FontImage.MATERIAL_PEOPLE, e -> {});
        tb.addMaterialCommandToSideMenu("Exercices", FontImage.MATERIAL_ADD_TO_PHOTOS, e -> {});
        tb.addMaterialCommandToSideMenu("Loisirs", FontImage.MATERIAL_WEB, e -> {});
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOCK, e -> {
            Personne personne1=new Personne();
            WebService.setPer(personne1);
            new Login(res).show();
        });
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> tb.openSideMenu());

        tb.setTitleCentered(false);

        EncodedImage enc;
        Image profilePic = null;
        try {
            enc = EncodedImage.create("/user-picture.jpg");
             profilePic = URLImage.createToStorage(enc,personne.getPhoto(),"http://localhost/Kidz/web/uploads/"+personne.getPhoto(),URLImage.RESIZE_SCALE);

        } catch (IOException e) {

        }

        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());


        Container remainingTasks = BoxLayout.encloseY(
                new Label("Change photo", "CenterTitle")

        );
       

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label(personne.getUsername(), "Title"),
                                new Label(personne.getProfessionnel(), "SubTitle")
                        )
                ).add(BorderLayout.WEST, profilePicLabel),
                GridLayout.encloseIn(1, remainingTasks)
        );

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, RIGHT, BOTTOM));

        fab.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                PhotoProfile photoProfile=new PhotoProfile();
                photoProfile.getForm().show();
            }
        });

        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_REMOVE_RED_EYE, "Label", 3);

        addButtonBottom(arrowDown, "Prenom: "+personne.getPrenom(), 0xd997f1, true);
        addButtonBottom(arrowDown, "Nom: "+personne.getNom(), 0x5ae29d, true);
        addButtonBottom(arrowDown, "Adresse: "+personne.getAdresse(), 0xffc06f, true);
        addButtonBottom(arrowDown, "Email: "+personne.getEmail(), 0x4dc2ff, true);
        addButtonBottom(arrowDown, "Telephone: "+personne.getTel()+"", 0xd997f1, true);
        addButtonBottom(arrowDown, "Sexe: "+personne.getSexe(), 0x5ae29d, true);
        addButtonBottom(arrowDown, "Naissance: "+personne.getD_naiss()+"", 0xffc06f, true);

    }

    private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }


    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
}
