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
    public static final String ID_NOT_NULL = "Enter valid id please!";

    public static final String CLIENT_UNIQUE_KEY_EXCEPTION = 
        "Email-%s already exists! \nError while adding client\n";
    
    public static final String DIAGNOSIS = "diagnosis";
    public static final String SEARCH_DIAGNOSIS_JSP = "display_diagnosis";
    public static final String ADD_DIAGNOSIS_MAPPING = "/add_diagnosis";
    public static final String DIAGNOSIS_ADDITION_EXCEPTION = 
            "Error while adding the Diagnosis information ID:%d\n";

    public static final String CREATE_DIAGNOSIS_JSP = "create_diagnosis";

  
    
    public static final String CREATE_DIAGNOSIS_MAPPING = "/create_diagnosis";

    public static final String DIAGNOSIS_EDIT_EXCEPTION = 
            "Error while modifying diagnosis id %d\n";
  

    public static final String DIAGNOSIS_DISPLAY_EXCEPTION = 
            "Error while displaying diagnosis details\n";

   

    //String to display when adding employee is successful
    public static final String ENTRY_ADDED = "Entry Added";

    //String to display when employee addition is not successful
    public static final String ADDITION_FAILED = "Addtion Failed. Check ID.";

    //String to display when removing employee is successful
    public static final String ENTRY_REMOVED = "Entry Removed";

    //String to display when employee removal is not successful
    public static final String REMOVAL_FAILED = "Removal Failed. Check ID.";

    

    public static final String EDIT_FAILED = "Modification Failed. Check ID.";

    public static final String SEARCH_FAILED = "Search Failed. Check ID.";

    //String to display if search returns null
    public static final String NOT_FOUND = "No such Entry Found";

    public static final String DISPLAY_FAILED = "Display Operation failed";

    public static final String DELETE_FAILED = "DELETE Operation failed. Check ID.";

    //String to display when no entries are found
    public static final String EMPTY = "No entries found";

      public static final String LOGGER_PROPERTIES_LOCATION =
            "log4j.xml";
    public static final String HIBERNATE_CONFIG_FILE =
            "hibernate.cfg.xml";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String ICU = "ICU";
    public static final String PICU = "PICU";
    public static final String GENERAL = "General";
    public static final String EMERGENCYWARD = "EmergencyWard";

    

	public static final String ADD_ITEM_MAPPING = "/add_item";

	public static final String ITEM_ADDITION_EXCEPTION = "Error while adding the item information ID:%d";

	public static final Object ITEM_ADD_SUCCESS_MESSAGE = "Item Added Successfully";

	public static final String ITEM = "item";

	public static final String CREATE_ITEM_JSP = "create_item";

	public static final String ITEM_EDIT_EXCEPTION = "Error while modifying items id %d";

	public static final String ITEM_DISPLAY_EXCEPTION = "Error while diaplaying Items";

	public static final String ITEM_SEARCH_EXCEPTION = "Item not found";

	public static final String UPDATE_ITEM_MAPPING = "/update_item";

	public static final String SEARCH_ITEM_JSP = "display_item";

	public static final String ITEM_UPDATE_SUCCESS_MESSAGE = "Item List updated successfully";

	
    public static final String REVERSED_DATE_FORMAT = "yyyy-MM-dd";
  
   
    public static final String EMAIL = "email";
    public static final String STYLES = "styles";
    public static final String IMAGES = "images";
    public static final String SCRIPT = "script";
    public static final String SIGNUP = "signup";
    public static final String LOGIN = "login";
    public static final String LOGIN_PATH = "/login";
    public static final String INDEX_PATH = "/WEB-INF/views/index.jsp";
    public static final String SIGNIN_EMAIL = "signinEmail";
    public static final String DATABASE_FAILURE =
    		"Database Connection Error has Occured";
    public static final String ADMIN = "ADMIN";

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
    public static final String CREATE_PHYSICIAN_MAPPING = "/createPhysician";
    public static final String ADD_PHYSICIAN_MAPPING = "/addPhysician";
    public static final String MODIFY_PHYSICIAN_MAPPING = "/modifyPhysician";
    public static final String UPDATE_PHYSICIAN_MAPPING = "/updatePhysician";
    public static final String RESTORE_PHYSICIAN_MAPPING = "/restorePhysician";
    public static final String DELETE_PHYSICIAN_MAPPING = "/deletePhysician";
    public static final String SEARCH_PHYSICIAN_MAPPING = "/searchPhysician";
    public static final String DISPLAY_PHYSICIAN_MAPPING = "/displayPhysicians";

    public static final String CREATE_PHYSICIAN_JSP = "CreatePhysician";
    public static final String PHYSICIANS = "physicians";
    public static final String DISPLAY_PHYSICIAN_JSP = "DisplayPhysicians";
    public static final String ERROR_JSP = "error";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String PHYSICIAN = "physician";
    public static final String SEARCH_PHYSICIAN_JSP = "SearchPhysician";
    public static final String ID = "id";
    public static final String FAIL_MESSAGE = "failMessage";
  
    public static final String ENTRY_MODIFIED = "Entry modified";
   
    public static final String MESSAGE = "message";
    public static final String SEARCH_FAIL_MESSAGE = "No Such Physician ID- %s . Try Again";
    public static final String NUMBER_OF_PHYSICIANS = "numberOfPhysicians";
    
    public static final String PHYSICIAN_ADD_SUCCESS_MESSAGE =
    		"Physician Added Successfully";
    public static final String PHYSICIAN_RESTORE_SUCCESS_MESSAGE =
    		"Physician Restored Successfully";
    public static final String PHYSICIAN_DELETE_SUCCESS_MESSAGE =
    		"Physician deleted Successfully";
    public static final String PHYSICIAN_UPDATE_SUCCESS_MESSAGE =
    		"Physician Updated Successfully";

   public static final String CREATE_PATIENT = "/createpatient";
   public static final String ADD_PATIENT = "/addpatient";
   public static final String MODIFY_PATIENT = "/modifypatient";
   public static final String UPDATE_PATIENT = "/updatepatient";
   public static final String DELETE_PATIENT = "/deletepatient";
   public static final String SEARCH_PATIENT = "/searchpatient";
   public static final String DISPLAY_PATIENTS = "/displaypatients";
   public static final String ACTIVATE_PATIENT = "/activatepatient";
   
   public static final String PATIENT = "/patient";
   public static final String PATIENTS = "/patients";
   public static final String CREATE_PATIENT_JSP ="CreatePatient";
   public static final String SEARCH_PATIENT_JSP ="SearchPatient";
   public static final String DISPLAY_PATIENT_JSP ="DisplayPatient";

   public static final String PATIENT_ADD_FAILED = "Patient Addition Failed";
   public static final String PATIENT_UPDATE_FAILED = "Patient Updation Failed";
   public static final String PATIENT_DELETE_FAILED = "Patient Deletion Failed";
   public static final String PATIENT_SEARCH_FAILED = "Patient Search Failed";
   public static final String PATIENT_DISPLAY_FAILED = "Patient Display Failed";
   public static final String PATIENT_ACTIVATION_FAILED = "Patient Activation Failed";
   
   public static final String PATIENT_ADDITION_EXCEPTION = 
           "Error while adding a patient- Name:%s %s\n";
   public static final String PATIENT_SEARCH_EXCEPTION = 
           "Error while searching patient id %d\n";
   public static final String PATIENT_DELETE_EXCEPTION = 
           "Error while deleting patient id %d\n";
   public static final String PATIENT_EDIT_EXCEPTION = 
           "Error while modifying patient id %d\n";
   public static final String PATIENT_DISPLAY_EXCEPTION = 
           "Error while displaying patients\n";
   public static final String PATIENT_RESTORE_EXCEPTION = 
           "Error while restoring patient id %d\n";
   public static final String PATIENT_OBJECT = "patient";

   public static final String SIGNUP_PATH = "/signup";
   public static final String PASSWORD = "password";
   public static final String INVALID_INPUT = "Not a Valid Input";
   public static final String SIGN_UP_SUCCESS = "signUpSuccess";
   public static final String SIGN_UP_SUCCESS_MESSAGE =
		   "User successfully Registered!";
   public static final String SIGN_UP_FAIL = "signUpFail";
   public static final String SIGN_UP_FAIL_MESSAGE =
		   "User Registration Failed! Try again Later";
   public static final String LOGIN_JSP = "login";
   public static final String SIGNIN = "signin";
   public static final String SIGNIN_PASSWORD_FAIL_MESSAGE =
		   "Sign-in Failed! Passwords Dont Match";
   public static final String SIGNIN_USER_FAIL_MESSAGE =
		   "Sign-in Failed! User already registered";
   public static final String USER_FAIL = "userFail";
   public static final String USER_ADD_EXCEPTION =
		   "Error while adding User! Try Again later!";
   public static final String USER_ADDITION_EXCEPTION = 
           "Error while adding a user- Name:%s\n";
   public static final String USER_SEARCH_EXCEPTION = 
      "Error while searching user %s\n";
   public static final String DIAGONSIS_ADD_SUCCESS_MESSAGE = 
		 "diagnosis added succesfully..";



}

