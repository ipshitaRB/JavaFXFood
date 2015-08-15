/**
 * 
 */
package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.WritableIntegerValue;

/**
 * @author Ipshita
 *
 */
public class Food {
	
	private static final int ITEM_CODE_BASE = 1000;
	private static int foodCount = 0;
	
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = new SimpleStringProperty(productName);
	}

	/**
	 * @param sugarContent the sugarContent to set
	 */
	public void setSugarContent(String sugarContent) {
		this.sugarContent = new SimpleObjectProperty<SugarLevel>(SugarLevel.valueOf(sugarContent));
	}

	/**
	 * @param totalCalories the totalCalories to set
	 */
	public void setTotalCalories(int totalCalories) {
		this.totalCalories = new SimpleIntegerProperty(totalCalories);
	}

	private  StringProperty productName;
	private  ObjectProperty<SugarLevel> sugarContent;
	private  IntegerProperty totalCalories;
	private final IntegerProperty itemCode;

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName.get();
	}

	/**
	 * @return the sugarContent
	 */
	public String getSugarContent() {
		return sugarContent.get().toString();
	}

	/**
	 * @return the totalCalories
	 */
	public IntegerProperty totalCaloriesProperty() {
		return totalCalories;
	}

	/**
	 * @return the itemCode
	 */
	public IntegerProperty itemCodeProperty() {
		return itemCode;
	}
	
	/**
	 * @return the productName
	 */
	public StringProperty productNameProperty() {
		return productName;
	}

	/**
	 * @return the sugarContent
	 */
	public ObjectProperty<SugarLevel> SugarContentProperty() {
		return sugarContent;
	}

	/**
	 * @return the totalCalories
	 */
	public int getTotalCalories() {
		return totalCalories.get();
	}

	/**
	 * @return the itemCode
	 */
	public int getItemCode() {
		return itemCode.get();
	}


	/**
	 * 
	 */
	public Food() {
		this("", SugarLevel.LOW, 0);
	}

	/**
	 * @param object
	 * @param object2
	 */
	public Food(String productName, SugarLevel sugarContent, int totalCalories) {
		this.productName 	= new SimpleStringProperty(productName);
		this.sugarContent 	= new SimpleObjectProperty<SugarLevel>(sugarContent);
		this.totalCalories 	= new SimpleIntegerProperty(totalCalories);
		
		foodCount++;

		this.itemCode = new SimpleIntegerProperty(ITEM_CODE_BASE + foodCount); 
	}

	

}
