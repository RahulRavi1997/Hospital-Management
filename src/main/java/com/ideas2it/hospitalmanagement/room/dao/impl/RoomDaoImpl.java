package com.ideas2it.hospitalmanagement.room.dao.impl;


import com.ideas2it.hospitalmanagement.room.dao.RoomDao;
import com.ideas2it.hospitalmanagement.room.common.Constants;
import com.ideas2it.hospitalmanagement.room.model.Room;
import com.ideas2it.hospitalmanagement.exception.ApplicationException;
import com.ideas2it.hospitalmanagement.genericdao.GenericDao;
import com.ideas2it.hospitalmanagement.logger.Logger;
/**
 * <p>
 * RoomDAOImpl class takes of creation of rooms.
 * </p>
 * @author Latheesh
 *
 */
public class RoomDaoImpl extends GenericDao implements RoomDao{
    
    /**
     *  {@inheritDoc}
     */
    public boolean insertRoom(Room room)  throws ApplicationException{
        try {
            return (null != super.save(room));
        } catch (ApplicationException e) {
            Logger.error(Constants.ROOM_NOT_ADDED, e);
            throw new ApplicationException(Constants.ROOM_NOT_ADDED, e);
        }
    }
 }