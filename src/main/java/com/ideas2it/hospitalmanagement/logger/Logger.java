package com.ideas2it.hospitalmanagement.logger;

import org.apache.log4j.xml.DOMConfigurator;

import com.ideas2it.hospitalmanagement.commons.Constants;

/**
 * Logger is a custom Logger class that wraps the Imported logger to keep record of all the error
 * messages that arise while the application is running. Has constructors to log both throwable and
 * custom messages or the exception alone.
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public class Logger {

    private static org.apache.log4j.Logger logger;

    static {
        logger = org.apache.log4j.Logger.getLogger(Logger.class.getName());
        DOMConfigurator.configure(Constants.LOGGER_PROPERTIES_LOCATION);
    }

    public static void error(final String message, final Throwable cause) {
        logger.error(message, cause);
    }

    public static void error(final Throwable cause) {
        logger.error(cause);
    }

    public static void debug(final String message, final Throwable cause) {
        logger.debug(message, cause);
    }

    public static void debug(final Throwable cause) {
        logger.debug(cause);
    }

    public static void trace(final String message, final Throwable cause) {
        logger.trace(message, cause);
    }

    public static void trace(final Throwable cause) {
        logger.trace(cause);
    }

    public static void warn(final String message, final Throwable cause) {
        logger.warn(message, cause);
    }

    public static void warn(final Throwable cause) {
        logger.warn(cause);
    }

    public static void info(final String message, final Throwable cause) {
        logger.info(message, cause);
    }

    public static void info(final Throwable cause) {
        logger.info(cause);
    }
}
