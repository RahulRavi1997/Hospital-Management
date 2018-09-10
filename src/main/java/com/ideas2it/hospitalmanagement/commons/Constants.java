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
    public static final String ID_NOT_NULL = "Input Id is Null.";
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
    
    public static final String PHYSICIAN_ADDITION_EXCEPTION = 
            "Error while adding a physician- Name:%s %s\n";
    public static final String PHYSICIAN_SEARCH_EXCEPTION = 
            "Error while searching physician id %d\n";
    public static final String PHYSICIAN_DELETE_EXCEPTION = 
            "Error while deleting physician id %d\n";
    public static final String PHYSICIAN_EDIT_EXCEPTION = 
            "Error while modifying physician id %d\n";
    public static final String PHYSICIAN_DISPLAY_EXCEPTION = 
            "Error while displaying physicians\n";
    public static final String PHYSICIAN_RESTORE_EXCEPTION = 
            "Error while restoring physician id %d\n";

}
