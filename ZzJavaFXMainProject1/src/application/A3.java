package application;

import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class A3 {

    @FXML
    private ImageView bg3;

    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_select;

    @FXML
    private CheckBox chk1;

    @FXML
    private CheckBox chk2;

    @FXML
    private CheckBox chk3;

    @FXML
    private CheckBox chk4;

    @FXML
    private ListView<Items> lst;

    @FXML
    private TextArea txt_item_list;

    @FXML
    private TextField txt_select;


    
   ObservableList<Items>all=FXCollections.observableArrayList();
   FilteredList<Items>filtered;
   StringBuilder build=new StringBuilder();
    
	
    public void initialize() {
//Items
    	all.addAll(
				new Items("Divine Rapier", "Damage", "+330 damage", 6300),
				new Items("Assault Cuirass","Survivability","+10 armor", 4800),
				new Items("Blink dagger","Utility","Teleports 1200 units", 2250),
				new Items("Tango","Consumable","Heals 115hp over 16s", 90),
				new Items("BattleFury","Damage","+65 damage", 4850),
				new Items("Vanguard","Survivability","+250 base hp", 2000),
				new Items("Black King Bar","Survivability","Spell immunity for 8s", 4050)
				);
    	lst.setItems(all);
//
    	
    	
    	 
//Select button
    	 btn_select.setOnAction(event->{
    		 Items selected=lst.getSelectionModel().getSelectedItem();
    		 if(selected!=null) {
    			 build.append("► ").append(selected.getName()).append(": ").append(selected.getDesc()).append("\n");
    			 txt_item_list.setText(build.toString());
    		 }
    	 });
//filters
    	 ChangeListener<Boolean>filter=(obs,oldVal,newVal)->applyFilters();
    	 chk1.selectedProperty().addListener(filter);
    	 chk2.selectedProperty().addListener(filter);
    	 chk3.selectedProperty().addListener(filter);
    	 chk4.selectedProperty().addListener(filter);
//
    	 
//Search
    	 txt_select.textProperty().addListener((obs,oldVal,newVal)->applyFilters());
//
    	 
    	 
//Exit
    	 btn_exit.setOnAction(event->{
         	Stage stage=(Stage)btn_exit.getScene().getWindow();
         	stage.close();
         });
//   	 
    }
    
    
//checkbox not selected
    private boolean ckbSelected() {
    	return chk1.isSelected() || chk2.isSelected() || chk3.isSelected() || chk4.isSelected();
    }
//

    
//Filters
    private static final int MAX_ITEMS = 6;

    private void applyFilters() {
        ObservableList<Items> filtered = FXCollections.observableArrayList();
        String search = txt_select.getText().toLowerCase();
        boolean anyCheckboxSelected = ckbSelected();
        
        for (Items item : all) {
            if (filtered.size() >= MAX_ITEMS) break;
            
            boolean typeMatch = 
                (chk1.isSelected() && item.getType().equals("Damage")) ||
                (chk2.isSelected() && item.getType().equals("Survivability")) ||
                (chk3.isSelected() && item.getType().equals("Utility")) ||
                (chk4.isSelected() && item.getType().equals("Consumable"));
            
            boolean nameMatch = item.getName().toLowerCase().contains(search);
            
            if (nameMatch && (typeMatch || !anyCheckboxSelected)) {
                filtered.add(item);
            }
        }
        
        lst.setItems(filtered.isEmpty() 
            ? all.stream().limit(MAX_ITEMS).collect(Collectors.toCollection(FXCollections::observableArrayList)) 
            : filtered);
    }
//
}

