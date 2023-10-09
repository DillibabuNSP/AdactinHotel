package org.atmecs.web_automation_adactin.pages;

import org.atmecs.web_autoamtion_adactin.page.keys.HomePageKeys;
import org.atmecs.web_automation_adactin.constants.Constants;
import org.atmecs.web_automation_adactin.constants.FilePathConstants;
import org.atmecs.web_automation_adactin.constants.LogMessages;
import org.atmecs.web_automation_adactin.constants.VerifyMessage;
import org.atmecs.web_automation_adactin.utils.PropertyParser;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>HomePage</code> class contains methods to perform actions on the
 * Home page. It provides functionality to enter the username, password, and
 * click the login button.
 */
public class HomePage {
	private PropertyParser homePageProperty;
	private ReportLogService report = new ReportLogServiceImpl(HomePage.class);
	PropertyParser homePageTestData;

	/**
	 * Constructor to initialize the HomePage object.
	 */
	public HomePage() {
		homePageProperty = new PropertyParser(FilePathConstants.HOME_PAGE_PATH);
		homePageTestData = new PropertyParser(FilePathConstants.TESTDATA_PAGE_PATH);
	}

	public void verifyTitle(Browser browser) {
		report.info("Verify Title");
		String HomePageTitlePath = homePageProperty.getPropertyValue(HomePageKeys.HOMEPAGE_TITLE);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, HomePageTitlePath, Constants.TIME_OUTS);
		WebElement title = browser.getFindFromBrowser().findElementByXpath(HomePageTitlePath);
		Verify.verifyStringAndStopTest(title.getText(), VerifyMessage.HOMEPAGE_TITLE, LogMessages.HOMEPAGE_TITLE);
	}

	/**
	 * Enters the username in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterUserName(Browser browser) {
		report.info(LogMessages.ENTERUSERNAME);
		String userNamePath = homePageProperty.getPropertyValue(HomePageKeys.USER_NAME);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, userNamePath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, userNamePath,
				homePageTestData.getPropertyValue(HomePageKeys.USERNAME));
	}

	/**
	 * Enters the password in the corresponding text field.
	 *
	 * @param browser The browser instance
	 */
	public void enterPassword(Browser browser) {
		report.info(LogMessages.ENTERPASSWORD);
		String passWordPath = homePageProperty.getPropertyValue(HomePageKeys.PASS_WORD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, passWordPath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, passWordPath,
				homePageTestData.getPropertyValue(HomePageKeys.PASSWORD));
	}

	/**
	 * Clicks the login button to log in.
	 *
	 * @param browser The browser instance
	 */
	public void clickLogIn(Browser browser) {
		report.info(LogMessages.CLICKLOGINBUTTON);
		String clickLoginXpath = homePageProperty.getPropertyValue(HomePageKeys.LOGIN_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, clickLoginXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH,clickLoginXpath);
	}
}
