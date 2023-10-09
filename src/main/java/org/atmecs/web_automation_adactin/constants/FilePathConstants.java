package org.atmecs.web_automation_adactin.constants;

import java.io.File;

/**
 * This class centralizes file paths used in the automation project.
 * It provides a convenient way to manage and update file paths in one place.
 */
public class FilePathConstants {

    /** The user's home directory where the project is located. */
    public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

    /** The directory where project resources are stored, such as properties files or configuration files. */
    public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
            + "resources" + File.separator;

    /** The directory where locator-related files are stored (element locators used in automation tests). */
    public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;

    /** The directory where output files are stored, such as log files or generated reports. */
    public final static String OUTPUT_HOME = RESOURCES_HOME + "output" + File.separator;

    /** The directory where testdata files are stored, such as log files or generated reports. */
    public final static String TESTDATA_HOME = RESOURCES_HOME + "testdata" + File.separator;

    
    /** The file path for the homepage properties file. */
    public static final String HOME_PAGE_PATH = LOCATOR_HOME + "homepage.properties";

    /** The file path for the book a hotel page properties file. */
    public static final String BOOKAHOTEL_PAGE_PATH = LOCATOR_HOME + "bookahotelpage.properties";

    /** The file path for the booked itinerary page properties file. */
    public static final String BOOKEDITINERARY_PAGE_PATH = LOCATOR_HOME + "bookeditinerary.properties";

    /** The file path for the booking confirmation page properties file. */
    public static final String BOOKING_CONFIRMATION_PAGE_PATH = LOCATOR_HOME + "bookingconfirmation.properties";

    /** The file path for the hotel selection page properties file. */
    public static final String HOTEL_SELECTION_PAGE_PATH = LOCATOR_HOME + "hotelselection.properties";

    /** The file path for the welcome page properties file. */
    public static final String WELCOME_PAGE_PATH = LOCATOR_HOME + "welcome.properties";

    /** The file path for the test page properties file. */
    public static final String TESTDATA_PAGE_PATH = TESTDATA_HOME + "testdata.properties";
    
    /** The file path for the output file where data is written. */
    public static final String OUTPUT_FILE_PATH = OUTPUT_HOME + "Adactin.txt";
    
    public static final String EXCEL_INPUT_PATH = TESTDATA_HOME + "Adactin.xlsx";
    
}
