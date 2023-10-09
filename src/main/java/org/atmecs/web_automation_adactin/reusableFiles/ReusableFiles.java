package org.atmecs.web_automation_adactin.reusableFiles;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.atmecs.web_automation_adactin.constants.FilePathConstants;
import org.atmecs.web_automation_adactin.utils.PropertyParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.github.javafaker.Faker;

/**
 * The <code>ReusableFiles</code> class contains reusable methods for various
 * actions such as selecting dropdown values, entering dates, clicking radio
 * buttons, generating credit card numbers, and getting text from web elements.
 */
public class ReusableFiles {
	private static ReportLogService report = new ReportLogServiceImpl(ReusableFiles.class);
	PropertyParser propertyParser;
	private Faker faker = new Faker();

	/**
	 * Constructor to initialize the ReusableFiles object.
	 */
	public ReusableFiles() {
		propertyParser = new PropertyParser(FilePathConstants.HOME_PAGE_PATH);
	}

	/**
	 * Generates a random browser selection from the properties.
	 *
	 * @return A randomly selected browser name
	 */
	public static String randomBrowserSelection() {
		List<String> browsers = readBrowsersFromProperties();
		if (browsers.isEmpty()) {
			report.info("No browsers found in the properties file.");
		}

		return getRandomBrowser(browsers);
	}

	/**
	 * Selects a random option from a dropdown element.
	 *
	 * @param browser The browser instance
	 * @param locator The locator for the dropdown element
	 */
	public void selectDropDown(Browser browser, String locator) {
		WebElement dropdown = browser.getFindFromBrowser().findElementByXpath(locator);
		List<WebElement> options = dropdown.findElements(By.tagName("option"));
		int randomIndex = getRandomIndex(options.size());
		options.get(randomIndex).click();
	}

	public void selectDropDownByVisibleText(Browser browser, String locator, String valueToSelect) {
		WebElement dropdown = browser.getFindFromBrowser().findElementByXpath(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(valueToSelect);
	}

	public void selectYearDropDown(Browser browser, String locator) {
		WebElement dropdown = browser.getFindFromBrowser().findElementByXpath(locator);
		List<WebElement> options = dropdown.findElements(By.tagName("option"));

		// Get the current year
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		// Filter out options that are less than the current year
		options.removeIf(option -> Integer.parseInt(option.getAttribute("value")) < currentYear);

		// Check if there are any options left
		if (!options.isEmpty()) {
			int randomIndex = getRandomIndex(options.size());
			options.get(randomIndex).click();
		}
	}

	/**
	 * Enters random check-in and check-out dates in the specified input fields.
	 *
	 * @param browser  The browser instance
	 * @param locator1 The locator for the check-in date input field
	 * @param locator2 The locator for the check-out date input field
	 */
	public void enterDate(Browser browser, String locator1, String locator2, String inDate, String outDate) {
		WebElement checkinDateInput = browser.getFindFromBrowser().findElementByXpath(locator1);
		WebElement checkoutDateInput = browser.getFindFromBrowser().findElementByXpath(locator2);
//        LocalDate currentDate = LocalDate.now();
//        int randomDays = new Random().nextInt(4) + 4;
//        LocalDate checkoutDate = currentDate.plusDays(randomDays);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedCheckinDate = currentDate.format(formatter);
//        String formattedCheckoutDate = checkoutDate.format(formatter);
		checkinDateInput.clear();
		checkinDateInput.sendKeys(inDate);
		checkoutDateInput.clear();
		checkoutDateInput.sendKeys(outDate);
	}

	/**
	 * Clicks a random radio button from a group of radio buttons.
	 *
	 * @param browser The browser instance
	 * @param locator The locator for the radio buttons group
	 */
	public void clickRadioButton(Browser browser, String locator1, String locator2) {
		List<String> radioButtonXPaths = new ArrayList<>();
		radioButtonXPaths.add(locator1);
		radioButtonXPaths.add(locator2);
		// Add more XPaths from the Constants class as needed

		// Find all radio buttons using the XPaths with an "OR" condition
		List<WebElement> radioButtons = findRadioButtons(browser, radioButtonXPaths);

		// Check if there are radio buttons present
		if (!radioButtons.isEmpty()) {
			// Generate a random index to select a radio button
			int randomIndex = new Random().nextInt(radioButtons.size());

			// Click the randomly selected radio button
			radioButtons.get(randomIndex).click();
		}
	}

	// Custom method to find radio buttons using an "OR" condition on XPaths
	public static List<WebElement> findRadioButtons(Browser browser, List<String> xPaths) {
		List<WebElement> matchingElements = new ArrayList<>();
		for (String xPath : xPaths) {
			List<WebElement> elements = browser.getFindFromBrowser().findElementsBy(By.xpath(xPath));
			matchingElements.addAll(elements);
		}
		return matchingElements;
	}

	/**
	 * Generates a random 16-digit credit card number.
	 *
	 * @return A random 16-digit credit card number
	 */
	public String creditCardNumber() {
		StringBuilder random16DigitNumber = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int digit = faker.number().numberBetween(0, 10);
			random16DigitNumber.append(digit);
		}
		return random16DigitNumber.toString();
	}

	/**
	 * Gets the text from a web element identified by the locator.
	 *
	 * @param browser The browser instance
	 * @param locator The locator for the web element
	 * @return The text from the web element
	 */
	public String getText(Browser browser, String locator) {
		WebElement inputElement = browser.getFindFromBrowser().findElementByXpath(locator);
		return inputElement.getAttribute("value");
	}

	private static String getRandomBrowser(List<String> browsers) {
		if (browsers.isEmpty()) {
			return null;
		}
		int randomIndex = getRandomIndex(browsers.size());
		return browsers.get(randomIndex);
	}

	private static List<String> readBrowsersFromProperties() {
		List<String> browsers = new ArrayList<>();
//        String browsersProperty = propertyParser.getPropertyValue("");
//        String[] browserNames = browsersProperty.split(",");
//        for (String browserName : browserNames) {
//            browsers.add(browserName.trim());
//        }
		return browsers;
	}

	private static int getRandomIndex(int size) {
		return new Random().nextInt(size);
	}
}
