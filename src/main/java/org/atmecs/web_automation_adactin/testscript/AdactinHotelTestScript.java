package org.atmecs.web_automation_adactin.testscript;

import java.util.ArrayList;
import java.util.Iterator;

import org.atmecs.web_automation_adactin.base.BasePage;
import org.atmecs.web_automation_adactin.pages.*;
import org.atmecs.web_automation_adactin.testsuite.SampleTestSuiteBase;
import org.atmecs.web_automation_adactin.utils.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This class contains test methods for the Adactin Hotel Booking application.
 */
public class AdactinHotelTestScript extends SampleTestSuiteBase {

	BasePage basePage;
	HomePage homePage;
	WelcomePage welcomePage;
	HotelSelectionPage hotelSelectionPage;
	BookAHotelPage bookAHotelPage;
	BookingConfirmation bookingConfirmation;
	BookedItinerary bookedItinerary;

	/**
	 * Data provider for test data.
	 *
	 * @return An iterator of test data.
	 */
	@DataProvider(name = "getData")
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtils.getDataProvider();
		return testData.iterator();
	}

	/**
	 * Test method to launch the application.
	 *
	 * @param os             The operating system.
	 * @param osVersion      The operating system version.
	 * @param br             The browser.
	 * @param browserVersion The browser version.
	 * @throws InterruptedException Thrown when a thread is interrupted.
	 */
	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void launchApp(String os, String osVersion, String br, String browserVersion) throws InterruptedException {
		// Launch the application
		basePage = new BasePage();
		basePage.launchApp(browser, os, osVersion, br, browserVersion);
	}

	/**
	 * Test method to perform various actions on the application.
	 *
	 * @param location        The location of the hotel.
	 * @param hotels          The hotel name.
	 * @param roomType        The room type.
	 * @param noOfRooms       The number of rooms.
	 * @param checkInDate     The check-in date.
	 * @param checkOutDate    The check-out date.
	 * @param adultPerRoom    The number of adults per room.
	 * @param childrenPerRoom The number of children per room.
	 * @throws InterruptedException Thrown when a thread is interrupted.
	 */
	@Test(dataProvider = "getData", dependsOnMethods = "launchApp")
	@Parameters({ "location", "hotels", "roomType", "noOfRooms", "checkInDate", "checkOutDate", "adultPerRoom",
			"childrenPerRoom", "firstName", "lastName", "billingAddress", "creditCardNumber", "creditType",
			"expiryMonth", "expiryYear", "ccv" })
	public void performActions(String location, String hotels, String roomType, String noOfRooms, String checkInDate,
			String checkOutDate, String adultPerRoom, String childrenPerRoom, String firstName, String lastName,
			String billingAddress, String creditCardNumber, String creditType, String expiryMonth, String expiryYear,
			String ccv) throws InterruptedException {
		// Initialize Page Objects
		homePage = new HomePage();
		welcomePage = new WelcomePage();
		hotelSelectionPage = new HotelSelectionPage();
		bookAHotelPage = new BookAHotelPage();
		bookingConfirmation = new BookingConfirmation();
		bookedItinerary = new BookedItinerary();

		// Home Page Actions
		homePage.verifyTitle(browser);
		homePage.enterUserName(browser);
		homePage.enterPassword(browser);
		homePage.clickLogIn(browser);

		// Welcome Page Actions
		welcomePage.selectLocation(browser, location);
		welcomePage.selectHotels(browser, hotels);
		welcomePage.selectRoomType(browser, roomType);
		welcomePage.selectNumberOfRooms(browser, noOfRooms);
		welcomePage.enterCheckInCheckOutDate(browser, checkInDate, checkOutDate);
		welcomePage.enterAdultsPerRoom(browser, adultPerRoom);
		welcomePage.enterChildrenPerRoom(browser, childrenPerRoom);
		welcomePage.clickSearch(browser);

		// Hotel Selection Page Actions
		hotelSelectionPage.selectHotel(browser);
		hotelSelectionPage.clickContinue(browser);

		// Book A Hotel Page Actions
		bookAHotelPage.enterFirstName(browser, firstName);
		bookAHotelPage.enterLastName(browser, lastName);
		bookAHotelPage.enterAddress(browser, billingAddress);
		bookAHotelPage.enterCreditCardNo(browser, creditCardNumber);
		bookAHotelPage.selectCardType(browser, creditType);
		bookAHotelPage.selectMonth(browser, expiryMonth);
		bookAHotelPage.selectYear(browser, expiryYear);
		bookAHotelPage.enterCCVNumber(browser, ccv);
		bookAHotelPage.clickOnBookNow(browser);

		// Booking Confirmation Page Actions
		bookingConfirmation.getOrderNo(browser);
		bookingConfirmation.clickItinerary(browser);

		// Booked Itinerary Page Actions
		bookedItinerary.enterSearchID(browser);
		bookedItinerary.clickGO(browser);
		bookedItinerary.idDetails(browser);
		bookedItinerary.clickLogOut(browser);
		bookedItinerary.clickOnLogInAgain(browser);
	}
}
