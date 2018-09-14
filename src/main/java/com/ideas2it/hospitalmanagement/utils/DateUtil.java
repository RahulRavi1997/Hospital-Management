package com.ideas2it.hospitalmanagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;



/**
 * <p>
 * Consist of certain methods which performs operations regarding dates like 
 * obtaining the current date, calculating the year difference.
 * </p>
 *
 * @author Harish
 */
public class DateUtil {

    private static String PARSEEXCEPTION = "Error: given date cannot be parsed";

  
    /**
     * <p>
     * Converts the given input date to string format using simpledateformat.
     * </p>
     *
     * @param      inputDate     input in the form of date.
     *
     * @return                   date which is convert to the string format.
     */
    public static String convertDateToString(Date inputDate) {
       SimpleDateFormat dateFormat =
            new SimpleDateFormat(Constants.REVERSED_DATE_FORMAT);
        return (dateFormat.format(inputDate));
    }

    /**
     * <p>
     * Converts the given input String  to date format using simpledateformat.
     * </p>
     *
     * @param      inputString     input in the form of string.
     *
     * @return     date            string which is convert to the date format.
     */
    public static Date convertStringToDate(String inputString) 
            throws ApplicationException {

        SimpleDateFormat dateFormat =
            new SimpleDateFormat(Constants.REVERSED_DATE_FORMAT);
        Date date= null;
        try {
            date = dateFormat.parse(inputString);
        } catch (ParseException exception) {
            throw new ApplicationException(PARSEEXCEPTION, exception);
        }
        return date;
    }

    /**
     * <p>
     *  Get current date.
     * </p>
     *
     * @param     current date 
     */
    public static Date getCurrentDate() throws ApplicationException {
        SimpleDateFormat dateFormat = 
            new SimpleDateFormat(Constants.REVERSED_DATE_FORMAT);
	Date date = new Date();
        return convertStringToDate(dateFormat.format(date));
    }


}
