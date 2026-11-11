package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class A5 {
    @FXML private TextField edit_rank;
    @FXML private TextField edit_username;
    @FXML private TextField edit_mmr;
    @FXML private TextField edit_server;
    @FXML private Button btn_save;
    @FXML
    private ImageView img;
    
    private A4 profileController; 
    
    public void setProfileController(A4 controller) {
        this.profileController = controller;
        edit_username.setText(profileController.getUsername());
        edit_rank.setText(profileController.getRank());
        edit_mmr.setText(profileController.getMmr());
        edit_server.setText(profileController.getServer());
    }
    
    @FXML
    private void handleSave() {
        profileController.updateProfile(
            edit_username.getText(),
            edit_rank.getText(),
            edit_mmr.getText(),
            edit_server.getText()
        );
        
        Stage stage = (Stage) btn_save.getScene().getWindow();
        stage.close();
    }
}