package com.ideas2it.hospitalmanagement.commons;

/**
 * Constants Class is used to store all the constants in other parts of the
 * application. It is created to reduce repeated Strings and code Size.
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public final class Constants {

	private Constants() {
	}

	public static final String ID_NOT_NULL = "Input Id is Null.";
	public static final String REVERSED_DATE_FORMAT = "yyyy-MM-dd";
	public static final String LOGGER_PROPERTIES_LOCATION = "src/main/resources/log4j.xml";
	public static final String HIBERNATE_CONFIG_FILE = "hibernate.cfg.xml";
	public static final String NAME = "name";
	public static final String ROLE = "role";
	public static final String EMAIL = "email";
	public static final String STYLES = "styles";
	public static final String IMAGES = "images";
	public static final String SCRIPT = "script";
	public static final String SIGNUP = "signup";
	public static final String LOGIN = "login";
	public static final String LOGIN_PATH = "/login";
	public static final String INDEX_PATH = "/WEB-INF/views/index.jsp";
	public static final String SIGNIN_EMAIL = "signinEmail";
	public static final String DATABASE_FAILURE = "Database Connection Error has Occured";
	public static final String ADMIN = "admin";

	public static final String PHYSICIAN_ADDITION_EXCEPTION = "Error while adding a physician- Name:%s %s\n";
	public static final String PHYSICIAN_SEARCH_EXCEPTION = "Error while searching physician id %d\n";
	public static final String PHYSICIAN_DELETE_EXCEPTION = "Error while deleting physician id %d\n";
	public static final String PHYSICIAN_EDIT_EXCEPTION = "Error while modifying physician id %d\n";
	public static final String PHYSICIAN_DISPLAY_EXCEPTION = "Error while displaying physicians\n";
	public static final String PHYSICIAN_RESTORE_EXCEPTION = "Error while restoring physician id %d\n";
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

	public static final String SIGNUP_PATH = "/signup";
	public static final String PASSWORD = "password";
	public static final String INVALID_INPUT = "Not a Valid Input";
	public static final String SIGN_UP_SUCCESS = "signUpSuccess";
	public static final String SIGN_UP_SUCCESS_MESSAGE = "User successfully Registered!";
	public static final String SIGN_UP_FAIL = "signUpFail";
	public static final String SIGN_UP_FAIL_MESSAGE = "User Registration Failed! Try again Later";
	public static final String LOGIN_JSP = "login";
	public static final String SIGNIN = "signin";
	public static final String SIGNIN_PASSWORD_FAIL_MESSAGE = "Sign-in Failed! Passwords Dont Match";
	public static final String SIGNIN_USER_FAIL_MESSAGE = "Sign-in Failed! User already registered";
	public static final String USER_FAIL = "userFail";
	public static final String USER_ADD_EXCEPTION = "Error while adding User! Try Again later!";
	public static final String USER_ADDITION_EXCEPTION = "Error while adding a user- Name:%s\n";
	public static final String USER_SEARCH_EXCEPTION = "Error while searching user %s\n";
	public static final String USER_DISPLAY_EXCEPTION = "Error while displaying users\n";
	public static final String DISPLAY_USER_MAPPING = "/displayUsers";
	public static final String RESTORE_USER_MAPPING = "/restoreUser";

	public static final String ACTIVE = "active";
	public static final String USERS = "users";
	public static final String DISPLAY_USERS_JSP = "DisplayUsers";
	public static final String USER_EDIT_EXCEPTION = "Error Occured while updating User %d";
	public static final String USER_RESTORE_SUCCESS_MESSAGE = "User Restored Successfully!";
	public static final String SEARCH_USER_JSP = "SearchUser";
	public static final String USER = "user";
	public static final String USER_RESTORE_EXCEPTION = "Error Occured while restoring User- %d ";
	public static final String MODIFY_USER_MAPPING = "/modifyUser";
	public static final String CREATE_USER_JSP = "CreateUser";
	public static final String UPDATE_USER_MAPPING = "/updateUser";
	public static final String USER_UPDATE_SUCCESS_MESSAGE = "User Updated Successfully!";
	public static final String DELETE_USER_MAPPING = "/deleteUser";
	public static final String USER_DELETE_EXCEPTION = "Error Occured while deleting User- %d ";
	public static final String USER_DELETE_SUCCESS_MESSAGE = "User deleted Successfully!";
	public static final String DISPLAY_USER_JSP = "DisplayUsers";
	public static final String USER_EMAIL = "UserEmail";
   public static final String CREATE_PATIENT = "/createPatient";
   public static final String ADD_PATIENT = "/addPatient";
   public static final String MODIFY_PATIENT = "/modifyPatient";
   public static final String UPDATE_PATIENT = "/updatePatient";
   public static final String DELETE_PATIENT = "/deletePatient";
   public static final String SEARCH_PATIENT = "/searchPatient";
   public static final String DISPLAY_PATIENTS = "/displayPatients";
   public static final String ACTIVATE_PATIENT = "/activatePatient";
   
   public static final String PATIENT = "/patient";
   public static final String PATIENTS = "/patients";
   public static final String CREATE_PATIENT_JSP ="CreatePatient";
   public static final String SEARCH_PATIENT_JSP ="SearchPatient";
   public static final String DISPLAY_PATIENT_JSP ="DisplayPatients";

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
   public static final String PATIENT_ID = "patientId";
   public static final String PHYSICIAN_ID = "physicianId";
   public static final String PATIENT_OBJECTS = "patients";

   public static final String CREATE_VISIT = "/createVisit";
   public static final String ADD_VISIT = "/addVisit";
   public static final String MODIFY_VISIT = "/modifyVisit";
   public static final String UPDATE_VISIT = "/updateVisit";
   public static final String DELETE_VISIT = "/deleteVisit";
   public static final String SEARCH_VISIT = "/searchVisit";
   public static final String DISPLAY_VISITS = "/displayVisits";
   public static final String ACTIVATE_VISIT = "/activateVisit";
   
   public static final String VISIT = "/visit";
   public static final String VISITS = "/visits";
   public static final String CREATE_VISIT_JSP ="CreateVisit";
   public static final String SEARCH_VISIT_JSP ="SearchVisit";
   public static final String DISPLAY_VISIT_JSP ="DisplayVisit";

   public static final String VISIT_ADD_FAILED = "Visit Addition Failed";
   public static final String VISIT_UPDATE_FAILED = "Visit Updation Failed";
   public static final String VISIT_DELETE_FAILED = "Visit Deletion Failed";
   public static final String VISIT_SEARCH_FAILED = "Visit Search Failed";
   public static final String VISIT_DISPLAY_FAILED = "Visit Display Failed";
   public static final String VISIT_ACTIVATION_FAILED = "Visit Activation Failed";
   
   public static final String VISIT_ADDITION_EXCEPTION = 
           "Error while adding a visit- Name:%s %s\n";
   public static final String VISIT_SEARCH_EXCEPTION = 
           "Error while searching visit id %d\n";
   public static final String VISIT_DELETE_EXCEPTION = 
           "Error while deleting visit id %d\n";
   public static final String VISIT_EDIT_EXCEPTION = 
           "Error while modifying visit id %d\n";
   public static final String VISIT_DISPLAY_EXCEPTION = 
           "Error while displaying visits\n";
   public static final String VISIT_RESTORE_EXCEPTION = 
           "Error while restoring visit id %d\n";
   public static final String VISIT_OBJECT = "visit";
   public static final String VISIT_OBJECTS = "visits";
   public static final int SESSION_ACTIVE_INTERVAL = 30*60;

   public static final String MEDICINE_ADDITION_EXCEPTION = 
            "Error while adding an medicine medicine = %s";
    public static final String MEDICINE_SEARCH_EXCEPTION = 
            "Error while searching medicine medicineId = %d";
    public static final String MEDICINE_DELETE_EXCEPTION = 
            "Error while deleting medicine medicineId = %d";
    public static final String MEDICINE_UPDATE_EXCEPTION = 
            "Error while modifying medicine medicineId = %d";
    public static final String MEDICINE_DISPLAY_EXCEPTION = 
            "Error while displaying medicines medicineId = %d";
    public static final String ERROR = "error"; 
    public static final String MEDICINES = "medicines";
    public static final String MEDICINE = "medicine";
    public static final String MEDICINE_MAIN_JSP = "medicine_main";
    public static final String CREATE_MEDICINE_JSP = "create_medicine";
    public static final String DISPLAY_MEDICINE_JSP = "display_medicine";
    public static final String UPDATE_MEDICINE_JSP = "update_medicine";
    public static final String CREATE_MEDICINE_MAPPING = "/create_medicine";
    public static final String ADD_MEDICINE_MAPPING = "/add_medicine";
    public static final String DISPLAY_MEDICINE_MAPPING = "/display_medicine"; 
    public static final String SEARCH_MEDICINE_MAPPING = "/search_medicine";
    public static final String UPDATE_MEDICINE_MAPPING = "/update_medicine";
    public static final String MODIFY_MEDICINE_MAPPING = "/modify_medicine";
    public static final String DELETE_MEDICINE_MAPPING = "/delete_medicine";
    public static final String RESTORE_MEDICINE_MAPPING = "/restore_medicine";

    public static final String PURCHASE_ADDITION_EXCEPTION = 
            "Error while adding an purchase purchase = %s";
    public static final String PURCHASE_SEARCH_EXCEPTION = 
            "Error while searching purchase purchaseId = %d";
    public static final String PURCHASE_DELETE_EXCEPTION = 
            "Error while deleting purchase purchaseId = %d";
    public static final String PURCHASE_UPDATE_EXCEPTION = 
            "Error while modifying purchase purchaseId = %d";
    public static final String PURCHASE_DISPLAY_EXCEPTION = 
            "Error while displaying medicines purchaseId = %d";
    public static final String PURCHASES = "purchases";
    public static final String PURCHASE = "purchase";
    public static final String PURCHASE_MAIN_JSP = "purchase_main";
    public static final String CREATE_PURCHASE_JSP = "create_purchase";
    public static final String DISPLAY_PURCHASE_JSP = "display_purchase";
    public static final String UPDATE_PURCHASE_JSP = "update_purchase";
    public static final String CREATE_PURCHASE_MAPPING = "/create_purchase";
    public static final String ADD_PURCHASE_MAPPING = "/add_purchase";
    public static final String DISPLAY_PURCHASE_MAPPING = "/display_purchase"; 
    public static final String SEARCH_PURCHASE_MAPPING = "/search_purchase";
    public static final String UPDATE_PURCHASE_MAPPING = "/update_purchase";
    public static final String MODIFY_PURCHASE_MAPPING = "/modify_purchase";
    public static final String DELETE_PURCHASE_MAPPING = "/delete_purchase";   
    public static final String RESTORE_PURCHASE_MAPPING = "/restore_purchase";
}
