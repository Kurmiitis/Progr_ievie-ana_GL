package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class A4 {

    @FXML
    private Button btn;

    @FXML
    private Button edit_prof;

    @FXML
    private Label fav_hero;

    @FXML
    private Label matches;

    @FXML
    private Label mmr;

    @FXML
    private ImageView pfp;

    @FXML
    private Label rank;

    @FXML
    private Label score;

    @FXML
    private Label server;

    @FXML
    private Label username;

    @FXML
    private Label win_rate;

    public String getUsername() { 
    	return username.getText(); }
    
    public String getRank() { 
    	return rank.getText(); }
    
    public String getMmr() { 
    	return mmr.getText(); }
    
    public String getServer() {
    	return server.getText(); }
    
    
    public void updateProfile(String newUsername, String newRank, String newMmr, String newServer) {
        username.setText(newUsername);
        rank.setText(newRank);
        mmr.setText(newMmr);
        server.setText(newServer);
        }
    
    public void initialize(){
    	
    	//player info defaults
    	username.setText("Admin");
    	matches.setText("1341");
    	win_rate.setText("54%");
    	fav_hero.setText("Juggernaut");
    	score.setText("11000");
    	
    	rank.setText("Ancient I");
    	mmr.setText("4120");
    	server.setText("Europe");

    	
    	btn.setOnAction(event->{
        	Stage stage=(Stage)btn.getScene().getWindow();
        	stage.close();
        });
    	
    	edit_prof.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("window5.fxml"));
                Parent root = loader.load();
                
                A5 editController = loader.getController();
                editController.setProfileController(this);
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Dota 2 Tooltip: Edit Profile");
	            Image image = new Image("application/75581.jpg");
	            stage.getIcons().add(image);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    	
        }
    	}
          
            	




