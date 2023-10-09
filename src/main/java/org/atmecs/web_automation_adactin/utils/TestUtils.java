package org.atmecs.web_automation_adactin.utils;

import java.io.IOException;
import java.util.ArrayList;

import org.atmecs.web_automation_adactin.constants.Constants;
import org.atmecs.web_automation_adactin.constants.FilePathConstants;

import com.atmecs.falcon.automation.util.parser.XlsReader;

/**
 * This class provides utility methods for fetching test data from an Excel
 * file.
 */
public class TestUtils {

	/**
	 * This method retrieves test data from an Excel file and returns it as an
	 * ArrayList of Object arrays.
	 *
	 * @return An ArrayList of Object arrays containing test data.
	 */
	public static ArrayList<Object[]> getDataProvider() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		XlsReader xlsReader = new XlsReader();

		try {
			xlsReader.setPath(FilePathConstants.EXCEL_INPUT_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int rowCount = xlsReader.getRowCount(Constants.SHEET_NAME);
		System.out.println(rowCount);

		for (int rowNum = 1; rowNum <= rowCount; rowNum++) {
			String location = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_LOCATION,
					rowNum);
			String hotels = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_HOTELS, rowNum);
			String roomType = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_ROOM_TYPE,
					rowNum);
			String noOfRooms = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_NO_OF_ROOMS,
					rowNum);
			String checkInDate = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_CHECK_IN_DATE,
					rowNum);
			String checkOutDate = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME,
					Constants.COLUMN_CHECK_OUT_DATE, rowNum);
			String adultPerRoom = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME,
					Constants.COLUMN_ADULT_PER_ROOM, rowNum);
			String childrenPerRoom = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME,
					Constants.COLUMN_CHILDREN_PER_ROOM, rowNum);
			String firstName = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_FIRST_NAME,
					rowNum);
			String lastName = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_LAST_NAME,
					rowNum);
			String billingAddress = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME,
					Constants.COLUMN_BILLING_ADDRESS, rowNum);
			String creditCardNumber = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME,
					Constants.COLUMN_CREDIT_CARD_NUMBER, rowNum);
			String creditType = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_CREDIT_TYPE,
					rowNum);
			String expiryMonth = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_EXPIRY_MONTH,
					rowNum);
			String expiryYear = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_EXPIRY_YEAR,
					rowNum);
			String ccv = xlsReader.getCellDataByColumnName(Constants.SHEET_NAME, Constants.COLUMN_CCV, rowNum);
			Object ob[] = { location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultPerRoom,
					childrenPerRoom, firstName, lastName, billingAddress, creditCardNumber, creditType, expiryMonth,
					expiryYear, ccv };
			myData.add(ob);
		}

		return myData;
	}
}
