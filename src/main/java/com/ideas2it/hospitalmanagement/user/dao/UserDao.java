package com.ideas2it.hospitalmanagement.user.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.user.model.User;

/**
 * <p>
 * UserDao is a Data-Access-Object interface, which is used to provide data access to implement
 * database manipulation operations on User data. It uses a table from Database to store the user
 * Information.
 * </p>
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public interface UserDao {

    /**
     * <p>
     * This Method is used to insert a new User.
     * </p>
     *
     * @param user a User object with the email and password to be inserted.
     * @return boolean a boolean value indicating the successful insertion of a new User.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              retrieving an user.
     */
    public Boolean insertUser(User user) throws ApplicationException;

    /**
     * <p>
     * This Method is used to search for an User. Returns the User object if a match is found with same
     * id, else returns null.
     * </p>
     *
     * @param email a String indicating the email of the user that is to be searched an returned.
     * @return user an User object which has same id is returned.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              searching an user.
     */
    public User searchUserByEmail(String email) throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain an arraylist of all the users that are currently present.
     * </p>
     *
     * @return users an Arraylist consisting of all the users is returned.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */
    public List<User> getAllUsers() throws ApplicationException;

    /**
     * <p>
     * This Method is used to update the details of an User. Returns true if the entry is modified, else
     * returns false.
     * <p>
     *
     * @param user an User object is passed with the details to be updated.
     * @return boolean a boolean value is returned whether the operation is successful or not.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              updating an user.
     */
    public boolean updateUser(User user) throws ApplicationException;

    /**
     * <p>
     * This Method is used to delete an User. Returns true if the entry is removed, else returns false.
     * </p>
     *
     * @param user an User object that is to be deleted from the database table.
     * @return boolean a boolean value is returned whether the operation to remove is successful or not.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              deleting an user.
     */
    public boolean deleteUser(User user) throws ApplicationException;

    /**
     * <p>
     * This Method is used to search for an user. Returns the user object if a match is found with same
     * id, else returns null.
     * </p>
     *
     * @param id an Integer to identify the required User Object by the ID of User.
     * @return user an User object which has same id is returned.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              searching an user.
     */
    public User searchUserById(Integer id) throws ApplicationException;

    /**
     * <p>
     * This Method is used to re-activate an user who has been deleted. Returns true if the operation is
     * successful.
     * </p>
     *
     * @param user an User object to be restored.
     * @return boolean a boolean value is returned whether the operation to modify is successful or not.
     * @throws ApplicationException A Custom Exception created for catching exceptions that occur while
     *                              modifying an user.
     */
    public boolean restoreUser(User user) throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain an arraylist of all selected users.
     * </p>
     *
     * @param ids an Array of integers containing the id of users that are to be retrieved.
     * @return users a List consisting of all the required users is returned.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */
    public List<User> getUsersByIds(Integer[] ids) throws ApplicationException;

    /**
     * <p>
     * This Method is used to obtain an List of all selected users based on a Query and Role
     * </p>
     *
     * @param query a String indicating the query to be satisfied by user Email.
     * @param role  a String indicating the role to be satisfied on obtaining.
     * @return users a List consisting of all the required users is returned.
     * @throws ApplicationException An exception created for catching exceptions that occur while
     *                              displaying all users.
     */
    public List<User> getUsersByQuery(String query, String role) throws ApplicationException;

}
