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
    public static final String REVERSED_DATE_FORMAT = "yyyy-MM-dd";
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
    public static final String CREATE_PHYSICIAN_MAPPING = "/create_physician";
    public static final String ADD_PHYSICIAN_MAPPING = "/add_physician";
    public static final String MODIFY_PHYSICIAN_MAPPING = "/modify_physician";
    public static final String UPDATE_PHYSICIAN_MAPPING = "/update_physician";
    public static final String RESTORE_PHYSICIAN_MAPPING = "/restore_physician";
    public static final String DELETE_PHYSICIAN_MAPPING = "/delete_physician";
    public static final String SEARCH_PHYSICIAN_MAPPING = "/search_physician";
    public static final String DISPLAY_PHYSICIAN_MAPPING = "/display_physicians";

    public static final String CREATE_PHYSICIAN_JSP = "create_physician";
    public static final String PHYSICIANS = "physicians";
    public static final String DISPLAY_PHYSICIAN_JSP = "display_physicians";
    public static final String ERROR_JSP = "error";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String PHYSICIAN = "physician";
    public static final String SEARCH_PHYSICIAN_JSP = "search_physician";
    public static final String ID = "id";
    public static final String FAIL_MESSAGE = "failMessage";
    
    public static final String ADDITION_FAILED = "Addtion Failed. Check ID.";
    public static final String ENTRY_REMOVED = "Entry Removed";
    public static final String REMOVAL_FAILED = "Removal Failed. Check ID.";
    public static final String ENTRY_MODIFIED = "Entry modified";
    public static final String EDIT_FAILED = "Modification Failed. Check ID.";
    public static final String SEARCH_FAILED = "Search Failed. Check ID.";
    public static final String NOT_FOUND = "No such Entry Found";
    public static final String DISPLAY_FAILED = "Display Operation failed";
    public static final String DELETE_FAILED = "DELETE Operation failed. Check ID.";
    public static final String MESSAGE = "message";
    public static final String SEARCH_FAIL_MESSAGE = "No Such Physician ID- %s . Try Again";
    public static final String NUMBER_OF_PHYSICIANS = "numberOfPhysicians";
    
    public static final String PHYSICIAN_ADD_SUCCESS_MESSAGE = "Physician Added Successfully";
    public static final String PHYSICIAN_RESTORE_SUCCESS_MESSAGE = "Physician Restored Successfully";
    public static final String PHYSICIAN_DELETE_SUCCESS_MESSAGE = "Physician deleted Successfully";
    public static final String PHYSICIAN_UPDATE_SUCCESS_MESSAGE = "Physician Updated Successfully";

}
