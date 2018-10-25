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

	public static final String DISPLAY_PHYSICIANS_BY_SPECIALISATIONS_MAPPING = "/displayPhysiciansBySpecialisation";
	public static final String SPECIALISATION_NAME = "specialisationName";
	public static final String LOGOUT_PATH = "/logout";
	public static final String ID_NOT_NULL = "Enter valid id please!";

	public static final String CLIENT_UNIQUE_KEY_EXCEPTION = "Email-%s already exists! \nError while adding client\n";

	public static final String DIAGNOSIS = "diagnosis";
	public static final String SEARCH_DIAGNOSIS_JSP = "DisplayDiagosis";
	public static final String ADD_DIAGNOSIS_MAPPING = "/add_diagnosis";
	public static final String DIAGNOSIS_ADDITION_EXCEPTION = "Error while adding the Diagnosis information ID:%d\n";

	public static final String CREATE_DIAGNOSIS_JSP = "CreateDiagnosis";

	public static final String CREATE_DIAGNOSIS_MAPPING = "/create_diagnosis";

	public static final String DIAGNOSIS_EDIT_EXCEPTION = "Error while modifying diagnosis id %d\n";

	public static final String DIAGNOSIS_DISPLAY_EXCEPTION = "Error while displaying diagnosis details\n";

	// String to display when adding employee is successful
	public static final String ENTRY_ADDED = "Entry Added";

	// String to display when employee addition is not successful
	public static final String ADDITION_FAILED = "Addtion Failed. Check ID.";

	// String to display when removing employee is successful
	public static final String ENTRY_REMOVED = "Entry Removed";

	public static final String UPDATE_VISIT_JSP = "UpdateVisit";
	public static final int SESSION_ACTIVE_INTERVAL = 30 * 60;
	public static final String SEARCH_USER_MAPPING = "/searchUser";

	public static final String JSON_TYPE = "application/json";
	public static final String XML_TYPE = "application/xml";
	public static final String FORM_HEADER = "content-type=application/x-www-form-urlencoded";
	public static final String DISPLAY_USERS_MAPPING = "displayUserAutocomplete";
	public static final String INDEX_MAPPING = "/index";
	public static final String ADMIN_INDEX = "Admin";
	public static final String PHYSICIAN_INDEX = "displayVisit";
	public static final String NURSE_INDEX = "nurseHome";
	public static final String RECEPTIONIST_INDEX = "Receptionist";
	public static final String ACCESS_DENIED_JSP = "AccessDenied";
	public static final Object ADMIN_ROLE = "ROLE_ADMIN";
	public static final Object PHYSICIAN_ROLE = "ROLE_PHYSICIAN";
	public static final Object NURSE_ROLE = "ROLE_NURSE";
	public static final Object RECEPTIONIST_ROLE = "ROLE_RECEPTIONIST";
	public static final String ACCESS_DENIED_MAPPING = "/Access_Denied";
	public static final String LOGOUT_SUCCESS_MAPPING = "/logoutSuccessful";
	public static final String EMPTY_URI = "/";
	public static final String CREATE_USER_MAPPING = "/createUser";
	public static final String ROLES = "roles";
	public static final String NUMBER_OF_USERS = "numberOfUsers";
	public static final String USER_DISPLAY_JSP = "DisplayUsers";
	public static final String QUERY = "query";
	public static final String YET_TO_ADMIT = "Yet To Visit";
	public static final String SEARCH_PATIENT_BY_NAME = "/searchPatientByName";
	public static final String SEARCH_VISIT_BY_PATIENTID = "/searchVisitByPatientId";
	public static final String SEARCH_VISIT_FOR_PATIENT = "/searchVisitForPatient";
	public static final String TYPES = "types";
	public static final String SPECIALISATIONS = "specialisations";
	public static final String GENDERS = "genders";
	public static final String JSON_FORMAT = "application/json";
	public static final String XML_FORMAT = "application/xml";
	public static final String JSON_HEADERS = "content-type=application/x-www-form-urlencoded";
	public static final String INVALID_TYPE = "Invalid type: ";
	public static final String INVALID_GENDER = "Invalid Gender: ";
	public static final String PERCENTAGE = "%";
	public static final String INVALID_ROLE = "Invalid role: ";
	public static final String INVALID_SPECIALISATION = "Invalid specialisation: ";
	public static final String PATIENT_INACTIVE = "PatientInActive";
	public static final String PATIENT_INACTIVE_MESSAGE = "Patient is Not Active. Visit Cannot be Created";
	public static final String ITEM_DELETE_EXCEPTION = "Error while deleting item itemId = %d";
	public static final String ITEM_UPDATE_EXCEPTION = "Error while modifying item itemId = %d";
	public static final String ITEMS = "items";
	public static final String ITEM_MAIN_JSP = "item_main";
	public static final String DISPLAY_ITEM_JSP = "display_item";
	public static final String UPDATE_ITEM_JSP = "update_item";
	public static final String CREATE_ITEM_MAPPING = "/create_item";
	public static final String DISPLAY_ITEM_MAPPING = "/display_item";
	public static final String SEARCH_ITEM_MAPPING = "/search_item";
	public static final String MODIFY_ITEM_MAPPING = "/modify_item";
	public static final String DELETE_ITEM_MAPPING = "/delete_item";
	public static final String PURCHASE_ADDITION_EXCEPTION = "Error while adding an purchase purchase = %s";
	public static final String PURCHASE_SEARCH_EXCEPTION = "Error while searching purchase purchaseId = %d";
	public static final String PURCHASE_DELETE_EXCEPTION = "Error while deleting purchase purchaseId = %d";
	public static final String PURCHASE_UPDATE_EXCEPTION = "Error while modifying purchase purchaseId = %d";
	public static final String PURCHASE_DISPLAY_EXCEPTION = "Error while displaying items purchaseId = %d";
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
	public static final String REMOVAL_FAILED = "Removal Failed. Check ID.";
	public static final String DISPLAY_PATIENT_JSP = "DisplayPatients";
	public static final String PHYSICIAN_VISITS = "/physicianVisit";
	public static final String PHYSICIAN_DISPLAY_VISIT_JSP = "displayVisit";
	public static final String USER_EMAIL = "UserEmail";

	public static final String RESTORE_USER_MAPPING = "/restoreUser";

	public static final String EDIT_FAILED = "Modification Failed. Check ID.";

	public static final String SEARCH_FAILED = "Search Failed. Check ID.";

	// String to display if search returns null
	public static final String NOT_FOUND = "No such Entry Found";

	public static final String DISPLAY_FAILED = "Display Operation failed";

	public static final String DELETE_FAILED = "DELETE Operation failed. Check ID.";

	// String to display when no entries are found
	public static final String EMPTY = "No entries found";

	public static final String USER_ID = "userId";
	public static final String MEDICINE_ADDITION_EXCEPTION = "Error while adding an medicine medicine = %s";
	public static final String MEDICINE_SEARCH_EXCEPTION = "Error while searching medicine medicineId = %d";
	public static final String MEDICINE_DELETE_EXCEPTION = "Error while deleting medicine medicineId = %d";
	public static final String MEDICINE_UPDATE_EXCEPTION = "Error while modifying medicine medicineId = %d";
	public static final String MEDICINE_DISPLAY_EXCEPTION = "Error while displaying medicines medicineId = %d";
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

	public static final String RESTORE_PURCHASE_MAPPING = "/restore_purchase";

	public static final String LOGGER_PROPERTIES_LOCATION = "log4j.xml";
	public static final String HIBERNATE_CONFIG_FILE = "hibernate.cfg.xml";
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
	public static final String DATABASE_FAILURE = "Database Connection Error has Occured";
	public static final String ADMIN = "ADMIN";

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

	public static final String ENTRY_MODIFIED = "Entry modified";

	public static final String MESSAGE = "message";
	public static final String SEARCH_FAIL_MESSAGE = "No Such Physician ID- %s . Try Again";
	public static final String NUMBER_OF_PHYSICIANS = "numberOfPhysicians";

	public static final String PHYSICIAN_ADD_SUCCESS_MESSAGE = "Physician Added Successfully";
	public static final String PHYSICIAN_RESTORE_SUCCESS_MESSAGE = "Physician Restored Successfully";
	public static final String PHYSICIAN_DELETE_SUCCESS_MESSAGE = "Physician deleted Successfully";
	public static final String PHYSICIAN_UPDATE_SUCCESS_MESSAGE = "Physician Updated Successfully";

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
	public static final String CREATE_PATIENT_JSP = "CreatePatient";
	public static final String SEARCH_PATIENT_JSP = "SearchPatient";

	public static final String PATIENT_ADD_FAILED = "Patient Addition Failed";
	public static final String PATIENT_UPDATE_FAILED = "Patient Updation Failed";
	public static final String PATIENT_DELETE_FAILED = "Patient Deletion Failed";
	public static final String PATIENT_SEARCH_FAILED = "Patient Search Failed";
	public static final String PATIENT_DISPLAY_FAILED = "Patient Display Failed";
	public static final String PATIENT_ACTIVATION_FAILED = "Patient Activation Failed";

	public static final String PATIENT_ADDITION_EXCEPTION = "Error while adding a patient- Name:%s %s\n";
	public static final String PATIENT_SEARCH_EXCEPTION = "Error while searching patient id %d\n";
	public static final String PATIENT_DELETE_EXCEPTION = "Error while deleting patient id %d\n";
	public static final String PATIENT_EDIT_EXCEPTION = "Error while modifying patient id %d\n";
	public static final String PATIENT_DISPLAY_EXCEPTION = "Error while displaying patients by ids:%d\n";
	public static final String PATIENT_RESTORE_EXCEPTION = "Error while restoring patient id %d\n";
	public static final String PATIENT_OBJECT = "patient";

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
	public static final String DIAGONSIS_ADD_SUCCESS_MESSAGE = "diagnosis added succesfully..";

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
	public static final String CREATE_VISIT_JSP = "CreateVisit";
	public static final String SEARCH_VISIT_JSP = "SearchVisit";

	public static final String DISPLAY_VISIT_JSP = "DisplayVisit";

	public static final String VISIT_ADD_FAILED = "Visit Addition Failed";
	public static final String VISIT_UPDATE_FAILED = "Visit Updation Failed";
	public static final String VISIT_DELETE_FAILED = "Visit Deletion Failed";
	public static final String VISIT_SEARCH_FAILED = "Visit Search Failed";
	public static final String VISIT_DISPLAY_FAILED = "Visit Display Failed";
	public static final String VISIT_ACTIVATION_FAILED = "Visit Activation Failed";

	public static final String VISIT_ADDITION_EXCEPTION = "Error while adding a visit- Name:%s %s\n";
	public static final String VISIT_SEARCH_EXCEPTION = "Error while searching visit id %d\n";
	public static final String VISIT_DELETE_EXCEPTION = "Error while deleting visit id %d\n";
	public static final String VISIT_EDIT_EXCEPTION = "Error while modifying visit id %d\n";
	public static final String VISIT_DISPLAY_EXCEPTION = "Error while displaying visits of Ids %d\n";
	public static final String VISIT_DISPLAY_BY_PATIENT_TYPE = "Error while displaying visit of Patient Type:%s";
	public static final String VISIT_DISPLAY_BY_PATIENT_ID_EXCEPTION = "Error while displaying visit of Patient Id:%d";
	public static final String VISIT_RESTORE_EXCEPTION = "Error while restoring visit id %d\n";
	public static final String VISIT_OBJECT = "visit";
	public static final String VISIT_OBJECTS = "visits";

	public static final String DISPLAY_USER_MAPPING = "/displayUsers";
	public static final String USER_DISPLAY_EXCEPTION = "Error while displaying users\n";

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
	public static final String DIAGNOSIS_UPDATE_SUCCESS_MESSAGE = "Updated Successfully...";
	public static final String UPDATE_DIAGNOSIS_MAPPING = "updateDiagnosis";

	public static final String ADD_ITEM_MASTER_MAPPING = "/addItemMaster";

	public static final String UPDATE_ITEM_MASTER_MAPPING = "updateItemMaster";

	public static final String ITEM_MASTER = "itemMaster";
	public static final String CREATE_ITEM_MASTER = "/create_item_master";

	public static final String EDIT_ITEM_MASTER = "/edit_item_master";

	public static final String VIEW_ALL_ITEMS = "/viewAllItems";

	public static final String DISPLAY_ITEMS = "displayAllItems";

	public static final String ALL_ITEMS = "allItems";

	public static final String ADD_ITEMS = "addItemsMaster";

	public static final String CREATE_DOSAGE_MAPPING = "/addosage";

	public static final String DOSAGE = "dosage";
	public static final String DOSAGE_ID = "dosageId";

	public static final String GET_DOSAGE_MAPPING = "/getDosage";

	public static final String UPDATE_DOSAGE_MAPPING = "/updateDosage";
	public static final String DOSAGE_JSP = "Dosage.jsp";
	public static final String DOSAGE_ADD_MESSAGE = "dosage-add-msg";

	public static final String ERROR = "Error";

	public static final String DISPLAY_DOSAGE_MAPPING = "/displayDosage";

	public static final String GET_ALL_DOSAGE = "/getAllDosage";

	public static final String DOSAGE_ADD_ERROR = "Error occured while adding adding dosage";

	public static final String PRESCRIPTION_SUCCESS = "Prescribed Successfully...";

	public static final String DOSAGE_DISPLAY_ERROR = "Error occured while adding adding dosage";

	public static final String CREATE_DOSAGE = "/createDosage";
	public static final String DOSAGE_URL = "/getDosage";
	public static final String UPDATE_DOSAGE_URL = "/updateDosage";
	public static final String DISPLAY_URL = "/getAllDosage";
	public static final String WELCOME_URL = "welcome";

	public static final String DOSAGE_PAGE = "Dosage.jsp";
	public static final String ADD_DOSAGE_MSG = "dosage-add-msg";
	public static final String UPDATE_MSG = "Dosage Updated...";
	public static final String JSON = "application/json";
	public static final String APP = "application/xml";
	public static final String JSON_CONFIG = "content-type=application/x-www-form-urlencoded";

	public static final String DOSAGE_UPDATE_ERROR = "Error occured while updating dosage";

	public static final String VIEW_ITEMS = "viewItems";

	public static final String CREATE_ITEM = "create_item";

	public static final String EDIT_ITEM_MAPPING = "/edit_item";

	public static final String DISPLAY_ALL_ITEMS = "displayAllItems";

	public static final String DISPLAY_ITEM = "allItems";

	public static final String CREATE_PRESCRIPTION_MAPPING = "/createPrescription";

	public static final String VISIT_ID = "visitId";

	public static final String GET_MEDICINES_MAPPING = "/getAllMedicines";

	public static final String CREATE_PRESCRIPTION_ITEM_MAPPING = "/createItem";

	public static final String ADD_PRESCRIPTION_MAPPING = "/addPrescription";

	public static final String REMOVE_PRESCRIPTION_MAPPING = "/removePrescriptionDetail";

	public static final String CREATE_PRESCRIPTION = "create_prescription";

	public static final String PRESCRIPTION = "prescription";

	public static final String PRESCRIPTIONS = "prescriptions";

	public static final String EDIT_PRESCRIPTION_MAPPING = "/editPrescription";

	public static final String VIEW_PRESCRIPTION_MAPPING = "/ViewPrescriptions";

	public static final String VIEW_VISIT = "displayVisit";

	public static final String VISIT_TYPE = "visitType";

	public static final String UPDATE_PRESCRIPTION_MAPPING = "/updatePrescription";

	public static final String OUT_PATIENT = "Out Patient";

	public static final String DISPLAY_VISIT = "displayVisit";

	public static final String IN_PATIENT = "In Patient";

	public static final String ADD_MESSAGE = "addmsg";

	public static final String INDEX = "pharmacy";

	public static final String CREATE_ERROR = "Already Prescribed...";

	public static final String PRESCRIPTION_DISPLAY_ERROR = "Error occured while display Prescription";

	public static final String PRESCRIPTION_UPDATE_ERROR = "Error occured while updating Prescription";
	
	public static final String SEARCH_PATIENT_BYNAME="/searchPatientByName";

}
