package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class A {

    @FXML
    private ImageView bg;

    @FXML
    private Button btn_heroes;

    @FXML
    private Button btn_item_builds;

    @FXML
    private Rectangle grd1;

    @FXML
    private Rectangle grd2;

    @FXML
    private ImageView hero_img;

    @FXML
    private ImageView item_img;
    
    @FXML
    private Tab tab_prof;

    @FXML
    private Tab profileTab;

    @FXML
    private TextField txt_login;

    @FXML
    private PasswordField txt_psw;
    
    @FXML
    private Button btn_login;
    
    @FXML
    private Button btn;
    
    @FXML
    private ImageView img;
    
    @FXML private 
    VBox loginForm;
    
    @FXML private 
    VBox profileContent;
    
    @FXML private 
    Label loginError;
    
    
    public void initialize() {
    	profileContent.setVisible(false);
    	
    	btn_heroes.setOnAction(event -> {
    	    try {
    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("window.fxml"));
    	        Parent root = loader.load();
    	        Stage newStage = new Stage();
    	        newStage.initOwner(btn_heroes.getScene().getWindow()); 
    	        newStage.setScene(new Scene(root));
    	        newStage.setTitle("Dota 2 toolkit: Heroes");
    	        newStage.show();
    	    } catch(Exception e) {
    	        e.printStackTrace();
    	    }
    	});
    	
    	btn_item_builds.setOnAction(event->{
    		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("window2.fxml"));
			Parent root1;
			try {
				root1=loader1.load();
				Scene scene1=new Scene(root1);
				Stage newstage1=new Stage();
				newstage1.setScene(scene1);
				Image image=new Image("application/75581.jpg");
				newstage1.getIcons().add(image);
				newstage1.setTitle("Dota 2 toolkit: Item Build");
				newstage1.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
    	});
    	
    	btn_login.setOnAction(event -> {
    	    if(txt_login.getText().equals("admin") && txt_psw.getText().equals("admin")) {
    	        try {
    	            
    	            // Open the profile window
    	            FXMLLoader loader = new FXMLLoader(getClass().getResource("window3.fxml"));
    	            Parent root = loader.load();
    	            
    	            Stage profileStage = new Stage();
    	            profileStage.setScene(new Scene(root));
    	            profileStage.setTitle("Dota 2 Toolkit: Profile");
    	            
    	            // Set the same icon as main window
    	            Image image = new Image("application/75581.jpg");
    	            profileStage.getIcons().add(image);
    	            
    	            profileStage.show();
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	            // Show error if window fails to open
    	            loginError.setText("Failed to open profile");
    	            loginError.setVisible(true);
    	        }
    	    } else {
    	        loginError.setText("Invalid credentials");
    	        loginError.setVisible(true);
    	    }
    	});

    	
    }
    

}
