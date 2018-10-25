package com.ideas2it.hospitalmanagement.user.service;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.user.model.User;
import com.ideas2it.hospitalmanagement.visit.model.Visit;




/**
 * </p>
 * UserServiceImpl is a Service-class used to provide logic to User operations. All the methods in
 * this class throws Application Exception. Exceptions are thrown if the input data is null. Beans
 * are injected during runtime using Spring IOC.
 * </p>
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public interface UserService {

    /**
     * <p>
     * This Method is used to add a new User.
     * </p>
     *
     * @param user a User object with the email and password to be added.
     * @return boolean a boolean value indicating the successful addition of a new User.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              retrieving an user.
     */
    public Boolean addUser(User user) throws ApplicationException;

    /**
     * <p>
     * This Method is used to search a User Entry and return the User object. It returns null if no
     * match is found.
     * </p>
     *
     * @param email a String indicating the email of the user that is to be searched an returned.
     * @return user an User object is returned if a valid match is found, else returns null.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              retrieving an user.
     */
    public User retrieveUserByEmail(String email) throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain all the user details using an list. Returns an empty list if no
     * users are added.
     * </p>
     *
     * @return users a list consisting of all the users that are added.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              retrieving all users.
     */
    public List<User> retrieveAllUsers() throws ApplicationException;

    /**
     * <p>
     * This Method is used to modify the details of an existing user with updated details provided by
     * the user. Returns true if the user information is updated, else returns false if the operation
     * fails.
     * </p>
     *
     * @param newUser an User object is passed with the id of the old User which is used as a reference.
     * @return boolean a boolean value is returned whether the operation to modify is successful or not.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              modifying an user.
     */
    public boolean modifyUser(User newUser) throws ApplicationException;

    /**
     * <p>
     * This Method is used to re-activate an user who has been deleted. Returns true if the operation is
     * successful.
     * </p>
     *
     * @param id an integer indicating the id of the user to be reinstated.
     * @return boolean a boolean value is returned whether the operation to modify is successful or not.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              modifying an user.
     */
    public boolean restoreUser(int id) throws ApplicationException;

    /**
     * <p>
     * This Method is used to delete an user entry. Returns true if the entry is removed, else returns
     * false if the entry is not found.
     * </p>
     *
     * @param id an Integer containing the id of the User object which is to be deleted.
     * @return boolean a boolean value is returned whether the removal of the user is successful or not.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              deleting an user.
     */
    public boolean deleteUser(Integer id) throws ApplicationException;

    /**
     * <p>
     * This Method is used to search an User Entry and return the User object. It returns null if no
     * match is found.
     * </p>
     *
     * @param id an Integer indicating the id of the user that is to be searched an returned.
     * @return user an User object is returned if a valid match is found, else returns null.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              retrieving an user.
     */
    public User retrieveUserById(Integer id) throws ApplicationException;

    /**
     * <p>
     * This Method is used to retrieve an list of all selected users.
     * </p>
     *
     * @return ids an Array of integers containing the id of users that are to be retrieved.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */

    /**
     * <p>
     * This Method is used to retrieve an list of all selected users.
     * </p>
     * 
     * @param ids an Array of integers containing the id of users that are to be retrieved.
     * @return users A list of user Objects returned with the required set of Users.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */
    public List<User> retrieveUsersByIds(Integer[] ids) throws ApplicationException;

    /**
     * <p>
     * This Method is used to retrieve an list of all selected users.
     * </p>
     * 
     * @param query a String indicating the query for which the email id is to be matched.
     * @param role  a String indicating the role of the user to be matched in the database query.
     * @return users A list of user Objects returned with the required set of Users.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */
    public List<User> retrieveUsersByQuery(String query, String role) throws ApplicationException;




    /**
     * <p>
     * This Method is used to retrieve all the visits based on the status.
     * </p>
     * 
     * @param  status   status of the patients to be searched
     * @return users A list of user Objects returned with the required set of Users.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */
    public List<Visit> getAllVisitsByPatientType(String status) throws ApplicationException;

}
