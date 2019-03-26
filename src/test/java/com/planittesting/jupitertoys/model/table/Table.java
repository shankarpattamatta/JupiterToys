package com.planittesting.jupitertoys.model.table;

import java.util.List;

import javax.swing.text.TabExpander;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

//This class is designed  in order to server the test case such as finding the price of a product given the title
//Here we have the inputs such as title or item with columnId 1

public class Table {

	private WebElement rootElement;;

	public Table(WebElement rootElement) {
		this.rootElement = rootElement;
	}

	// Get the indexes of item column and price column
	public int findIndex(String columnName) throws Exception {
		List<WebElement> tableHeaders = rootElement.findElements(By.tagName("th"));
		int index = 0;
		for (WebElement tableHeader : tableHeaders) {
			if (tableHeader.getText().equalsIgnoreCase(columnName)) {

				return index;
			}
			index++;
		}

		throw new Exception("Index not found for column name " + columnName);
	}

	public WebElement getValue(String searchColumn, String returnColumn, String searchValue) throws Exception {
		int searchColumnIndex = findIndex(searchColumn);
		int returnColumnIndex = findIndex(returnColumn);
		int currentIndex = 0;

		// For each row in table -of the value of search colun index is equals to
		// ssearch value return the correspoding price value
		List<WebElement> tableRows = rootElement.findElements(By.cssSelector("tbody tr"));
		for (WebElement tableRow : tableRows) {

			List<WebElement> tableData = tableRow.findElements(By.tagName("td"));
			if (tableData.get(searchColumnIndex).getText().equalsIgnoreCase(searchValue)) {
				
					return tableData.get(returnColumnIndex);
				
			}

		}
		throw new Exception("Price Not found");
	}
}
