/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.dvdlibrary.dao;

/**
 *
 * @author Joy Gilbuena
 * @email princesajoy23@gmail.com
 * 
 * 
 */// error class
public class DVDLibraryDaoException extends Exception { // handles the disruption of the application. 
                                                        //Inherited from Exception

    public DVDLibraryDaoException(String message) {
        super(message);
    }

    public DVDLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
