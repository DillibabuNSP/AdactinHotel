package org.atmecs.web_automation_adactin.pages;

import org.atmecs.web_autoamtion_adactin.page.keys.HotelSelectionPageKeys;
import org.atmecs.web_automation_adactin.constants.FilePathConstants;
import org.atmecs.web_automation_adactin.constants.LogMessages;
import org.atmecs.web_automation_adactin.reusableFiles.ReusableFiles;
import org.atmecs.web_automation_adactin.utils.PropertyParser;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>HotelSelectionPage</code> class contains methods to perform actions
 * on the Hotel Selection page. It provides functionality to select a hotel and
 * click the continue button.
 */
public class HotelSelectionPage {
	private ReportLogService report = new ReportLogServiceImpl(HotelSelectionPage.class);
	private ReusableFiles reusableFiles = new ReusableFiles();
	private PropertyParser hotelSelectionPageProperty;

	/**
	 * Constructor to initialize the HotelSelectionPage object.
	 */
	public HotelSelectionPage() {
		hotelSelectionPageProperty = new PropertyParser(FilePathConstants.HOTEL_SELECTION_PAGE_PATH);
	}

	/**
	 * Selects a hotel by clicking the radio button.
	 *
	 * @param browser The browser instance
	 */
	public void selectHotel(Browser browser) {
		report.info(LogMessages.SELECT_HOTEL);
		reusableFiles.clickRadioButton(browser,
				hotelSelectionPageProperty.getPropertyValue(HotelSelectionPageKeys.SELECT_HOTEL1),
				hotelSelectionPageProperty.getPropertyValue(HotelSelectionPageKeys.SELECT_HOTEL2));
	}

	/**
	 * Clicks the "Continue" button to proceed with the hotel selection.
	 *
	 * @param browser The browser instance
	 */
	public void clickContinue(Browser browser) {
		report.info(LogMessages.CLICK_CONTINUE);
		browser.getClick().performClick(LocatorType.XPATH,
				hotelSelectionPageProperty.getPropertyValue(HotelSelectionPageKeys.CLICK_CONTINUE));
	}
}
