package org.atmecs.web_automation_adactin.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

import org.atmecs.web_autoamtion_adactin.page.keys.BookedItineraryPageKeys;
import org.atmecs.web_automation_adactin.constants.Constants;
import org.atmecs.web_automation_adactin.constants.FilePathConstants;
import org.atmecs.web_automation_adactin.constants.LogMessages;
import org.atmecs.web_automation_adactin.constants.VerifyMessage;
import org.atmecs.web_automation_adactin.utils.PropertyParser;

/**
 * This class contains methods to perform actions related to the booked itinerary page.
 */
public class BookedItinerary {
    private ReportLogService report = new ReportLogServiceImpl(BookedItinerary.class);
    private BookingConfirmation bookingConfirmation = new BookingConfirmation();
    private PropertyParser bookedItineraryProperty;

    /**
     * Constructor to initialize the BookedItinerary object.
     */
    public BookedItinerary() {
        bookedItineraryProperty = new PropertyParser(FilePathConstants.BOOKEDITINERARY_PAGE_PATH);
    }

    /**
     * Enters the search ID in the corresponding text field.
     *
     * @param browser The browser instance
     */
    public void enterSearchID(Browser browser) {
        report.info(LogMessages.SEARCH_ID);
        browser.getTextField().enterTextField(LocatorType.XPATH,
                bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.SEARCH_ID),
                bookingConfirmation.order_ID);
    }

    /**
     * Clicks on the 'Go' button to search for booked itinerary details.
     *
     * @param browser The browser instance
     * @throws InterruptedException Thrown if the thread is interrupted
     */
    public void clickGO(Browser browser) throws InterruptedException {
        report.info(LogMessages.CLICK_GO);
        browser.getClick().performClick(LocatorType.XPATH,
                bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.CLICK_GO));
        Thread.sleep(5000);
    }

    /**
     * Extracts booking details from the table based on the search ID and writes
     * them to a file.
     *
     * @param browser The browser instance
     */
    public void idDetails(Browser browser) {
        report.info(LogMessages.FETCH_DETAILS);
        try {
            String searchId = bookingConfirmation.order_ID;
            String rowsXpath = bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.TABLE);
            browser.getWait().waitForElementPresence(LocatorType.XPATH, rowsXpath, Constants.TIME_OUTS);
            List<WebElement> rows = browser.getFindFromBrowser().findElementsBy(By.xpath(rowsXpath));
            String filePath = FilePathConstants.OUTPUT_FILE_PATH;

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            for (WebElement row : rows) {
                String orderElementPath = bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.TABLE_DATA);
                WebElement orderIdElement = row.findElement(By.xpath(orderElementPath));
                String orderId = orderIdElement.getAttribute("value");

                if (orderId.equals(searchId)) {

                    browser.getWait().waitForElementPresence(LocatorType.XPATH, orderElementPath, Constants.TIME_OUTS);
                    List<WebElement> inputElements = row.findElements(By.xpath(orderElementPath));
                    for (WebElement inputElement : inputElements) {
                        String fieldName = inputElement.getAttribute(Constants.NAME);
                        String fieldValue = inputElement.getAttribute(Constants.VALUE);
                        String lineToWrite = fieldName + ": " + fieldValue;
                        System.out.println(lineToWrite);
                        writer.write(lineToWrite);
                        writer.newLine();
                    }

                    break;
                }
            }

            writer.close();

        } catch (Exception e) {
            report.error("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Clicks on the Logout button and verifies the logout message.
     *
     * @param browser The browser instance
     */
    public void clickLogOut(Browser browser){
        report.info("Click logOut");
        browser.getClick().performClick(LocatorType.XPATH,
                bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.CLICK_LOGOUT));
        String logOutMessagePath = bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.LOGOUT_MESSAGE);
        browser.getWait().waitForElementPresence(LocatorType.XPATH, logOutMessagePath, Constants.TIME_OUTS);
        WebElement logOutMessage = browser.getFindFromBrowser().findElementByXpath(logOutMessagePath);
        report.info("logout message " + logOutMessage.getText());
        Verify.verifyStringAndStopTest(logOutMessage.getText(), VerifyMessage.LOGOUT_MESSAGE,
                LogMessages.SUCCESSFUL_MESSAGE);
    }

    /**
     * Clicks on the "Login Again" button.
     *
     * @param browser The browser instance
     */
    public void clickOnLogInAgain(Browser browser) {
        report.info("Click logIn Again");
        String logInAgainPath = bookedItineraryProperty.getPropertyValue(BookedItineraryPageKeys.CLICK_LOGIN_AGAIN);
        browser.getWait().waitForElementPresence(LocatorType.XPATH, logInAgainPath, Constants.TIME_OUTS);
        browser.getClick().performClick(LocatorType.XPATH, logInAgainPath);
    }
}
