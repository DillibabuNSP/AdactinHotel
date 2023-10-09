package org.atmecs.web_automation_adactin.pages;

import org.atmecs.web_autoamtion_adactin.page.keys.BookAHotelPageKeys;
import org.atmecs.web_automation_adactin.constants.Constants;
import org.atmecs.web_automation_adactin.constants.FilePathConstants;
import org.atmecs.web_automation_adactin.constants.LogMessages;
import org.atmecs.web_automation_adactin.reusableFiles.ReusableFiles;
import org.atmecs.web_automation_adactin.utils.PropertyParser;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>BookAHotelPage</code> class contains methods to perform actions on
 * the Book A Hotel page. It provides functionality to enter personal
 * information, credit card details, and book a hotel.
 */
public class BookAHotelPage {
	private ReportLogService report = new ReportLogServiceImpl(BookAHotelPage.class);
	ReusableFiles reusableFiles = new ReusableFiles();
	PropertyParser bookAHotelPageProperty;

	/**
	 * Constructor to initialize the BookAHotelPage object.
	 */
	public BookAHotelPage() {
		bookAHotelPageProperty = new PropertyParser(FilePathConstants.BOOKAHOTEL_PAGE_PATH);
	}

	/**
	 * Enters the first name in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterFirstName(Browser browser, String firstName) {
		report.info(LogMessages.ENTER_FIRSTNAME);
		String firstNameXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.FIRST_NAME);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, firstNameXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, firstNameXpath, firstName);
	}

	/**
	 * Enters the last name in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterLastName(Browser browser, String lastName) {
		report.info(LogMessages.ENTER_LASTNAME);
		String lastNameXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.LAST_NAME);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, lastNameXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, lastNameXpath, lastName);
	}

	/**
	 * Enters the address in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterAddress(Browser browser, String address) {
		report.info(LogMessages.ENTER_ADDRESS);
		String adressXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.ADDRESS);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, adressXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, adressXpath, address);

	}

	/**
	 * Enters the credit card number in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterCreditCardNo(Browser browser, String creditCardNumber) {
		report.info(LogMessages.ENTER_CREDIT_CARDNO);
		String creditCardNoXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.CREDIT_CARDNO);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, creditCardNoXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, creditCardNoXpath, creditCardNumber);
	}

	/**
	 * Selects the card type from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectCardType(Browser browser, String cardType) {
		report.info(LogMessages.ENTER_CARD_TYPE);
		String cardTypeXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.CARD_TYPE);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, cardTypeXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, cardTypeXpath, cardType);
	}

	/**
	 * Selects the expiry month from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectMonth(Browser browser, String month) {
		report.info(LogMessages.SELECT_MONTH);
		String selectMonthXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.SELECT_MONTH);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectMonthXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, selectMonthXpath, month);
	}

	/**
	 * Selects the expiry year from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectYear(Browser browser, String year) {
		report.info(LogMessages.SELECT_YEAR);
		String selectYearXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.SELECT_YEAR);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectYearXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, selectYearXpath, year);
	}

	/**
	 * Enters the CCV number in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterCCVNumber(Browser browser, String ccv) {
		report.info(LogMessages.ENTER_CCV_NUMBER);
		String ccvNumberXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.CCV_NUMBER);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, ccvNumberXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, ccvNumberXpath, ccv);
	}

	/**
	 * Clicks on the "Book Now" button to book a hotel.
	 *
	 * @param browser The browser instance
	 * @throws InterruptedException Thrown if the thread is interrupted
	 */
	public void clickOnBookNow(Browser browser) throws InterruptedException {
		report.info(LogMessages.CLICK_BOOK_NOW);
		String bookNowXpath = bookAHotelPageProperty.getPropertyValue(BookAHotelPageKeys.BOOK_NOW);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, bookNowXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, bookNowXpath);
		Thread.sleep(5000);
	}
}
