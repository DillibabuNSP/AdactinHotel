package org.atmecs.web_automation_adactin.base;

import org.atmecs.web_automation_adactin.constants.LogMessages;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>BasePage</code> class provides common methods for initializing and
 * launching the web application. It serves as the foundation for other page
 * classes in the automation framework.
 */
public class BasePage {
	private ReportLogService report = new ReportLogServiceImpl(BasePage.class);

	/**
	 * Launches the web application in the specified browser.
	 *
	 * @param browser        The browser instance to use for testing.
	 * @param os             The operating system on which the test is executed.
	 * @param osVersion      The version of the operating system.
	 * @param br             The name of the browser to use (e.g., Chrome, Firefox).
	 * @param browserVersion The version of the browser.
	 */
	public void launchApp(Browser browser, String os, String osVersion, String br, String browserVersion) {
		// Log the opening of the browser
		report.info(LogMessages.OPEN_BROWSER + br);

		// Open the specified URL in the browser
		browser.openURL("https://adactinhotelapp.com/", os, osVersion, br, browserVersion);

		// Maximize the browser window
		report.info(LogMessages.MAXIMIZE_WINDOW);
		browser.maximizeWindow();
	}

}
