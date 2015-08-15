/**
 * 
 */
package ch.makery.address.view;



import ch.makery.address.MainApp;
import ch.makery.address.model.Food;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

/**
 * @author Ipshita
 *
 */
public class FoodOverviewController {

	@FXML
	private TableView<Food> foodTable;
	@FXML
	private TableColumn<Food, Integer > itemCodeColumn;
	@FXML
	private TableColumn<Food, String> foodNameColumn;
	
	@FXML
	private Label itemCodeLabel;
	@FXML
	private Label foodNameLabel;
	@FXML
	private Label sugarLevelLabel;
	@FXML
	private Label calorieLabel;
	
	private MainApp mainApp;
	
	
	/**
	 * 
	 */
	public FoodOverviewController() {
		// TODO Auto-generated constructor stub
	}

	@FXML 
	private void initialize() {
		itemCodeColumn.setCellValueFactory(cellData -> cellData.getValue().itemCodeProperty().asObject());
		foodNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
		
		showFoodDetails(null);
		
		foodTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showFoodDetails(newValue));
	}

	/**
	 * @return the mainApp
	 */
	public MainApp getMainApp() {
		return mainApp;
	}

	/**
	 * @param mainApp the mainApp to set
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		foodTable.setItems(mainApp.getFoodList());
	}
	
	private void showFoodDetails(Food food){
		if(food != null){
			itemCodeLabel.setText(String.valueOf(food.getItemCode()));
			foodNameLabel.setText(food.getProductName().toString());
			sugarLevelLabel.setText(food.getSugarContent().toString());
			calorieLabel.setText(String.valueOf(food.getTotalCalories()));
			
		}
		else{
			itemCodeLabel.setText("");
			foodNameLabel.setText("");
			sugarLevelLabel.setText("");
			calorieLabel.setText("");
			
		}
		
	}
	
	@FXML
	private void handleDeleteFood() {
		int selectedIndex = foodTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			foodTable.getItems().remove(selectedIndex);
			
		} else {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Food Selected");
	        alert.setContentText("Please select a food in the table.");

	        alert.showAndWait();
		}
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewFood() {
	    Food tempFood = new Food();
	    boolean okClicked = mainApp.showPersonEditDialog(tempFood);
	    if (okClicked) {
	        mainApp.getFoodList().add(tempFood);
	    }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditFood() {
	    Food selectedFood = foodTable.getSelectionModel().getSelectedItem();
	    if (selectedFood != null) {
	        boolean okClicked = mainApp.showPersonEditDialog(selectedFood);
	        if (okClicked) {
	            showFoodDetails(selectedFood);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
	    }
	}
}
