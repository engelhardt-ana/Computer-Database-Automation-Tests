package com.pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEditComputerPage {
	public WebDriver driver;

	private static final String header = "//section//h1";
	private static final String computer_database_header = "//h1/a";
	private static final String computerNameId = "name";
	private static final String introducedId = "introduced";
	private static final String discontinuedId = "discontinued";
	private static final String companyId = "company";
	private static final String saveThisComputerBtn = "//div[contains(@class,'actions')]/input";
	private static final String cancelBtn = "//div[contains(@class,'actions')]/a";
	private static final String deleteThisComputerBtn = "//form/input[@class='btn danger']";
	private static final String filterByName = "searchsubmit";
	private static final String error_msg = "//input[@id='%s']//following-sibling::span";
	private static final String failed_to_refine_type = "Failed to refine type : Predicate isEmpty() did not fail.";
	private static final String invalid_value_for_month = "Failed to decode date : java.time.format.DateTimeParseException: Text '%s' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): %s";
	private static final String invalid_value_for_day = "Failed to decode date : java.time.format.DateTimeParseException: Text '%s' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): %s";
	private static final String failed_to_decode_date = "Failed to decode date : java.time.format.DateTimeParseException: Text '%s' could not be parsed at index 4";
	private static final String discontinued_date_before_introduction = "Discontinued date is before introduction date";

	public AddEditComputerPage(WebDriver driver) {
		this.driver = driver;
	}

	public MainComputerPage saveThisComputer() {
		getElement(saveThisComputerBtn).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(filterByName)));
		return new MainComputerPage(this.driver);
	}

	public MainComputerPage cancel() {
		getElement(cancelBtn).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(filterByName)));
		return new MainComputerPage(this.driver);
	}
	public MainComputerPage clickOnComputerDatabase() {
		getElement(computer_database_header).click();
		return new MainComputerPage(this.driver);
	}

	public AddEditComputerPage saveThisComputerAndStay() {
		getElement(saveThisComputerBtn).click();
		return this;
	}

	public MainComputerPage deleteThisComputer() {
		getElement(deleteThisComputerBtn).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(filterByName)));
		return new MainComputerPage(this.driver);
	}

	public AddEditComputerPage verifyAddAComputerTitle() {
		assertEquals("Add a computer", getTextByElement(header));
		return this;
	}

	public AddEditComputerPage verifyEditComputerTitle() {
		assertEquals("Edit computer", getTextByElement(header));
		return this;
	}

	public AddEditComputerPage verifyComputerNameErrorMessageFailedToRefineType() {
		assertEquals(failed_to_refine_type, getTextByElement(String.format(error_msg, computerNameId)));
		return this;
	}

	public AddEditComputerPage verifyIntroducedErrorMessageInvalidValueForMonthOfYear(String badDate, String badMonth) {
		assertEquals(String.format(invalid_value_for_month, badDate, badMonth),
				getTextByElement(String.format(error_msg, introducedId)));
		return this;
	}

	public AddEditComputerPage verifyIntroducedErrorMessageFailedToDecodeDate(String badDate) {
		assertEquals(String.format(failed_to_decode_date, badDate),
				getTextByElement(String.format(error_msg, introducedId)));
		return this;
	}

	public AddEditComputerPage verifyDiscontinuedErrorMessageInvalidValueForDayOfMonth(String badDate, String badDay) {
		assertEquals(String.format(invalid_value_for_day, badDate, badDay),
				getTextByElement(String.format(error_msg, discontinuedId)));
		return this;
	}

	public AddEditComputerPage verifyDiscontinuedErrorMessageDiscontinuedDateBeforeIntroduction() {
		assertEquals(discontinued_date_before_introduction, getTextByElement(String.format(error_msg, discontinuedId)));
		return this;
	}

	public AddEditComputerPage clearComputerName() {
		getElementById(computerNameId).clear();
		return this;
	}

	public AddEditComputerPage clearIntroduced() {
		getElementById(introducedId).clear();
		return this;
	}

	public AddEditComputerPage setComputerName(String computerName) {
		getElementById(computerNameId).sendKeys(computerName);
		return this;
	}

	public AddEditComputerPage setIntroduced(Date dateIntroduced) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(dateIntroduced);
		getElementById(introducedId).sendKeys(date);
		return this;
	}

	public AddEditComputerPage setIntroduced(String dateIntroduced) {
		getElementById(introducedId).sendKeys(dateIntroduced);
		return this;
	}

	public AddEditComputerPage setDiscontinued(String dateDiscontinued) {
		getElementById(discontinuedId).sendKeys(dateDiscontinued);
		return this;
	}

	public AddEditComputerPage chooseCompany(String company) {
		Select select = new Select(getElementById(companyId));
		select.selectByVisibleText(company);
		return this;
	}

	public AddEditComputerPage verifyComputerName(String computerName) {
		assertEquals(computerName, (getElementById(computerNameId).getAttribute("value")));
		return this;
	}

	public AddEditComputerPage verifyStatusComputerNameInputVisible() {
		verifyStatusVisibleById(computerNameId);
		return this;
	}

	public AddEditComputerPage verifyStatusComputerNameInputEnabled() {
		verifyStatusEnabledById(computerNameId);
		return this;
	}

	public AddEditComputerPage verifyStatusIntroducedInputVisible() {
		verifyStatusVisibleById(introducedId);
		return this;
	}

	public AddEditComputerPage verifyStatusIntroducedInputEnabled() {
		verifyStatusEnabledById(introducedId);
		return this;
	}

	public AddEditComputerPage verifyStatusDiscontinuedInputVisible() {
		verifyStatusVisibleById(discontinuedId);
		return this;
	}

	public AddEditComputerPage verifyStatusDiscontinuedInputEnabled() {
		verifyStatusEnabledById(discontinuedId);
		return this;
	}

	public AddEditComputerPage verifyStatusCompanyComboVisible() {
		verifyStatusVisibleById(companyId);
		return this;
	}

	public AddEditComputerPage verifyStatusCompanyComboEnabled() {
		verifyStatusEnabledById(companyId);
		return this;
	}

	public AddEditComputerPage verifyStatusCreateThisComputerButtonVisible() {
		verifyStatusVisibleByXpath(saveThisComputerBtn);
		return this;
	}

	public AddEditComputerPage verifyStatusCreateThisComputerButtonEnabled() {
		verifyStatusEnabledByXpath(saveThisComputerBtn);
		return this;
	}

	public AddEditComputerPage verifyStatusCancelButtonVisible() {
		verifyStatusVisibleByXpath(cancelBtn);
		return this;
	}

	public AddEditComputerPage verifyStatusCancelEnabled() {
		verifyStatusEnabledByXpath(cancelBtn);
		return this;
	}

	public AddEditComputerPage verifyStatusDeleteANewComputerButtonVisible() {
		verifyStatusVisibleByXpath(deleteThisComputerBtn);
		return this;
	}

	public AddEditComputerPage verifyStatusDeleteANewComputerButtonEnabled() {
		verifyStatusEnabledByXpath(deleteThisComputerBtn);
		return this;
	}

	private void verifyStatusEnabledById(String id) {
		WebElement element = driver.findElement(By.id(id));
		assertTrue(element.isEnabled());
	}

	private void verifyStatusVisibleById(String id) {
		WebElement element = driver.findElement(By.id(id));
		assertTrue(element.isDisplayed());
	}
	private void verifyStatusEnabledByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		assertTrue(element.isEnabled());
	}

	private void verifyStatusVisibleByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		assertTrue(element.isDisplayed());
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