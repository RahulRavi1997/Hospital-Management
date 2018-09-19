package com.ideas2it.hospitalmanagement.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * <p>
 * DateUtil is used to make operations on Date datatype such as calculating age or converting input
 * date into required formats.
 * </p>
 *
 * @author : Rahul Ravi
 * @version : 1.0
 */
public final class DateUtil {

    private DateUtil() {
    }

    /**
     * <p>
     * This Method is used to calculate the difference(in years) between current date and the given
     * input Date. Returns null if the given input Date is not valid.
     * </p>
     *
     * @param inputDate Date datetype containing input Date given by the user.
     * @return Integer an Integer datatype containing the calculated age from the given input Date.
     */
    public static Integer getYearDifference(final Date inputDate) {

        if (null == inputDate) {
            return null;
        }
        final Integer inputYear = LocalDate.parse(new SimpleDateFormat(Constants.REVERSED_DATE_FORMAT).format(inputDate))
                .getYear();
        final Integer currentYear = LocalDate
                .parse(new SimpleDateFormat(Constants.REVERSED_DATE_FORMAT).format(Calendar.getInstance().getTime()))
                .getYear();
        if ((currentYear - inputYear) < 0) {
            return null;
        }
        return (currentYear - inputYear);
    }
}
