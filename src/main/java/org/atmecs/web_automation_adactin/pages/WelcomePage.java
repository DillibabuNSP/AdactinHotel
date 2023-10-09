package org.atmecs.web_automation_adactin.pages;

import org.atmecs.web_autoamtion_adactin.page.keys.WelcomePageKeys;
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
 * The <code>WelcomePage</code> class contains methods to perform actions on the
 * Welcome page. It provides functionality to select the location, hotels, room
 * type, number of rooms, enter check-in and check-out dates, select adults and
 * children per room, and click the search button.
 */
public class WelcomePage {
	private ReportLogService report = new ReportLogServiceImpl(WelcomePage.class);
	private ReusableFiles reusableFiles = new ReusableFiles();
	private PropertyParser welcomePageProperty;

	/**
	 * Constructor to initialize the WelcomePage object.
	 */
	public WelcomePage() {
		welcomePageProperty = new PropertyParser(FilePathConstants.WELCOME_PAGE_PATH);
	}

	/**
	 * Selects a location from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectLocation(Browser browser, String location) {
		report.info(LogMessages.SELECT_LOCATION);
		String selectLocationXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.LOCATION);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectLocationXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, selectLocationXpath, location);
	}

	/**
	 * Selects a hotel from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectHotels(Browser browser, String hotels) {
		report.info(LogMessages.SELECT_HOTELS);
		String selectHotelsXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.HOTELS);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectHotelsXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, selectHotelsXpath, hotels);
	}

	/**
	 * Selects a room type from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectRoomType(Browser browser, String roomType) {
		report.info(LogMessages.SELECT_ROOMTYPE);
		String selectRoomXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.HOTELS);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectRoomXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, selectRoomXpath, roomType);
	}

	/**
	 * Selects the number of rooms from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void selectNumberOfRooms(Browser browser, String noOfRooms) {
		report.info(LogMessages.SELECT_NUMBER_ROOMS);
		String numberofRoomsXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.NUMBER_ROOMS);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, numberofRoomsXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, numberofRoomsXpath, noOfRooms);
	}

	/**
	 * Enters the check-in and check-out dates.
	 *
	 * @param browser The browser instance
	 */
	public void enterCheckInCheckOutDate(Browser browser, String inDate, String outDate) {
		report.info(LogMessages.CHECKIN_CHECKOUT);
		String datePickInXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.DATE_PICKIN);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, datePickInXpath, Constants.TIME_OUTS);
		String datePickOutXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.DATE_PICKOUT);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, datePickOutXpath, Constants.TIME_OUTS);
		reusableFiles.enterDate(browser, datePickInXpath, datePickOutXpath, inDate, outDate);
	}

	/**
	 * Selects the number of adults per room from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void enterAdultsPerRoom(Browser browser, String adultPerRoom) {
		report.info(LogMessages.ADULTS_ROOM);
		String adultPerRoomXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.ADULT_PERROOM);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, adultPerRoomXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, adultPerRoomXpath, adultPerRoom);
	}

	/**
	 * Selects the number of children per room from the dropdown.
	 *
	 * @param browser The browser instance
	 */
	public void enterChildrenPerRoom(Browser browser, String childrenPerRoom) {
		report.info(LogMessages.CHILDREN_ROOM);
		String childrenPerRoomXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.CHILDREN_PERROOM);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, childrenPerRoomXpath, Constants.TIME_OUTS);
		reusableFiles.selectDropDownByVisibleText(browser, childrenPerRoomXpath, childrenPerRoom);
	}

	/**
	 * Clicks the "Search" button to search for hotels.
	 *
	 * @param browser The browser instance
	 */
	public void clickSearch(Browser browser) {
		report.info(LogMessages.CLICK_SEARCH);
		String searchButtonXpath = welcomePageProperty.getPropertyValue(WelcomePageKeys.SEARCH);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, searchButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, searchButtonXpath);
	}
}
