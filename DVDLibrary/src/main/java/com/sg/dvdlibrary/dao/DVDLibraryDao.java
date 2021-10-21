/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.util.List;

/**
 *
 * @author Joy Gilbuena
 * @email princesajoy23@gmail.com
 * 
 * 
 */
public interface DVDLibraryDao { // method declarations

    DVDLibrary addDVD(String title, DVDLibrary dvd)
            throws DVDLibraryDaoException;

    List<DVDLibrary> getAllDVDs()
            throws DVDLibraryDaoException;

    DVDLibrary getDVD(String title)
            throws DVDLibraryDaoException;

    DVDLibrary removeDVD(String title)
            throws DVDLibraryDaoException;

    DVDLibrary editDVD(String title, DVDLibrary dvd)
            throws DVDLibraryDaoException;
}
