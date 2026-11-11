package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class A2 {

    // Filter controls
    @FXML 
    private RadioButton btn_melee;
    
    @FXML 
    private RadioButton btn_ranged;
    
    @FXML
    private ComboBox<String> cmb_type;
    
    @FXML 
    private TextField txt_search;
    
    // Table controls
    @FXML 
    private TableView<Heroes> tbl;
    
    @FXML
    private TableColumn<Heroes, String> clm_name;
    
    @FXML 
    private TableColumn<Heroes, String> clm_tpye;
    
    @FXML
    private TableColumn<Heroes, String> clm_atk_type;
    
    @FXML 
    private TableColumn<Heroes, Integer> clm_dmg;
    
    // Add hero controls
    @FXML 
    private RadioButton btn_add_melee;
    
    @FXML 
    private RadioButton btn_add_ranged;
    
    @FXML 
    private ComboBox<String> cmb_add_type;
    
    @FXML
    private TextField txt_add_name;

    @FXML
    private TextField txt_enter_basedmg;
    
    @FXML 
    private Button btn_add;
    //
    @FXML
    private ImageView bg2;
    @FXML
    private Button btn_exit;
    
    //collections
    private ObservableList<Heroes> heroes = FXCollections.observableArrayList();
    private FilteredList<Heroes> filtered;
    private ObservableList<String> type = FXCollections.observableArrayList("Strength", "Agility", "Intelligence", "Universal");

    public void data() {
        heroes.setAll(
            new Heroes("Axe", "Strength", "Melee", 63),
            new Heroes("Drow Ranger", "Agility", "Ranged", 58),
            new Heroes("Void Spirit", "Universal", "Melee", 60),
            new Heroes("Dark Seer", "Intelligence", "Melee", 54)
        );//MAKE THIS FROM SQL LSIT
    }

    public void initialize() {
    	
        clm_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        clm_tpye.setCellValueFactory(new PropertyValueFactory<>("type"));
        clm_atk_type.setCellValueFactory(new PropertyValueFactory<>("atk_type"));
        clm_dmg.setCellValueFactory(new PropertyValueFactory<>("base_dmg"));

        data();

        //filtered list
        filtered = new FilteredList<>(heroes, p -> true);
        tbl.setItems(filtered);

        //combo boxes
        cmb_type.setItems(type);
        cmb_add_type.setItems(type);

        //filter listeners
        txt_search.textProperty().addListener((obs, oldVal, newVal) -> applyFilters());
        cmb_type.valueProperty().addListener((obs, oldVal, newVal) -> applyFilters());
        btn_melee.selectedProperty().addListener((obs, oldVal, newVal) -> applyFilters());
        btn_ranged.selectedProperty().addListener((obs, oldVal, newVal) -> applyFilters());


        btn_add.setOnAction(event -> addHero());
        
        
//exit
        btn_exit.setOnAction(event->{
        	Stage stage=(Stage)btn_exit.getScene().getWindow();
        	stage.close();
        });
    }
//

    
    
    private void applyFilters() {
        filtered.setPredicate(hero -> {
        	
            // Filter by name
            String searchText = txt_search.getText();
            if (searchText != null && !searchText.isEmpty() && 
                !hero.getName().toLowerCase().contains(searchText.toLowerCase())) {
                return false;
            }

            // Filter by type
            String selectedType = cmb_type.getValue();
            if (selectedType != null && !hero.getType().equalsIgnoreCase(selectedType)) {
                return false;
            }

            // Filter by attack type
            if (btn_melee.isSelected() && !hero.getAtk_type().equalsIgnoreCase("Melee")) {
                return false;
            }
            if (btn_ranged.isSelected() && !hero.getAtk_type().equalsIgnoreCase("Ranged")) {
                return false;
            }
            return true;
        });
    }
    
//add hero
    private void addHero() {
        if (txt_add_name.getText().isEmpty() || 
            cmb_add_type.getSelectionModel().isEmpty() ||
            (!btn_add_melee.isSelected() && !btn_add_ranged.isSelected()) ||
            txt_enter_basedmg.getText().isEmpty()) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        try {
            Heroes newHero = new Heroes(
                txt_add_name.getText(),
                cmb_add_type.getValue(),
                btn_add_melee.isSelected() ? "Melee" : "Ranged",
                Integer.parseInt(txt_enter_basedmg.getText())
            );
            
            heroes.add(newHero);
            
            txt_add_name.clear();
            cmb_add_type.getSelectionModel().clearSelection();
            btn_add_melee.setSelected(false);
            btn_add_ranged.setSelected(false);
            txt_enter_basedmg.clear();
            
            showAlert("Success", "Hero added successfully!");
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for damage");
        }
        
    }
//

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
