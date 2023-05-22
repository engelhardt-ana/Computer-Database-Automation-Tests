package com.pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainComputerPage {

	public WebDriver driver;
	private static final String title = "//a[contains(@href,'/computers')]";
	private static final String header = "//section//h1";
	private static final String computerNameColumn = "//thead//th[contains(@class,'col-name')]/a";
	private static final String introducedColumn = "//thead//th[contains(@class,'col-introduced')]/a";
	private static final String discontinuedColumn = "//thead//th[contains(@class,'col-discontinued')]/a";
	private static final String companyColumn = "//thead//th[contains(@class,'col-company')]/a";
	private static final String computerNameByRow = "//tbody//tr[%s]//a";
	private static final String editByComputerName = "//tbody//a[normalize-space(text())='%s']";
	private static final String searchboxId = "searchbox";
	private static final String add_page_header = "//section//h1[normalize-space(text())='Add a computer']";
	private static final String filterByName = "searchsubmit";
	private static final String columnValueByMainColumn = "//tbody//a[normalize-space(text())='%s']/parent::td//following-sibling::td[%s]";
	private static final String addComputer = "add";
	private static final String nextArrow = "next";
	private static final String previousArrow = "prev";
	private static final String numberOfRows = "//table/tbody/tr";
	private static final String pagination_page = "//div[@class='pagination']//li[@class='current']/a";
	private static final String edit_page_header = "//section//h1[normalize-space(text())='Edit computer']";
	private static final String alert = "//div[contains(@class,'alert-message ')]";
	private static final String alert_update = "Done ! Computer %s has been updated";
	private static final String alert_add = "Done ! Computer %s has been created";
	private static final String alert_delete = "Done ! Computer %s has been deleted";
	private static final String no_computer_page_header = "//section//h1[normalize-space(text())='No computer']";
	private static final String nothing_to_display = "//section//em";

	public MainComputerPage(WebDriver driver) {
		this.driver = driver;
	}

	public MainComputerPage filterByComputerName(String computerName) {
		getElementById(searchboxId).click();
		getElementById(searchboxId).sendKeys(computerName);
		getElementById(filterByName).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(getElementById(filterByName)));
		return this;
	}

	public AddEditComputerPage editByComputerName(String computerName) {
		getElement(String.format(editByComputerName, computerName)).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(getElement(edit_page_header)));
		return new AddEditComputerPage(this.driver);
	}

	public AddEditComputerPage addNewComputer() {
		getElementById(addComputer).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(getElement(add_page_header)));
		return new AddEditComputerPage(this.driver);
	}

	public MainComputerPage clearFilterByComputerName() {
		getElementById(searchboxId).clear();
		return this;
	}

	public MainComputerPage sortComputerNameColumn() {
		getElement(computerNameColumn).click();
		return this;
	}

	public MainComputerPage verifyAlertComputerHasBeenUpdated(String newComputerName) {
		assertEquals(String.format(alert_update, newComputerName), getTextByElement(alert));
		return this;
	}

	public MainComputerPage verifyAlertComputerHasBeenAdded(String newComputerName) {
		assertEquals(String.format(alert_add, newComputerName), getTextByElement(alert));
		return this;
	}

	public MainComputerPage verifyAlertComputerHasBeenDeleted(String newComputerName) {
		assertEquals(String.format(alert_delete, newComputerName), getTextByElement(alert));
		return this;
	}

	public MainComputerPage verifyComputerDataBaseTitle() {
		assertEquals("Computer database", getTextByElement(title));
		return this;
	}

	public MainComputerPage verifyNoComputerTitle() {
		assertEquals("No computer", getTextByElement(no_computer_page_header));
		return this;
	}

	public MainComputerPage verifyNothingToDisplayMessage() {
		assertEquals("Nothing to display", getTextByElement(nothing_to_display));
		return this;
	}

	public MainComputerPage verifyNumberOfComputerFromHeader(int number) {
		assertEquals(number + " computers found", getTextByElement(header),
				"Number in the header does not match the expected result.");
		return this;
	}

	public MainComputerPage verifyPaginationInformation(int firstNum, int lastNum, int allElements) {
		assertEquals(String.format("Displaying " + firstNum + " to " + lastNum + " of " + allElements),
				getTextByElement(pagination_page));
		return this;
	}

	public MainComputerPage verifyComputerNameColumn() {
		assertEquals("Computer name", getTextByElement(computerNameColumn));
		return this;
	}

	public MainComputerPage verifyIntroducedColumn() {
		assertEquals("Introduced", getTextByElement(introducedColumn));
		return this;
	}

	public MainComputerPage verifyDiscontinuedColumn() {
		assertEquals("Discontinued", getTextByElement(discontinuedColumn));
		return this;
	}

	public MainComputerPage verifyCompanyColumn() {
		assertEquals("Company", getTextByElement(companyColumn));
		return this;
	}

	public MainComputerPage verifyNumberOfRowsInTable(int expectedRows) {
		List<WebElement> rows = driver.findElements(By.xpath(numberOfRows));
		int count = rows.size();
		assertEquals(expectedRows, count);
		return this;
	}

	public MainComputerPage verifyComputerNameByRow(String computerName, int row) {
		assertEquals(computerName, getTextByElement(String.format(computerNameByRow, row)));
		return this;
	}

	public MainComputerPage verifyIntroducedByComputerName(Date dateIntroduced, String computerName) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(dateIntroduced);
		verifyColumnValueByMainColumn(date, computerName, 1);
		return this;
	}

	public MainComputerPage verifyIntroducedEmptyByComputerName(String computerName) {
		verifyColumnValueByMainColumn("-", computerName, 1);
		return this;
	}

	public MainComputerPage verifyDiscontinuedEmptyByComputerName(String computerName) {
		verifyColumnValueByMainColumn("-", computerName, 2);
		return this;
	}

	public MainComputerPage verifyCompanyByComputerName(String verifyingItem, String computerName) {
		verifyColumnValueByMainColumn(verifyingItem, computerName, 3);
		return this;
	}

	public MainComputerPage verifyStatusSearchboxVisible() {
		verifyStatusVisibleById(searchboxId);
		return this;
	}

	public MainComputerPage verifyStatusSearchboxEnabled() {
		verifyStatusEnabledById(searchboxId);
		return this;
	}

	public MainComputerPage verifyStatusFilterByNameVisible() {
		verifyStatusVisibleById(filterByName);
		return this;
	}

	public MainComputerPage verifyStatusFilterByNameEnabled() {
		verifyStatusEnabledById(filterByName);
		return this;
	}

	public MainComputerPage verifyStatusAddANewComputerButtonVisible() {
		verifyStatusVisibleById(addComputer);
		return this;
	}

	public MainComputerPage verifyStatusAddANewComputerButtonEnabled() {
		verifyStatusEnabledById(addComputer);
		return this;
	}

	public MainComputerPage verifyPreviousArrowVisible() {
		verifyStatusVisibleByClassName(previousArrow);
		return this;
	}

	public MainComputerPage verifyNextArrowVisible() {
		verifyStatusVisibleByClassName(nextArrow);
		return this;
	}

	private void verifyColumnValueByMainColumn(String verifyingItem, String mainItem, int columnNumber) {
		assertEquals(verifyingItem, getTextByElement(String.format(columnValueByMainColumn, mainItem, columnNumber)));
	}

	private void verifyStatusVisibleById(String id) {
		WebElement element = driver.findElement(By.id(id));
		assertTrue(element.isDisplayed());
	}

	private void verifyStatusVisibleByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		assertTrue(element.isDisplayed());
	}

	private void verifyStatusEnabledById(String id) {
		WebElement element = driver.findElement(By.id(id));
		assertTrue(element.isEnabled());
	}
	private String getTextByElement(String xpath) {
		return getElement(xpath).getText();
	}

	private WebElement getElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}

}