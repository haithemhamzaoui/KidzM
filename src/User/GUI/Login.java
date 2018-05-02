package User.GUI;

import User.Entities.Personne;
import User.Services.ServicePersonne;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import util.WebService;

import java.util.Map;

public class Login  extends Form{
    Form f;
    public Login(Resources theme){
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Mobile app ", "WelcomeWhite"),
                new Label("Kidz", "WelcomeBlue")
        );

        getTitleArea().setUIID("Container");

        Image profilePic = theme.getImage("user-picture.jpg");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());

        TextField login = new TextField("", "Login", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);

        Button loginButton = new Button("LOGIN");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {

            Toolbar.setGlobalToolbar(false);
            new WalkthruForm(theme).show();
            Toolbar.setGlobalToolbar(true);
            ServicePersonne servicePersonne = new ServicePersonne();
            String username=login.getText();
            String pass=password.getText();

            Map x = WebService.getResponse(username+"/"+pass);
            Personne personne = servicePersonne.getConnected(x);
            WebService.setPer(personne);
            System.out.println(personne);

            if ((personne.getId() != 0) || (personne.getUsername() != null)) {
                new GUIPersonne(theme).show();
            }
            else {
                 new Login(theme).show();

            }
        });


        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }


        Container by = BoxLayout.encloseY(
                welcome,
                profilePicLabel,
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton
        );
        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
    public Form getForm() {
        return this.f;
    }
}
