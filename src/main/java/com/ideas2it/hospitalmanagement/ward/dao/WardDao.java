package com.ideas2it.hospitalmanagement.ward.dao;

import java.util.List;

import com.ideas2it.hospitalmanagement.ward.model.Ward;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;

/**
 * <p>
 * WardDAO is an interface which holds methods for creation,updation and retrieval of wards.
 * </p>
 * @author Latheesh
 *
 */
public interface WardDao {
    
    /**
     *  <p>
     *  insertWard is a method which inserts a ward object inside the
     *  database.
     *  </p>
     *  
     *  @param ward                             Ward object
     *  
     *  @return boolean
     */
    public boolean insertWard(Ward ward) throws ApplicationException;
    
    /**
     *  <p>
     *  updateWard is a method which updates a ward object inside the
     *  database.
     *  </p>
     *  
     *  @param ward                             Ward object
     *  
     *  @return boolean
     */
    public boolean updateWard(Ward ward) throws ApplicationException;
    
    /**
     *  <p>
     *  searchWardByNumber is a method retrieves a ward object for a given
     *  ward number.
     *  </p>
     *  
     *  @param ward                             Ward object
     *  @param attributeName                     Attribute name
     *  @param attributeValue                     Attribute value
     *  
     *  @return Ward                            Ward object
     */
    public Ward searchWard(Ward ward,String attributeName,Object attributeValue) 
                                                throws ApplicationException;
    
    /**
     *  <p>
     *  getAllWards is a method which retreives all the wards present in
     *  the database.
     *  </p>
     *  
     *  @param ward                             Ward object
     *  
     *  @return boolean
     */
    public List<Ward> getAllWards() throws ApplicationException;
}