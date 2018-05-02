package User.GUI;

import RendezVous.GUI.GUIRendezVous;
import User.Entities.Personne;
import User.Services.ServicePersonne;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.File;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import util.WebService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class PhotoProfile {
    Form f;
    public PhotoProfile(){

         f = new Form("Camera", new BorderLayout());
        ImageViewer l = new ImageViewer();

        f.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_CAMERA_ALT, 4, (ev) -> {
            String path = Capture.capturePhoto();
            if(path == null) {
                showToast("User canceled Camera");
                return;
            }
            setImage(path, l);
              String saving= path.substring(40,path.length());
              Personne p = WebService.getConnectedUser();
              p.setPhoto(saving);
              WebService.setPer(p);
            File source = new File(path);
            String ap= path.substring(0,40);
            File destination = new File(ap+"../../../../../wamp/www/Kidz/web/uploads/"+p.getPhoto());
            destination.getAbsoluteFile();
            source.renameTo(destination);
            try {
                OutputStream save = Storage.getInstance().createOutputStream("C:/wamp/www/Kidz/web/uploads/"+path);
                System.out.println(save);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Map x = WebService.getResponse(p.getId()+"/"+p.getUsername()+"/"+p.getPhoto());
            WebService.setPer(p);
              System.out.println(WebService.getConnectedUser());

        });

        f.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_PHOTO, 4, (ev) -> {
            Display.getInstance().openGallery(e -> {
                if(e == null || e.getSource() == null) {
                    showToast("User canceled Gallery");
                    return;
                }
                String filePath = (String)e.getSource();
                setImage(filePath, l);
            }, Display.GALLERY_IMAGE);
        });

        f.add(BorderLayout.CENTER, l);
        Toolbar tb = this.f.getToolbar();
        tb.addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e -> {
            GUIPersonne grv=new GUIPersonne(Resources.getGlobalResources());
            grv.show();
        });

        f.show();
    }

    private void showToast(String text) {
        Image errorImage = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentStyle("Title"), 4);
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(text);
        status.setIcon(errorImage);
        status.setExpires(2000);
        status.show();
    }

    private void setImage(String filePath, ImageViewer iv) {
        try {
            Image i1 = Image.createImage(filePath);
            iv.setImage(i1);
            iv.getParent().revalidate();
        } catch (Exception ex) {
            Log.e(ex);
            Dialog.show("Error", "Error during image loading: " + ex, "OK", null);
        }
    }

    public Form getForm() {
        return f;
    }

}
