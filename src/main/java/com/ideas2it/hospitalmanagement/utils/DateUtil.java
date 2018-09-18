package com.ideas2it.hospitalmanagement.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;

import com.ideas2it.hospitalmanagement.commons.Constants;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * <p>
 * DateUtil is used to make operations on Date datatype such as calculating
 * age or converting input date into required formats.
 * </p>
 *
 * @author  : Rahul Ravi
 * @version : 1.0
 */
public final class DateUtil {

    private DateUtil() {
    }

    /**
     * <p>
<<<<<<< HEAD
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


    /**
     * <p>
=======
>>>>>>> c9685044de28e7396927885e32058203e0e70b1e
     * This Method is used to calculate the difference(in years) between current
     * date and the given input Date. Returns null if the given input Date is
     * not valid.
     * </p>
     *
     * @param inputDate Date datetype containing input Date given by the user.
     *
     * @return Integer an Integer datatype containing the calculated age from
     *                 the given input Date.
     */
    public static Integer getYearDifference(final Date inputDate) {

        if (null == inputDate) {
            return null;
        }
        Integer inputYear = LocalDate.parse(new SimpleDateFormat(
            Constants.REVERSED_DATE_FORMAT).format(inputDate)).getYear();
        Integer currentYear = LocalDate.parse(new SimpleDateFormat(Constants
            .REVERSED_DATE_FORMAT).format(Calendar.getInstance().getTime())).getYear();
        if ((currentYear - inputYear) < 0) {
            return null;
        }
        return (currentYear - inputYear);
    }

}
