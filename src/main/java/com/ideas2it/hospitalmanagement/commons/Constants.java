package com.ideas2it.hospitalmanagement.commons;

/**
 * Constants Class is used to store all the constants in other parts of the 
 * application. It is created to reduce repeated Strings and code Size.
 *
 * @author   Rahul Ravi
 * @version  1.0
 */
public final class Constants {

    private Constants() {
    }
    public static final String LOGGER_PROPERTIES_LOCATION =
            "log4j.xml";
    public static final String HIBERNATE_CONFIG_FILE =
            "hibernate.cfg.xml";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String EMAIL = "email";
    public static final String STYLES = "styles";
    public static final String IMAGES = "images";
    public static final String SCRIPT = "script";
    public static final String SIGNUP = "signup";
    public static final String LOGIN = "login";
    public static final String LOGIN_PATH = "/login";
    public static final String MAIN_MENU_PATH = "/main_menu";
    public static final String INDEX_PATH = "/WEB-INF/views/index.jsp";
    public static final String SIGNIN_EMAIL = "signinEmail";
    public static final String DATABASE_FAILURE = "Database Connection Error has Occured";
}
