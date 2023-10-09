package org.atmecs.web_automation_adactin.pages;

import org.atmecs.web_autoamtion_adactin.page.keys.BookingConfirmationPageKeys;
import org.atmecs.web_automation_adactin.constants.FilePathConstants;
import org.atmecs.web_automation_adactin.constants.LogMessages;
import org.atmecs.web_automation_adactin.reusableFiles.ReusableFiles;
import org.atmecs.web_automation_adactin.utils.PropertyParser;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>BookingConfirmation</code> class contains methods to perform actions on the Booking Confirmation page.
 * It provides functionality to retrieve the order number and click on the itinerary.
 */
public class BookingConfirmation {
    private ReportLogService report = new ReportLogServiceImpl(BookingConfirmation.class);
    private ReusableFiles reusableFiles = new ReusableFiles();
    private PropertyParser bookingConfirmationProperty;
    public static String order_ID;

    /**
     * Constructor to initialize the BookingConfirmation object.
     */
    public BookingConfirmation() {
        bookingConfirmationProperty = new PropertyParser(FilePathConstants.BOOKING_CONFIRMATION_PAGE_PATH);
    }

    /**
     * Retrieves the order number from the Booking Confirmation page.
     *
     * @param browser The browser instance
     * @return The order number as a string
     */
    public String getOrderNo(Browser browser) {
        report.info(LogMessages.GET_ORDERNO);
        order_ID = reusableFiles.getText(browser, bookingConfirmationProperty.getPropertyValue(BookingConfirmationPageKeys.ORDER_NO));
        return order_ID;
    }

    /**
     * Clicks on the "Itinerary" link to view the booking itinerary.
     *
     * @param browser The browser instance
     * @throws InterruptedException Thrown if the thread is interrupted
     */
    public void clickItinerary(Browser browser) throws InterruptedException {
        report.info(LogMessages.CLICK_ITINERARY);
        browser.getClick().performClick(LocatorType.XPATH, bookingConfirmationProperty.getPropertyValue(BookingConfirmationPageKeys.CLICK_ITINERARY));
        Thread.sleep(5000);
    }
}
