/**
 * 
 */
package ch.makery.address.view;

import ch.makery.address.model.Food;
import ch.makery.address.model.SugarLevel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Ipshita
 *
 */
public class FoodEditDialogController {
	
	
	@FXML
	private TextField productNameField;
	
	@FXML
	private TextField sugarLevelField;
	
	@FXML
	private TextField calorieField;
	
	private Stage dialogStage;
	private Food food;

	private boolean okClicked = false;
	
	
	@FXML
	private void initialize(){
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setFood(Food food) {
		this.food = food;
		if(null != food ){
		productNameField.setText(food.getProductName().toString());
		sugarLevelField.setText(food.getSugarContent().toString());
		calorieField.setText(String.valueOf(food.getTotalCalories()));
		}
		
	}
	
	
	/**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            food.setProductName(productNameField.getText());
            food.setSugarContent(sugarLevelField.getText());
            food.setTotalCalories(Integer.parseInt(calorieField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (productNameField.getText() == null || productNameField.getText().length() == 0) {
            errorMessage += "No valid product name!\n"; 
        }
        if (sugarLevelField.getText() == null || sugarLevelField.getText().length() == 0 ) {
            errorMessage += "No valid sugar level!\n"; 
        }
        if (calorieField.getText() == null || calorieField.getText().length() == 0) {
            errorMessage += "No valid calorie!\n"; 
        }

       

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

	

}
